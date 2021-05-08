package mbt;

import org.junit.Test;

import mbt.Library;

import static org.junit.Assert.*;

public class LibraryTest {
    
	@Test 
	public void test1() {
        Library classUnderTest = new Library();
        assertEquals(true, classUnderTest.greaterOrEqual(2, 1));
    }
	
	// Commented to see surviving mutations.
	/*@Test 
	public void test2() {
        Library classUnderTest = new Library();
        assertEquals(true, classUnderTest.greaterOrEqual(2, 2));
    }*/
	
	@Test 
	public void test3() {
        Library classUnderTest = new Library();
        assertEquals(false, classUnderTest.greaterOrEqual(2, 3));
    }
	
}
