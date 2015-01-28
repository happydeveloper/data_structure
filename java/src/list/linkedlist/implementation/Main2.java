package list.linkedlist.implementation;
import java.util.LinkedList;
import java.util.ListIterator;
public class Main2 {

	public static void main(String[] args) {
		java.util.LinkedList numbers = new java.util.LinkedList();
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		ListIterator l = numbers.listIterator();
		System.out.println(l.next());
		l.remove();
		System.out.println(l.next());
		l.remove();
		System.out.println(numbers);
	}

}
