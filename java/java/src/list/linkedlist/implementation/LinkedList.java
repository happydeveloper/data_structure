package list.linkedlist.implementation;

interface Iterator {
	public boolean hasNext();

	public Object next();
}

public class LinkedList {
	// ù��° ��带 ����Ű�� �ʵ�
	private Node head;
	private Node tail;
	private int size = 0;
	private class Node{
		// �����Ͱ� ����� �ʵ�
		public Object data;
		// ���� ��带 ����Ű�� �ʵ�
		public Node next;
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		// ����� ������ ���� ����ؼ� Ȯ���غ� �� �ִ� ���
		public String toString(){
			return String.valueOf(this.data);
		}
	}
	public void addFirst(Object input){
		// ��带 �����մϴ�.
		Node temp = new Node(input);
		// ���ο� ����� ���� ���� �ص带 �����մϴ�.
		temp.next = head;
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
			// ������ ����� ���� ���� ������ ��带 �����մϴ�.
			tail.next = temp;
			// ������ ��带 �����մϴ�.
			tail = temp;
			// ������Ʈ�� ������ 1 ���� ��ŵ�ϴ�.
			size++;
		}
	}
	public void add(int k, Object input){
		// ���� k�� 0�̶�� ù��° ��忡 �߰��ϴ� ���̱� ������ addFirst�� ����մϴ�.
		if(k == 0){
			addFirst(input);
		} else {
			// ���� ����Ʈ �󿡼� ù��° ��带 temp1���� ����ϴ�.
			Node temp1 = head;
			// k-1 �� �ݺ����� �����ؼ� k-1 ��带 ã���ϴ�.
			for(int i=0; i<k-1; i++){
				temp1 = temp1.next;
			}
			// k ��° ��带 temp2�� �����մϴ�.
			Node temp2 = temp1.next;
			// ���ο� ��带 �����մϴ�.
			Node newNode = new Node(input);
			// temp1�� ���� ���� ���ο� ��带 �����մϴ�.
			temp1.next = newNode;
			// ���ο� ����� ���� ���� temp2�� �����մϴ�.
			newNode.next = temp2;
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
		size--;
		return returnData;
	}
	public Object remove(int k){
		if(k == 0)
			return removeFirst();
		// ù��° ��带 temp�� �����մϴ�.
		Node temp = head;
		// k-1��° ���(���� �� ���)�� temp�� �����մϴ�.
        for(int i=0; i<k-1; i++){
            temp = temp.next;
        }
		// ���� ��带 todoDeleted�� ����� �Ӵϴ�. 
        // ���� ��带 ���� �����ϸ� ���� �� ���� ���� �� ��带 ������ �� �����ϴ�.  
		Node todoDeleted = temp.next;
		// ���� �� ����� ���� ���� ���� �� ��带 �����մϴ�.
		temp.next = temp.next.next;
		// ������ �����͸� �����ϱ� ���ؼ� returnData�� �����͸� �����մϴ�.
		Object returnData = todoDeleted.data; 
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
		Node temp = head;
		// index-1��° �ε����� ã�� �Ŀ� �� next�� temp ������ �����մϴ�.
		for(int i=0; i<k; i++){
			temp = temp.next;
		}
		return temp.data;
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
	}

}