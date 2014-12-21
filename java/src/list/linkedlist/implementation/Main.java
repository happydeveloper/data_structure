package list.linkedlist.implementation;

public class Main {
	public static void main(String[] args) {
		LinkedList numbers = new LinkedList();
		numbers.addFirst(10);
		numbers.addFirst(20);
		numbers.addFirst(30);
		numbers.addFirst(40);
		System.out.println("add(°ª)");
		System.out.println(numbers);

		numbers.add(1, 50);
		System.out.println("\nadd(ÀÎµ¦½º, °ª)");
		System.out.println(numbers);

		numbers.remove(2);
		System.out.println("\nremove(ÀÎµ¦½º)");
		System.out.println(numbers);

		System.out.println("\nget(ÀÎµ¦½º)");
		System.out.println(numbers.get(2));

		System.out.println("\nsize()");
		System.out.println(numbers.size());

		System.out.println("\nindexOf()");
		System.out.println(numbers.indexOf(30));

		System.out.println("\nfor loop");
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}

		Iterator it = numbers.iterator();
		System.out.println("\niterator");
		while (it.hasNext()) {
			int value = (int)it.next();
			System.out.println(value);
		}
		System.out.println(numbers);
		
		numbers.remove(0);
		System.out.println(numbers);
		
	}
}
