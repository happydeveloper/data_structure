package ot.ds.list.arraylist.implementation;

interface Iterator {
	public boolean hasNext();

	public Object next();
}

class ArrayList {
	private int size = 0;
	private Object[] elementData = new Object[100];

	ArrayList() {

	}

	public boolean add(Object element) {
		elementData[size++] = element;
		return true;
	}

	public boolean add(int index, Object element) {
		for (int i = size - 1; i >= index; i--) {
			elementData[i + 1] = elementData[i];
		}
		elementData[index] = element;
		size++;
		return true;
	}

	public Object remove(int index) {
		Object removed = elementData[index];
		for (int i = index + 1; i <= size - 1; i++) {
			elementData[i - 1] = elementData[i];
		}
		size--;
		elementData[size] = null;
		return removed;
	}

	public Object get(int index) {
		return elementData[index];
	}
	
    public int size() {
        return size;
    }
    
    public Object indexOf(Object o){
    	for(int i=0; i < size; i++){
    		if(o.equals(elementData[i])){
    			return i;
    		}
    	}
    	return -1;
    }

	public Iterator iterator() {
		return new Ite();
	}

	public String toString() {
		String str = "[";
		for (int i = 0; i < size; i++) {
			str += elementData[i];
			if(i < size-1)
				str += ",";
		}
		return str + "]";
	}

	class Ite implements Iterator {
		int cursor;

		public boolean hasNext() {
			return size != cursor;
		}

		public Object next() {
			return elementData[cursor++];
		}
	}
}

public class Main {
	public static void main(String[] args) {
		ArrayList numbers = new ArrayList();

		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		numbers.add(40);
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
		for(int i=0; i<numbers.size(); i++){
			System.out.println(numbers.get(i));
		}
		
		Iterator it = numbers.iterator();
		System.out.println("\niterator");
		while (it.hasNext()) {
			int value = (int) it.next();
			System.out.println(value);
		}
		System.out.println(numbers);
	}
}