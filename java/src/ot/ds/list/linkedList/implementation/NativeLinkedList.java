package ot.ds.list.linkedList.implementation;
import java.util.*;


public class NativeLinkedList {

	public static void main(String[] args) {
		LinkedList li = new LinkedList();
		li.add("F");
		li.add("B");
		li.add("D");
		li.addLast("Z");
		System.out.println(li.removeLast());
		System.out.println(li);
		
		ExLinkedList eli = new ExLinkedList();
		eli.addFirst(6);
		eli.addFirst(5);
		eli.addFirst(4);
		
		eli.addFirst(3);
		eli.addFirst(2);
		eli.addFirst(1);
		System.out.println(eli.removeLast());
		System.out.println(eli.removeFirst());		
		eli.addLast(90);
		System.out.println(eli);
		eli.remove(1);
		System.out.println(eli);
		
	}

}
