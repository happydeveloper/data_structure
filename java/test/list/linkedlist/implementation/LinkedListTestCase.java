package list.linkedlist.implementation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import list.linkedlist.implementation.*;

public class LinkedListTestCase {
	
	LinkedList numbers;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		numbers = new LinkedList();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddFirst() {
		numbers.addFirst(10);
		numbers.addFirst(20);
		numbers.addFirst(30);
		numbers.addFirst(40);
		assertEquals(40, (int)numbers.get(0));
		assertEquals(10, (int)numbers.get(3));
	}

	@Test
	public void testAddLast() {
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		assertEquals(10, (int)numbers.get(0));
		assertEquals(40, (int)numbers.get(3));
	}

	@Test
	public void testAdd() {
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		numbers.add(0, 5);
		numbers.add(2, 15);
		numbers.add(6, 45);
		assertEquals(5, (int)numbers.get(0));
		assertEquals(15, (int)numbers.get(2));
		assertEquals(45, (int)numbers.get(6));
	}

	@Test
	public void testToString() {
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		assertEquals("[10,20,30,40]", numbers.toString());
	}

	@Test
	public void testRemoveFirst() {
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		numbers.removeFirst();
		assertEquals(20, (int)numbers.get(0));
	}

	@Test
	public void testRemove() {
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		numbers.addLast(50);
		numbers.remove(0);
		assertEquals(20, (int)numbers.get(0));
		numbers.remove(1);
		assertEquals(40, (int)numbers.get(1));
		numbers.remove(1);
		assertEquals(50, (int)numbers.get(1));
	}

	@Test
	public void testSize() {
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		assertEquals(4, numbers.size());
	}

	@Test
	public void testIndexOf() {
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		assertEquals(0, numbers.indexOf(10));
		assertEquals(1, numbers.indexOf(20));
		assertEquals(3, numbers.indexOf(40));
	}

	@Test
	public void testGet() {
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		assertEquals(10, numbers.get(0));
		assertEquals(40, numbers.get(numbers.size()-1));
	}

	@Test
	public void testIterator() {
	}

}
