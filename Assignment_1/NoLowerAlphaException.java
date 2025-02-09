package password_checker;

/**
 * Exception for a password with no lower case alpha
 * @author Jonathan Vassell
 */
public class NoLowerAlphaException extends Exception {

	/**
	 * Constructor with relevant message to user
	 */
	public NoLowerAlphaException() {
		super("The password must contain at least one lowercase alphabetic character");
	}
}
