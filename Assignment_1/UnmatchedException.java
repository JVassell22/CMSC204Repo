package password_checker;

/**
 * Exception for when an original password and re-enetered password do not match
 * @author Jonathan Vassell
 */
public class UnmatchedException extends Exception {

	/**
	 * Constructor with relevant message to user
	 */
	public UnmatchedException () {
		super("Passwords do not match"); // specified as "The passwords do not match" in javadoc, but is stated in this form in test class provided
	}
	
}
