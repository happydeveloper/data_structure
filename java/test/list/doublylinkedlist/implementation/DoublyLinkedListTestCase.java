package list.doublylinkedlist.implementation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import list.doublylinkedlist.implementation.*;
import list.linkedlist.implementation.LinkedList;

public class DoublyLinkedListTestCase {

	DoublyLinkedList numbers;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {
		numbers = new DoublyLinkedList();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddFirst() {
		numbers.addFirst(30);
		numbers.addFirst(20);
		numbers.addFirst(10);
		testIterator();
	}

	@Test
	public void testAddLast() {
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		testIterator();
	}

	@Test
	public void testAdd() {
		// 5 10 15 20 30 40 45
		numbers.add(0, 10);
		numbers.add(1, 20);
		numbers.add(2, 30);
		testIterator();
	}

	@Test
	public void testToString() {
		numbers.addLast(10);
		numbers.addLast(20);
		assertEquals("[10,20]", numbers.toString());
	}

	@Test
	public void testRemoveFirst() {
		numbers.addLast(10);
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.removeFirst();
		testIterator();
	}

	@Test
	public void testRemoveLast() {
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		numbers.removeLast();
		testIterator();
	}

	@Test
	public void testRemove() {
		numbers.addLast(10);
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(30);
		numbers.remove(0);
		numbers.remove(1);
		numbers.remove(2);
		testIterator();
	}

	@Test
	public void testSize() {
		numbers.addLast(10);
		numbers.addLast(20);
		assertEquals(2, numbers.size());
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
		assertEquals(40, numbers.get(numbers.size() - 1));
	}
	
	@Test
	public void addIterator(){
		DoublyLinkedList.ListIterator i = numbers.listIterator();
		i.add(10);
		i.add(20);
		i.add(30);
		testIterator();
	}
	
	@Test(expected=IllegalStateException.class)
	public void removeFirstIterator(){
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		DoublyLinkedList.ListIterator i = numbers.listIterator();
		i.remove();
	}
	
	@Test
	public void removeIterator(){
		numbers.addLast(5);
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		DoublyLinkedList.ListIterator i = numbers.listIterator();
		i.next();
		i.remove();
		i.next();
		i.next();
		i.next();
		i.next();		
		i.remove();
		testIterator();
	}
	
	public void testIterator(){
		// 10, 20, 30을 테스트
		DoublyLinkedList.ListIterator i = numbers.listIterator();
		assertEquals(true, i.hasNext());
		assertEquals(false, i.hasPrevious());
		assertEquals(10, i.next());
		assertEquals(true, i.hasNext());
		assertEquals(true, i.hasPrevious());
		assertEquals(20, i.next());
		assertEquals(30, i.next());
		assertEquals(false, i.hasNext());
		assertEquals(true, i.hasPrevious());
		assertEquals(30, i.previous());
		assertEquals(20, i.previous());
		assertEquals(10, i.previous());
		assertEquals(true, i.hasNext());
		assertEquals(false, i.hasPrevious());
	}
}
