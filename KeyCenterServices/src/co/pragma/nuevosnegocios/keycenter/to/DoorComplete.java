/**
 * 
 */
package co.pragma.nuevosnegocios.keycenter.to;

import java.io.Serializable;

import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;

/**
 * @author osmaga
 *
 */
public class DoorComplete extends Door implements Serializable {

	private static final long serialVersionUID = -4140217873919520958L;
	
	private Pin output;
	private Pin input;
	
	private GpioPinDigitalInput myInput;
	
	private GpioPinDigitalOutput myOutput;

	/**
	 * @return the output
	 */
	public Pin getOutput() {
		return output;
	}

	/**
	 * @param output the output to set
	 */
	public void setOutput(Pin output) {
		this.output = output;
	}

	/**
	 * @return the input
	 */
	public Pin getInput() {
		return input;
	}

	/**
	 * @param input the input to set
	 */
	public void setInput(Pin input) {
		this.input = input;
	}

	/**
	 * @return the myInput
	 */
	public GpioPinDigitalInput getMyInput() {
		return myInput;
	}

	/**
	 * @param myInput the myInput to set
	 */
	public void setMyInput(GpioPinDigitalInput myInput) {
		this.myInput = myInput;
	}

	/**
	 * @return the myOutput
	 */
	public GpioPinDigitalOutput getMyOutput() {
		return myOutput;
	}

	/**
	 * @param myOutput the myOutput to set
	 */
	public void setMyOutput(GpioPinDigitalOutput myOutput) {
		this.myOutput = myOutput;
	}
}
