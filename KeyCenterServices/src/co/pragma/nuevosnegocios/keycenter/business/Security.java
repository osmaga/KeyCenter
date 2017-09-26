/**
 * 
 */
package co.pragma.nuevosnegocios.keycenter.business;

import java.util.ArrayList;
import java.util.List;

import com.pi4j.io.gpio.RaspiPin;

import co.pragma.nuevosnegocios.keycenter.to.Door;
import co.pragma.nuevosnegocios.keycenter.to.DoorComplete;

/**
 * @author osmaga
 *
 */
public class Security {

	private static List<DoorComplete> doors;
	
	static {
		doors = new ArrayList<DoorComplete>();
		
		DoorComplete door = new DoorComplete();
		door.setName("Puerta Principal");
		door.setDoorID("2109");
		door.setPassword("12345678A");
		door.setInput(RaspiPin.GPIO_04);
		door.setOutput(RaspiPin.GPIO_01);
		doors.add(door);
		
		door = new DoorComplete();
		door.setName("Puerta Secundaria");
		door.setDoorID("1007");
		door.setPassword("ABCD");
		doors.add(door);
		
		door = new DoorComplete();
		door.setName("Garaje");
		door.setDoorID("0402");
		door.setPassword("QWERTY");
		doors.add(door);
	}
	
	public static DoorComplete doAuthentication(String doorID, String doorPass) {
		for (DoorComplete door : doors) {
			if (door.getDoorID().equals(doorID) && door.getPassword().equals(doorPass)) {
				return door;
			}
		}
		return null;
	}
	
	public static List<Door> getDoors() {
		List<Door> toReturn = new ArrayList<Door>();
		Door door;
		for (DoorComplete doorC : doors) {
			door = doorC;
			toReturn.add(door);
		}
		return toReturn;
	}
}
