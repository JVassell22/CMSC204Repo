package password_checker;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Jonathan Vassell
 *
 */
public class PasswordCheckerTest_STUDENT {
	
	ArrayList<String> passArrL;
	String password = "AaBbCc123!@#";

	@Before
	public void setUp() throws Exception {
		passArrL = new ArrayList<>();
	}

	@After
	public void tearDown() throws Exception {
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword(password));
			
			assertTrue(PasswordCheckerUtility.isValidPassword("aB1!"));
			
			assertTrue("Did not throw LengthException",false);
		}
		catch(LengthException e){
			assertTrue("Successfully threw a length exception", true);
		}
		catch(Exception e) {
			assertTrue("Threw exception other than length", false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("aabb@123!^"));
			
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e) {
			assertTrue("Successfully threw an upper alpha exception", true);
		}
		catch(Exception e) {
			assertTrue("Threw exception other than upper alpha", false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("ABCD123$%^"));
			
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e) {
			assertTrue("Successfully threw a lower alpha exception", true);
		}
		catch(Exception e) {
			assertTrue("Threw exception other than lower alpha", false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertTrue(PasswordCheckerUtility.isWeakPassword("abC1@3"));
			
			assertTrue("Did not throw WeakPasswordException",false);
		}
		catch(WeakPasswordException e) {
			assertTrue("Successfully threw a weak password exception", true);
		}
		catch(Exception e) {
			assertTrue("Threw exception other than weak password", false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("PPP1p@!PP"));
			
			assertTrue("Did not throw InvalidSequenceException",false);

		}
		catch(InvalidSequenceException e) {
			assertTrue("Successfully threw an invalid sequence exception", true);
		}
		catch(Exception e) {
			assertTrue("Threw exception other than invalid sequence", false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("aBcDeFgH!@#"));
			
			assertTrue("Did not throw NoDigitException",false);

		}
		catch(NoDigitException e) {
			assertTrue("Successfully threw a no digit exception", true);
		}
		catch(Exception e) {
			assertTrue("Threw exception other than no digit", false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(password));
		}
		catch(Exception e) {
			assertTrue("caught exception with valid password", false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		passArrL.add("abCd123wasd");
		passArrL.add("AABBCC11!!22");
		passArrL.add("TTTIIIgeer!1!");
		passArrL.add(password);
		ArrayList<String> badPasswords = PasswordCheckerUtility.getInvalidPasswords(passArrL);
		assertEquals(3,badPasswords.size());
		assertTrue(badPasswords.get(0).equals("abCd123wasd The password must contain at least one special character"));
		assertTrue(badPasswords.get(1).equals("AABBCC11!!22 The password must contain at least one lowercase alphabetic character"));
	}
	
}
