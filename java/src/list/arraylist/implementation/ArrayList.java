package list.arraylist.implementation;

public class ArrayList {
	private int size = 0;
	private Object[] elementData = new Object[100];

	public ArrayList() {

	}
	
	public boolean addLast(Object element) {
	    elementData[size] = element;
	    size++;
	    return true;
	}
	
	public boolean add(int index, Object element) {
		// ������Ʈ �߰��� �����͸� �߰��ϱ� ���ؼ��� ���� ������Ʈ���� index�� ������ �ڷ� ��ĭ�� �̵����Ѿ� �մϴ�.
		for (int i = size - 1; i >= index; i--) {
			elementData[i + 1] = elementData[i];
		}
		// index�� ��带 �߰��մϴ�.
		elementData[index] = element;
		// ������Ʈ�� ���ڸ� 1 ���� ��ŵ�ϴ�.
		size++;
		return true;
	}
	
	public boolean addFirst(Object element){
		return add(0, element);
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
	
	public Object remove(int index) {
		// ������Ʈ�� �����ϱ� ���� ������ �����͸� removed ������ �����մϴ�.
		Object removed = elementData[index];
		// ������ ������Ʈ ���� ������Ʈ���� ������ ������Ʈ���� ���������� �̵��ؼ� ���ڸ��� ä��ϴ�.
		for (int i = index + 1; i <= size - 1; i++) {
			elementData[i - 1] = elementData[i];
		}
		// ũ�⸦ ���Դϴ�.
		size--;
		// ������ ��ġ�� ������Ʈ�� ��������� �������ݴϴ�. 
		elementData[size] = null;
		return removed;
	}	
	
	public Object removeFirst(){
		return remove(0);
	}

	public Object removeLast(){
		return remove(size-1);
	}

	public Object get(int index) {
		return elementData[index];
	}

	public int size() {
		return size;
	}

	public int indexOf(Object o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elementData[i])) {
				return i;
			}
		}
		return -1;
	}

	public ListIterator listIterator() {
		// ListIterator �ν��Ͻ��� �����ؼ� �����մϴ�.
		return new ListIterator();
	}

	

	class ListIterator {
		// ���� Ž���ϰ� �ִ� ������ ����Ű�� �ε��� ��
		private int nextIndex = 0;

		// next �޼Ҹ��� ȣ���� �� �ִ����� üũ�մϴ�.
		public boolean hasNext() {
			// nextIndex�� ������Ʈ�� ���ں��� ���ٸ� next�� �̿��ؼ� Ž���� ������Ʈ�� �����ϴ� ���̱� ������ true�� �����մϴ�. 
			return nextIndex < size();
		}
		
		// ���������� ������Ʈ�� Ž���ؼ� �����մϴ�. 
		public Object next() {
			// nextIndex�� �ش��ϴ� ������Ʈ�� �����ϰ� nextIndex�� ���� 1 ���� ��ŵ�ϴ�.
			return elementData[nextIndex++];
		}
		
		// previous �޼ҵ带 ȣ���ص� �Ǵ����� üũ�մϴ�.
		public boolean hasPrevious(){
			// nextIndex�� 0���� ũ�ٸ� ���� ������Ʈ�� �����Ѵٴ� �ǹ��Դϴ�.
			return nextIndex > 0;
		}
		
		// ���������� ���� ��带 �����մϴ�.
		public Object previous(){
			// ���� ������Ʈ�� �����ϰ� nextIndex�� ���� 1�����մϴ�. 
			return elementData[--nextIndex];
		}
		
		// ���� ������Ʈ�� �߰��մϴ�. 
		public void add(Object element){
			ArrayList.this.add(nextIndex++, element);
		}
		
		// ���� ������Ʈ�� �����մϴ�. 
        public void remove(){
            ArrayList.this.remove(nextIndex-1);
            nextIndex--;
        }
		

	}

}