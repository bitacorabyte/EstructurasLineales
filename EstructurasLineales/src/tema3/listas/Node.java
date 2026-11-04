package tema3.listas;

public class Node {
	private Object data;	// Holds the actual data/payload stored in this node
	private Node nextNode;	// Reference to the next node in the linked chain
	
	// Concepts like 'head' or 'lastNode' belong to the list manager, not here.
	
	//Constructor
	public Node(Object d) {
		this.data = d;
		this.nextNode=null;
	}
	
	//Getters y Setters
	public Object getData() {
		return this.data;
	}
	public void setData(Object d) {
		this.data=d;
	}
	
	public Node getNextNode() {
		return this.nextNode;
	}
	public void setNextNode(Node next) {
		this.nextNode=next;
	}
}
