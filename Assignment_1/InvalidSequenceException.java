package password_checker;

/**
 * Exception for a password with 3 repeating characters
 * @author Jonathan Vassell
 */
public class InvalidSequenceException extends Exception {

	/**
	 * Constructor with relevant message to user
	 */
	public InvalidSequenceException () {
		super("The password cannot contain more than two of the same character in sequence.");
	}
	
}
