/**
 * 
 */
package co.pragma.nuevosnegocios.keycenter.to;

import java.io.Serializable;

/**
 * @author osmaga
 *
 */
public class Door implements Serializable {

	private static final long serialVersionUID = -2146045613230945945L;

	private String name;
	
	private String doorID;
	
	private String password;

	public String getDoorID() {
		return doorID;
	}

	public void setDoorID(String doorID) {
		this.doorID = doorID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
