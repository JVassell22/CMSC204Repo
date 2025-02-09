package password_checker;

/**
 * Exception for passwords without a numerical digit
 * @author Jonathan Vassell
 */
public class NoDigitException extends Exception{

	/**
	 * Constructor with relevant message to user
	 */
	public NoDigitException() {
		
		super("The password must contain at least one digit");
	}

}
