import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class MyQueueTest {
	public MyQueue<String> stringQ;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleQ
	public MyQueue<Double> doubleQ;
	// STUDENT: add variables as needed for your student tests

	@BeforeEach
	public void setUp() throws Exception {
		stringQ = new MyQueue<String>(5);
		stringQ.enqueue(a);
		stringQ.enqueue(b);
		stringQ.enqueue(c);
		
		doubleQ = new MyQueue<Double>(5);
		doubleQ.enqueue(5.0);
		doubleQ.enqueue(7.5);
		doubleQ.enqueue(131.21);
	}

	@AfterEach
	public void tearDown() throws Exception {
		stringQ = null;
		doubleQ = null;
	}

	@Test
	public void testIsEmpty() {
		assertEquals(false,stringQ.isEmpty());
		try {
			stringQ.dequeue();
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stringQ.dequeue();
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stringQ.dequeue();
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true, stringQ.isEmpty());
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(a, stringQ.dequeue());
			assertEquals(b, stringQ.dequeue());
			assertEquals(c, stringQ.dequeue());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringQ.dequeue();
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an QueueUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
	}
	
	@Test
	public void testDequeueStudent() {
		try {
			assertEquals(5.0,doubleQ.dequeue(),0.001);
			assertEquals(7.5,doubleQ.dequeue(),0.001);
			doubleQ.enqueue(11.1);
			assertEquals(131.21,doubleQ.dequeue(),0.001);
			assertTrue(doubleQ.size() == 1);
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSize() {
		assertEquals(3, stringQ.size());
		try {
			stringQ.enqueue(d);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(4, stringQ.size());
		try {
			stringQ.dequeue();
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stringQ.dequeue();
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(2, stringQ.size());
	}
	
	@Test
	public void testEnqueue() {
		try {
			assertEquals(3, stringQ.size());
			assertEquals(true, stringQ.enqueue(d));
			assertEquals(4, stringQ.size());
			assertEquals(true, stringQ.enqueue(e));
			assertEquals(5, stringQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringQ.enqueue(f);
			assertTrue("This should have caused an QueueOverflowException", false);
		}
		catch (QueueOverflowException e){
			assertTrue("This should have caused an QueueOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueOverflowException", false);
		}
	}
	
	@Test
	public void testEnqueueStudent() {
		assertEquals(doubleQ.size(), 3);
		try {
			assertTrue(doubleQ.enqueue(11.1));
			assertEquals(doubleQ.enqueue(15.5), true);
			assertEquals(doubleQ.size(), 5);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testIsFull() {
		assertEquals(false, stringQ.isFull());
		try {
			stringQ.enqueue(d);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stringQ.enqueue(e);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true, stringQ.isFull());
	}
	
	@Test
	public void testToString() {
		assertEquals("abc", stringQ.toString());
		try {
			stringQ.enqueue(d);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("abcd", stringQ.toString());
		try {
			stringQ.enqueue(e);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("abcde", stringQ.toString());
	}
	
	@Test
	public void testToStringStudent() {
		doubleQ.empty();
		try {
			assertEquals(true, doubleQ.enqueue(10.0));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("10.0", doubleQ.toString());
		try {
			assertEquals(true, doubleQ.enqueue(15.0));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testToStringDelimiter() {
		assertEquals("a%b%c", stringQ.toString("%"));
		try {
			stringQ.enqueue(d);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("a&b&c&d", stringQ.toString("&"));
		try {
			stringQ.enqueue(e);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("a/b/c/d/e", stringQ.toString("/"));
	}
	
	@Test
	public void testFill() throws QueueUnderflowException {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringQ = new MyQueue<String>(5);
		//fill with an ArrayList
		stringQ.fill(fill);
		System.out.println(stringQ.toString());
		assertEquals(3,stringQ.size());
		assertEquals("apple", stringQ.dequeue());
		assertEquals("banana", stringQ.dequeue());
		assertEquals("carrot", stringQ.dequeue());		
	}
	
}
