package list.arraylist.implementation;

interface Iterator {
	public boolean hasNext();

	public Object next();
}

public class ArrayList {
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

	public Object indexOf(Object o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elementData[i])) {
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
			if (i < size - 1)
				str += ",";
		}
		return str + "]";
	}

	class Ite implements Iterator {
		int cursor = 0;

		public boolean hasNext() {
			return size != cursor;
		}

		public Object next() {
			return elementData[cursor++];
		}
	}

}