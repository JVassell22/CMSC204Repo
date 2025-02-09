package password_checker;

/**
 * Exception for a password with no upper case alpha
 * @author Jonathan Vassell
 */
public class NoUpperAlphaException extends Exception {
	
	/**
	 * Constructor with relevant message to user
	 */
	public NoUpperAlphaException() {
		
		super("The password must contain at least one uppercase alphabetic character");
	}
}
