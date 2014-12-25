package list.linkedlist.implementation;

interface Iterator {
	public boolean hasNext();

	public Object next();
}

public class LinkedList {
	// 첫번째 노드를 가리키는 필드
	private Node head;
	private Node tail;
	private int size = 0;
	private class Node{
		// 데이터가 저장될 필드
		public Object data;
		// 다음 노드를 가리키는 필드
		public Node next;
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		// 노드의 내용을 쉽게 출력해서 확인해볼 수 있는 기능
		public String toString(){
			return String.valueOf(this.data);
		}
	}
	public void addFirst(Object input){
		// 노드를 생성합니다.
		Node temp = new Node(input);
		// 새로운 노드의 다음 노드로 해드를 지정합니다.
		temp.next = head;
		// 헤드로 새로운 노드를 지정합니다.
		head = temp;
		size++;
		if(head.next == null){
			tail = head;
		}
	}
	public void addLast(Object input){
		// 노드를 생성합니다.
		Node temp = new Node(input);
		// 리스트의 노드가 없다면 첫번째 노드를 추가하는 메소드를 사용합니다.
		if(size == 0){
			addFirst(input);
		} else {
			// 마지막 노드의 다음 노드로 생성한 노드를 지정합니다.
			tail.next = temp;
			// 마지막 노드를 갱신합니다.
			tail = temp;
			// 엘리먼트의 개수를 1 증가 시킵니다.
			size++;
		}
	}
	public void add(int k, Object input){
		// 만약 k가 0이라면 첫번째 노드에 추가하는 것이기 때문에 addFirst를 사용합니다.
		if(k == 0){
			addFirst(input);
		} else {
			// 현재 리스트 상에서 첫번째 노드를 temp1으로 담습니다.
			Node temp1 = head;
			// k-1 번 반복문을 실행해서 k-1 노드를 찾습니다.
			for(int i=0; i<k-1; i++){
				temp1 = temp1.next;
			}
			// k 번째 노드를 temp2로 지정합니다.
			Node temp2 = temp1.next;
			// 새로운 노드를 생성합니다.
			Node newNode = new Node(input);
			// temp1의 다음 노드로 새로운 노드를 지정합니다.
			temp1.next = newNode;
			// 새로운 노드의 다음 노드로 temp2를 지정합니다.
			newNode.next = temp2;
			size++;
			// 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기 때문에 tail로 지정합니다.
			if(newNode.next == null){
				tail = newNode;
			}
		}
	}
	public String toString() {
		// 노드가 없다면 []를 리턴합니다.
		if(head == null){
			return "[]";
		}		
		// 탐색을 시작합니다.
		Node temp = head;
		String str = "[";
		// 다음 노드가 없을 때까지 반복문을 실행합니다.
		// 마지막 노드는 다음 노드가 없기 때문에 아래의 구문은 마지막 노드는 제외됩니다.
		while(temp.next != null){
			str += temp.data + ",";
			temp = temp.next;
		}
		// 마지막 노드를 출력결과에 포함시킵니다.
		str += temp.data;
		return str+"]";
	}
	public Object removeFirst(){
		// 첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경합니다.
		Node temp = head;
		head = temp.next;
		// 데이터를 삭제하기 전에 리턴할 값을 임시 변수에 담습니다. 
		Object returnData = temp.data;
		temp = null;
		size--;
		return returnData;
	}
	public Object remove(int k){
		if(k == 0)
			return removeFirst();
		// 첫번째 노드를 temp로 지정합니다.
		Node temp = head;
		// k-1번째 노드(삭제 앞 노드)를 temp로 지정합니다.
        for(int i=0; i<k-1; i++){
            temp = temp.next;
        }
		// 삭제 노드를 todoDeleted에 기록해 둡니다. 
        // 삭제 노드를 지금 제거하면 삭제 앞 노드와 삭제 뒤 노드를 연결할 수 없습니다.  
		Node todoDeleted = temp.next;
		// 삭제 앞 노드의 다음 노드로 삭제 뒤 노드를 지정합니다.
		temp.next = temp.next.next;
		// 삭제된 데이터를 리턴하기 위해서 returnData에 데이터를 저장합니다.
		Object returnData = todoDeleted.data; 
		if(todoDeleted == tail){
			tail = temp;
		}
		// cur.next를 삭제 합니다.
		todoDeleted = null;	
		size--;
		return returnData;
	}
	public int size(){
		return size;
	}
	public Object get(int k){
		Node temp = head;
		// index-1번째 인덱스를 찾은 후에 그 next를 temp 값으로 지정합니다.
		for(int i=0; i<k; i++){
			temp = temp.next;
		}
		return temp.data;
	}
	public Object indexOf(Object data){
		// 탐색 대상이 되는 노드를 temp로 지정합니다.
		Node temp = head;
		// 탐색 대상이 몇번째 엘리먼트에 있는지를 의미하는 변수로 index를 사용합니다.
		int index = 0;
		// 탐색 값과 탐색 대상의 값을 비교합니다. 
		while(temp.data != data){
			temp = temp.next;
			index++;
			// temp의 값이 null이라는 것은 더 이상 탐색 대상이 없다는 것을 의미합니다.이 때 -1을 리턴합니다.
			if(temp == null)
				return -1;
		}
		// 탐색 대상을 찾았다면 대상의 인덱스 값을 리턴합니다.
		return index;
	}

	// 반복자를 생성해서 리턴해줍니다.
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
		
		// 본 메소드를 호출하면 cursor의 참조값이 기존 cursor.next로 변경됩니다. 
		public Object next() {
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.data;
		}
		
		// cursor의 값이 없다면 다시 말해서 더 이상 next를 통해서 가져올 노드가 없다면 false를 리턴합니다.
		// 이를 통해서 next를 호출해도 되는지를 사전에 판단할 수 있습니다. 
		public boolean hasNext() {
			return nextIndex < size();
		}
		
	}

}