package list.linkedlist.implementation;

import static org.junit.Assert.assertEquals;
import list.doublylinkedlist.implementation.DoublyLinkedList;

public class Main {
	public static void main(String[] args) {
		DoublyLinkedList numbers = new DoublyLinkedList();
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
		i.previous();
		i.remove();	
		
		System.out.println(numbers);
		
	}
}
