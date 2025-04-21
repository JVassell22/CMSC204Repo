import static org.junit.Assert.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeTreeTest {
	MorseCodeTree tree;
	@Before
	public void setUp() throws Exception {
		tree = new MorseCodeTree();
	}

	@After
	public void tearDown() throws Exception {
		tree = null;
	}
	
	public void testGetRoot() {
		assertTrue(tree.getRoot().getData().equals(""));
	}
	
	public void testFetchNode() {
		assertTrue("s".equals(tree.fetch("...")));
		assertTrue("n".equals(tree.fetch("-.")));
	}
	
	public void testToArrayList() {
		ArrayList<String> temp = tree.toArrayList();
		assertTrue(temp.get(1).equals("e"));
		assertTrue(temp.get(3).equals("s"));
		assertTrue(temp.get(5).equals("n"));
	}
}
