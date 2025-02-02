import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	GradeBook book1 = new GradeBook(5);
	GradeBook book2 = new GradeBook(5);

	@BeforeEach
	void setUp() throws Exception {
		
		book1.addScore(80);
		book1.addScore(100);
		
		book2.addScore(60);
		book2.addScore(70);
		book2.addScore(50);
	}

	@AfterEach
	void tearDown() throws Exception {
		book1 = null;
		book2 = null;
	}

	@Test
	void testAddScore() {
		assertEquals(2, book1.getScoreSize());
		assertEquals(3,book2.getScoreSize());
		
		assertTrue(" 80.0 100.0".equals(book1.toString()));
		assertTrue(" 60.0 70.0 50.0".equals(book2.toString()));
		
		
	}

	@Test
	void testSum() {
		assertEquals(180, book1.sum());
		assertEquals(180, book2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(80, book1.minimum());
		assertEquals(50, book2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(100, book1.finalScore());
		assertEquals(130, book2.finalScore());
	}

}
