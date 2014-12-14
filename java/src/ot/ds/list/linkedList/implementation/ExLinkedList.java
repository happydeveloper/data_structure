package ot.ds.list.linkedList.implementation;

public class ExLinkedList {
	private Vertex head;
	private Vertex tail;
	class Vertex{
		public int data;
		public Vertex next;
		public Vertex(int input) {
			this.data = input;
			this.next = null;
		}
		public String toString(){
			return String.valueOf(this.data);
		}
	}
	public void add(int k, int input){
		if(k == 0){
			addFirst(input);
		} else {
			Vertex temp1 = head;
			while(--k != 0){
				temp1 = temp1.next;
			}
			Vertex temp2 = temp1.next;
			Vertex newVertex = new Vertex(input);
			temp1.next = newVertex;
			newVertex.next = temp2;
			if(newVertex.next == null){
				tail = newVertex;
			}
		}
	}
	public void addFirst(int input){
		Vertex temp = new Vertex(input);
		temp.next = head;
		head = temp;
		if(head.next == null){
			tail = head;
		}
	}
	public void addLast(int input){
		Vertex temp = new Vertex(input);
		tail.next = temp;
		tail = temp;
	}
	public int indexOf(int input){
		Vertex temp = head;
		int index = 0;
		while(temp.data != input){
			temp = temp.next;
			index++;
			if(temp == null)
				return -1;
		}
		return index;
	}
	public int remove(int k){
		Vertex cur = head;
		while(--k != 0){
			cur = cur.next;
		}
		Vertex todoDeleted = cur.next;
		cur.next = cur.next.next;
		todoDeleted = null;	
		return head.data;
		
	}
	public int removeFirst(){
		Vertex temp = head;
		head = head.next;
		int returnValue = temp.data;
		temp = null;
		return returnValue;
	}
	public int removeLast(){
		Vertex prev = head;
		Vertex temp = head.next;
		while(temp.next != null){
			temp = temp.next;
			prev = prev.next;
		}
		int returnValue = prev.next.data;
		prev.next = null;
		temp  = null;
		tail = prev;		
		return returnValue;
	}
	public String toString() {
		if(head == null){
			return "";
		}		
		Vertex temp = head;
		String str = "[";
		while(temp.next != null){
			str += temp.data + ",";
			temp = temp.next;
		}
		str += temp.data;
		return str+"]";
	}
	
}