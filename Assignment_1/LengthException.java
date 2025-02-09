package password_checker;

/**
 * Exception for passwords under the length condition of 6 characters
 * @author Jonathan Vassell
 */
public class LengthException extends Exception{

	/**
	 * Constructor with relevant message to user
	 */
	public LengthException() {
		
		super("The password must be at least 6 characters long");
	}
	
}
