/**
 * 
 */
package co.pragma.nuevosnegocios.keycenter.business;

import java.util.List;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;

import co.pragma.nuevosnegocios.keycenter.to.Door;
import co.pragma.nuevosnegocios.keycenter.to.DoorComplete;

/**
 * @author osmaga
 *
 */
public class DoorHandlerHelper {
	
	private static final GpioController gpio;
	
	static {
		gpio = GpioFactory.getInstance();
	}
	
	private static void provisionPins(DoorComplete door) {
		GpioPinDigitalInput myInput = gpio.provisionDigitalInputPin(door.getInput(),             // PIN NUMBER
												"MyButton");                   // PIN FRIENDLY NAME (optional)
		door.setMyInput(myInput);
		
		GpioPinDigitalOutput myOutput = gpio.provisionDigitalOutputPin(door.getOutput(),   // PIN NUMBER
                "My LED",           // PIN FRIENDLY NAME (optional)
                PinState.LOW);      // PIN STARTUP STATE (optional)
		myOutput.setShutdownOptions(true, PinState.LOW);
		door.setMyOutput(myOutput);
		
	}
	
	private static void unProvisionPins(DoorComplete door) {
		gpio.unprovisionPin(door.getMyInput(), door.getMyOutput());
		door.setMyInput(null);
		door.setMyOutput(null);
	}

	public static boolean doorOpener(String doorID, String doorPass) {
		DoorComplete door = Security.doAuthentication(doorID, doorPass);
		
		if (door != null) {
			System.out.println("door found!");
			provisionPins(door);
			door.getMyOutput().high();
			
			boolean doorOpened = false;
			long startTime = System.currentTimeMillis(); //fetch starting time
			while(!doorOpened || (System.currentTimeMillis() - startTime) < 5000) {
				doorOpened = door.getMyInput().isLow();
			}
			
			door.getMyOutput().low();
			
			unProvisionPins(door);
			return doorOpened;
		} else {
			System.out.println("No door found. Check password!");
		}
		return false;
	}
	
	public static boolean doorCloser(String doorID, String doorPass) {
		DoorComplete door = Security.doAuthentication(doorID, doorPass);
		
		if (door != null) {
			System.out.println("door found!");
			provisionPins(door);
			door.getMyOutput().low();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boolean isDoorClosed = door.getMyInput().isHigh();
			unProvisionPins(door);
			return isDoorClosed;
		} else {
			System.out.println("No door found. Check password!");
		}
		return false;
	}
	
	public static List<Door> listDoors() {
		List<Door> doors =  Security.getDoors();
		System.out.println("there are " + doors.size() + " doors");
		return doors;
	}
}
