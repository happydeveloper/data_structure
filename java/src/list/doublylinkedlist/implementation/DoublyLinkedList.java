package list.doublylinkedlist.implementation;

interface Iterator {
	public boolean hasNext();
	public Object next();
	public boolean hasPrevious();
	public Object previous();
	public void add(Object input);
}

public class DoublyLinkedList {
	// ù��° ��带 ����Ű�� �ʵ�
	private Node head;
	private Node tail;
	private int size = 0;
	private class Node{
		// �����Ͱ� ����� �ʵ�
		public Object data;
		// ���� ��带 ����Ű�� �ʵ�
		public Node next;
		public Node prev;
		public Node(Object input) {
			this.data = input;
			this.next = null;
			this.prev = null;
		}
		// ����� ������ ���� ����ؼ� Ȯ���غ� �� �ִ� ���
		public String toString(){
			return String.valueOf(this.data);
		}
	}
	public void addFirst(Object input){
		// ��带 �����մϴ�.
		Node temp = new Node(input);
		// ���ο� ����� ���� ���� ��带 �����մϴ�.
		temp.next = head;
		// ������ ��尡 �־��ٸ� ���� ����� ���� ���� ���ο� ��带 �����մϴ�.
		if(head != null)
			head.prev = temp;
		// ���� ���ο� ��带 �����մϴ�.
		head = temp;
		size++;
		if(head.next == null){
			tail = head;
		}
	}
	public void addLast(Object input){
		// ��带 �����մϴ�.
		Node temp = new Node(input);
		// ����Ʈ�� ��尡 ���ٸ� ù��° ��带 �߰��ϴ� �޼ҵ带 ����մϴ�.
		if(size == 0){
			addFirst(input);
		} else {
			// tail�� ���� ���� ������ ��带 �����մϴ�.
			tail.next = temp;
			// ���ο� ����� ���� ���� tail�� �����մϴ�.
			temp.prev = tail;
			// ������ ��带 �����մϴ�.
			tail = temp;
			// ������Ʈ�� ������ 1 ���� ��ŵ�ϴ�.
			size++;
		}
	}
	Node node(int index) {
		// ����� �ε����� ��ü ��� ���� �ݺ��� ū�� ������ ���
        if (index < size/2) {
            // head���� next�� �̿��ؼ� �ε����� �ش��ϴ� ��带 ã���ϴ�.
        	Node x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
        	// tail���� prev�� �̿��ؼ� �ε����� �ش��ϴ� ��带 ã���ϴ�.
            Node x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
	public void add(int k, Object input){
		// ���� k�� 0�̶�� ù��° ��忡 �߰��ϴ� ���̱� ������ addFirst�� ����մϴ�.
		if(k == 0){
			addFirst(input);
		} else {
			Node temp1 = node(k-1);
			// k ��° ��带 temp2�� �����մϴ�.
			Node temp2 = temp1.next;
			// ���ο� ��带 �����մϴ�.
			Node newNode = new Node(input);
			// ���ο� ����� ���� ���� temp2�� �����մϴ�.
			newNode.next = temp2;
			// temp2�� ���� ���� ���ο� ��带 �����մϴ�.
			if(temp2 != null)
				temp2.prev = newNode;
			// temp1�� ���� ���� ���ο� ��带 �����մϴ�.
			temp1.next = newNode;
			//���ο� ����� ���� ���� temp1�� �����մϴ�.
			newNode.prev = temp1;
			size++;
			// ���ο� ����� ���� ��尡 ���ٸ� ���ο� ��尡 ������ ����̱� ������ tail�� �����մϴ�.
			if(newNode.next == null){
				tail = newNode;
			}
		}
	}
	public String toString() {
		// ��尡 ���ٸ� []�� �����մϴ�.
		if(head == null){
			return "[]";
		}		
		// Ž���� �����մϴ�.
		Node temp = head;
		String str = "[";
		// ���� ��尡 ���� ������ �ݺ����� �����մϴ�.
		// ������ ���� ���� ��尡 ���� ������ �Ʒ��� ������ ������ ���� ���ܵ˴ϴ�.
		while(temp.next != null){
			str += temp.data + ",";
			temp = temp.next;
		}
		// ������ ��带 ��°���� ���Խ�ŵ�ϴ�.
		str += temp.data;
		return str+"]";
	}
	public Object removeFirst(){
		// ù��° ��带 temp�� �����ϰ� head�� ���� �ι�° ���� �����մϴ�.
		Node temp = head;
		head = temp.next;
		// �����͸� �����ϱ� ���� ������ ���� �ӽ� ������ ����ϴ�. 
		Object returnData = temp.data;
		temp = null;
		// ����Ʈ ���� ��尡 �ִٸ� head�� ���� ��带 null�� �����մϴ�.
		if(head != null)
			head.prev = null;
		size--;
		return returnData;
	}
	public Object remove(int k){
		if(k == 0)
			return removeFirst();
		// k-1��° ��带 temp�� �����մϴ�.
		Node temp = node(k-1);
		// temp.next�� �����ϱ� ���� todoDeleted ������ �����մϴ�.
		Node todoDeleted = temp.next;
		// ���� ��� ��带 ���ῡ�� �и��մϴ�.
		temp.next = temp.next.next;
		// ������ ����� ���� ��带 �����մϴ�.
		temp.next.prev = temp;
		// ������ ����� �����͸� �����ϱ� ���ؼ� returnData�� �����͸� �����մϴ�.
		Object returnData = todoDeleted.data; 
		// ������ ��尡 tail�̾��ٸ� tail�� ���� ��带 tail�� �����մϴ�.
		if(todoDeleted == tail){
			tail = temp;
		}
		// cur.next�� ���� �մϴ�.
		todoDeleted = null;	
		size--;
		return returnData;
	}
	public int size(){
		return size;
	}
	public Object get(int k){
		return node(k).data;
	}
	public Object indexOf(Object data){
		// Ž�� ����� �Ǵ� ��带 temp�� �����մϴ�.
		Node temp = head;
		// Ž�� ����� ���° ������Ʈ�� �ִ����� �ǹ��ϴ� ������ index�� ����մϴ�.
		int index = 0;
		// Ž�� ���� Ž�� ����� ���� ���մϴ�. 
		while(temp.data != data){
			temp = temp.next;
			index++;
			// temp�� ���� null�̶�� ���� �� �̻� Ž�� ����� ���ٴ� ���� �ǹ��մϴ�.�� �� -1�� �����մϴ�.
			if(temp == null)
				return -1;
		}
		// Ž�� ����� ã�Ҵٸ� ����� �ε��� ���� �����մϴ�.
		return index;
	}

	// �ݺ��ڸ� �����ؼ� �������ݴϴ�.
	public Iterator iterator() {
		return new Ite();
	}
	
	class Ite implements Iterator {
		private Node lastReturned;
		private Node next;
		private int nextIndex;
		
		Ite(){
			next = head;
			nextIndex = 0;
		}
		
		// �� �޼ҵ带 ȣ���ϸ� cursor�� �������� ���� cursor.next�� ����˴ϴ�. 
		public Object next() {
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.data;
		}
		
		// cursor�� ���� ���ٸ� �ٽ� ���ؼ� �� �̻� next�� ���ؼ� ������ ��尡 ���ٸ� false�� �����մϴ�.
		// �̸� ���ؼ� next�� ȣ���ص� �Ǵ����� ������ �Ǵ��� �� �ֽ��ϴ�. 
		public boolean hasNext() {
			return nextIndex < size();
		}
		
		public boolean hasPrevious() {
			return nextIndex > 0;
		}
		
		public Object previous() {
			lastReturned = next = (next == null) ? tail : next.prev;
			nextIndex--;
			return lastReturned.data;
		}
		
		public void add(Object input){
			if (next == null)
                addLast(input);
            else {
            	Node prev = next.prev;
                Node newNode = new Node(input);
                newNode.prev = prev;
                newNode.next = next;
                next.prev = newNode;
                if (prev == null)
                    head = newNode;
                else
                    prev.next = newNode;
                size++;
            }
            nextIndex++;
		}
	}

}