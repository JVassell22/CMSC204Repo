package password_checker;

/**
 * Exception for when a password is considered "weak" meaining between 6 and 9 characters inclusive
 * @author Jonathan Vassell
 */
public class WeakPasswordException extends Exception {
	
	/**
	 * Constructor with relevant message to user
	 */
	public WeakPasswordException () {
		
		super("The password is OK but weak - it contains fewer than 10 characters.");
	}
	
}
