package tema3.listas;

public class Node {
	private Object data;	// Contiene la información a guardar y tratar
	private Node nextNode;	// Objeto de tipo Nodo que sigue en la lista
	
	//Aqui no se gestionan conceptos como Head (cabecera)  lastNode (úlitmo nodo) esos son conceptos con sentido cuando se gestiona una lista.
	
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
