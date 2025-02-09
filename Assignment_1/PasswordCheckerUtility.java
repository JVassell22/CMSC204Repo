package password_checker;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 This class is used to ensure passwords are in compliance with all given standards,
 including specific character requirements, length, and sequencing 
 @author Jonathan Vassell
 @version 1.0 
 */
public class PasswordCheckerUtility {
	
	/**
	 * Empty Constructor 
	 */
	public PasswordCheckerUtility() {
		
	}
	/**
	 Ensures a password satisfies all listed conditions: 
	 <ol>
	 <li>Length of 6 or greater</li>
	 <li>Upper Alpha Character</li>
	 <li>Lower Alpha Character</li>
	 <li>Digit Character</li>
	 <li>Special Character</li>
	 <li>Sequence of 2 or Less of Specific Character</li>
	 </ol>
	 @param password The password entered by the user
	 @return True if password satisfies all conditions
	 @throws LengthException If password is less than 6 characters
	 @throws NoUpperAlphaException If password does not contain an upper case alpha
	 @throws NoLowerAlphaException If password does not contain a lower case alpha
	 @throws NoLowerAlphaException If password does not contain a digit
	 @throws NoSpecialCharacterException If password does not contain a special character
	 @throws InvalidSequenceException If sequence of 3 or more same character
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, 
	NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		
		boolean upperAlpha = false, lowerAlpha = false, digit = false;
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		if(password.length() < 6) {
			throw new LengthException();
		}

		for(char c: password.toCharArray()) {
			if(c >= 65 && c <= 90) {
				upperAlpha = true;
			}
		}
		if(!upperAlpha) {
			throw new NoUpperAlphaException();
		}
		
		for(char c: password.toCharArray()) {
			if(c >= 97 && c <= 122) {
				lowerAlpha = true;
			}
		}
		if(!lowerAlpha) {
			throw new NoLowerAlphaException();
		}
		
		for(char c: password.toCharArray()) {
			if(c >= 48 && c <= 57) {
				digit = true;
			}
		}
		if(!digit) {
			throw new NoDigitException();
		}
		
		Matcher matcher = pattern.matcher(password);
		if (!matcher.find()) {
			throw new NoSpecialCharacterException();
		}
		
		char[] passArr = password.toCharArray();
		for(int i = 0; i < passArr.length-2; i++) {
			if(passArr[i] == passArr[i+1] && passArr[i] == passArr[i+2]) {
				throw new InvalidSequenceException();
			}
		}
		return true;
	}
	
	/**
	 * Checks if password is considered "weak", being between 6 and 9 characters, inclusive
	 * @param password The password entered by the user
	 * @return False if password is longer than 9 characters
	 * @throws WeakPasswordException If password is between 6 and 9 characters
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		if(password.length() >=6 && password.length() <= 9) {
			throw new WeakPasswordException();
		}
		return false;
	}
	
	/**
	 * Checks multiple passwords for compliance of conditions
	 * @param passwords List of passwords from user to be checked
	 * @return List of passwords that do not comply with conditions, with specific exception message 
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<>();
		for(String s: passwords) {
			try {
				isValidPassword(s);
			}
			
			catch(LengthException e){
				invalidPasswords.add(s +" The password must be at least 6 characters long");
			} 
			catch (NoUpperAlphaException e) {
				invalidPasswords.add(s +" The password must contain at least one uppercase alphabetic character");
			} 
			catch (NoLowerAlphaException e) {
				invalidPasswords.add(s +" The password must contain at least one lowercase alphabetic character");
			} 
			catch (NoDigitException e) {
				invalidPasswords.add(s +" The password must contain at least one digit");
			} 
			catch (NoSpecialCharacterException e) {
				invalidPasswords.add(s +" The password must contain at least one special character");
			} 
			catch (InvalidSequenceException e) {
				invalidPasswords.add(s +" The password cannot contain more than two of the same character in sequence.");
			}
		}
		return invalidPasswords;
	}
	
	/**
	 * Checks if password is of appropriate length; over 6 characters
	 * @param password The password entered by the user
	 * @return True if password is longer than 6 characters
	 * @throws LengthException If password is less than 6 characters
	 */
	public static boolean isValidLength(String password) throws LengthException {
		if(password.length() < 6) {
			throw new LengthException();
		}
		return true;
	}
	/**
	 * Checks if password contains an upper case alpha
	 * @param password The password entered by the user
	 * @return True if password contains an upper case alpha
	 * @throws NoUpperAlphaException If password does not contain an upper case alpha
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		boolean upperAlpha = false;
		for(char c: password.toCharArray()) {
			if(c >= 65 && c <= 90) {
				upperAlpha = true;
			}
		}
		if(!upperAlpha) {
			throw new NoUpperAlphaException();
		}
		return upperAlpha;
	}
	
	/**
	 * Checks if password contains an upper case alpha
	 * @param password The password entered by the user
	 * @return True if password contains a lower case alpha
	 * @throws NoLowerAlphaException If password does not contain a lower case alpha
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		boolean lowerAlpha = false;
		for(char c: password.toCharArray()) {
			if(c >= 97 && c <= 122) {
				lowerAlpha = true;
			}
		}
		if(!lowerAlpha) {
			throw new NoLowerAlphaException();
		}
		return lowerAlpha;
	}
	
	/**
	 * Checks if password contains a lower case alpha
	 * @param password The password entered by the user
	 * @return True if password contains a digit
	 * @throws NoLowerAlphaException If password does not contain a digit
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		boolean digit = false;
		for(char c: password.toCharArray()) {
			if(c >= 48 && c <= 57) {
				digit = true;
			}
		}
		if(!digit) {
			throw new NoDigitException();
		}
		return digit;
	}
	
	/**
	 * Checks if password contains a special character
	 * @param password The password entered by the user
	 * @return True if password contains a special character
	 * @throws NoSpecialCharacterException If password does not contain a special character
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		Matcher matcher = pattern.matcher(password);
		if (!matcher.find()) {
			throw new NoSpecialCharacterException();
		}
		return true;
	}
	
	/**
	 * Checks if password has 3 or more same characters in sequence
	 * @param password The password entered by the user
	 * @return True false if sequencing of characters is in bounds
	 * @throws InvalidSequenceException If sequence of 3 or more same character
	 */
	public static boolean noSameCharInSequence(String password) throws InvalidSequenceException {
		char[] passArr = password.toCharArray();
		for(int i = 0; i < passArr.length; i++) {
			if(i == 0) {
				if(passArr[i] == passArr[i+1] && passArr[i] == passArr[i+2]) {
					throw new InvalidSequenceException();
				}
			}
			if( i > 0 && i < (passArr.length-1)) {
				if(passArr[i] == passArr[i-1] && passArr[i] == passArr[i+1]) {
					throw new InvalidSequenceException();
				}
			}
		}
		return false;
	}

	/**
	 * Checks if password is within 6 to 9 characters inclusive
	 * @param password The password entered by the user
	 * @return True if password is between 6 and 9 characters, False if out of these bounds
	 */
	public static boolean hasBetweenSixandNineChars(String password) {
		if(password.length() < 10 && password.length() > 5) {
			return false;
		}
		return true;
	}
	
	/**
	 * Checks if re-entered password is equivalent to the original password
	 * @param password The password entered by the user
	 * @param passwordConfirm The password re-entered by the user
	 * @throws UnmatchedException If password and re-entered password are not equivalent
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
		if(!password.equals(passwordConfirm)) {
			throw new UnmatchedException();
		}
	}
	
	/**
	 * Checks if re-eneted password is equivalent to the original password
	 * @param password The password entered by the user
	 * @param passwordConfirm The password re-entered by the user
	 * @return True if passwords are equivalent, False if they are not
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		if(!password.equals(passwordConfirm)) {
			return false;
		}
		return true;
	}
}
