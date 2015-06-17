
public class SimpleLinkedList {
	protected Node header;
	public SimpleLinkedList(){
		header = null;
	}
	
	public int listSize() {
		int size = 0;
		Node currentNode = header;
		while (currentNode != null) {
			size++;
			currentNode = currentNode.next;
		}
		return size;
	}
	
	public void listContent(){
		Node currentNode = header;
		while (currentNode != null){
			System.out.println(currentNode.data); 
			currentNode = currentNode.next;
		}
	}
	
	public boolean inLinkedList(Object x){
		Node currentNode = header;
		while (currentNode != null){
			if (currentNode.data == x){
				return true;
			}
			currentNode = currentNode.next;
		}
		return false;
	}
	
	public void addItem(Object x){
		boolean inList = inLinkedList(x);
		int n = listSize();
		if (n == 0){
			header = new Node(x,null);
			return;
		}
		if (inList == false){
			Node currentNode = header;
			for (int i = 0; i < n-1; i++){
				currentNode = currentNode.next;
			}
			currentNode = currentNode.next;
			currentNode = new Node(x, null);		
		}
		
	}
	
	public void deleteItem(Object x){
		boolean inList = inLinkedList(x);
		int n = listSize();
		Node prevNode = header;
		if (inList == true){
			Node currentNode = header;
			while (currentNode != null){
				prevNode = currentNode;
				currentNode = currentNode.next;
				if (currentNode.data == x){
					prevNode.next = currentNode.next;
				}
			}
		}
	}
	
	public void reverseList(){
		Node currentNode = header;
		Node prevNode = null;
		Node nextNode;
		while (currentNode != null){
			nextNode = currentNode.next;
			currentNode.next = prevNode; 
			prevNode = currentNode;
			currentNode = nextNode;
		}
		header = prevNode;
	}
	
	public static SimpleLinkedList intersection(SimpleLinkedList L1, SimpleLinkedList L2){
		Node currentNode = L1.header; 
		SimpleLinkedList L3 = new SimpleLinkedList();
		while (currentNode != null){
			if (L2.inLinkedList(currentNode.data)){
				L3.addItem(currentNode.data);
			}
			currentNode = currentNode.next;
		}
		return L3;
	}
	
	public class Node {
		protected Object data;
		protected Node next;
		public Node(Object x, Node n) {
			data = x;
			next = n;	
		}
		
		public Node(){
			data = null;
			next = null;
		}
	}
}
