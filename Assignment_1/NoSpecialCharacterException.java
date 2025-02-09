package password_checker;
/**
 * Exception for a password with no special character
 * @author Jonathan Vassell
 */
public class NoSpecialCharacterException extends Exception {

	/**
	 * Constructor with relevant message to user
	 */
	public NoSpecialCharacterException () {
		super("The password must contain at least one special character");
	}
	
}
