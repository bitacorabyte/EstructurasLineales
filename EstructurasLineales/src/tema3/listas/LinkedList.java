package tema3.listas;

public class LinkedList {
	private Node head;	// Reference to the first node (head of the list)
	private Node lastNode; // Reference to the last node (tail/lastNode) for O(1) appending
	private int size;	// Number of elements currently stored in the list
	
	// Memory references are encapsulated within the Node class; this class manages full Node objects and the overall list size.
	
	//Constructor
	public LinkedList() {
		this.head=null;
		this.lastNode=null;
		this.size=0;
	}
	
	/**
	 * Appends a new node containing 'data' at the end of the list
	 * @param data payload to be stored inside the new node
	 * @author bitacorabyte
	 */
	public void addNode(Object data) {
		Node newNode = new Node(data);
		// Case 1: Empty list (head is null)
		if (head == null) {
			head=newNode;
			lastNode=newNode;
		}else { 
			// Case 2: Non-empty list, link after lastNode and update reference
			lastNode.setNextNode(newNode);
			lastNode = newNode;
		}
		// update list size
		size++;
	}
	
	/**
	 * Inserts a new node at a specific zero-based index
	 * @param position zero-based index where the element will be inserted
     * @param data payload to be stored inside the new node
     * @throws IndexOutOfBoundsException if position is negative or greater than size
	 * @author bitacorabyte
	 */
	public void addNode(int position, Object node) {
		// Validate insertion boundaries: index must be between 0 and size
		if (position < 0 || position > size) {
			throw new IndexOutOfBoundsException("Posición fuera de rango: " + position);
		}else if (position==size) {
			// Specific case: append at the end (delegate to addNode, which handles size++)
			addNode(node);
		}else {
			Node newNode = new Node(node);
			if (position==0) {
				// Specific case: insert at the beginning (new head)
				newNode.setNextNode(head);
				head=newNode;
			}else {
				// Traverse the chain up to node at (position - 1)
				Node currentNode = head;
				for (int i=0; i<position-1; i++) {
					currentNode=currentNode.getNextNode();	
				}
				// Splice the new node between currentNode and its successor
				Node aux = currentNode.getNextNode(); 
				currentNode.setNextNode(newNode);
				newNode.setNextNode(aux);
			}
			size++;	// Increment size only for head or intermediate insertions
		}
	}
	
	/**
	 * Delete a Node in position "position"
	 * @param position zero-based index of the element to delete
     * @throws IndexOutOfBoundsException if position is negative or greater than or equal to size
	 * @author bitacorabyte
	 */
	public void deleteNode(int position) {
		// Validate removal boundaries: index must be strictly within [0, size - 1]
		if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Posición inválida: " + position);
        }

		// Case 1: Deleting the head element
        if (position == 0) {
            head = head.getNextNode();
            if (size == 1) {
                lastNode = null;
            }
        } else {
        	// Case 2: Deleting an intermediate or tail element
            Node currentNode = head;
            for (int i = 0; i < position - 1; i++) {
                currentNode = currentNode.getNextNode();
            }
            Node nodoABorrar = currentNode.getNextNode();
            currentNode.setNextNode(nodoABorrar.getNextNode());

            // If the deleted node was the last one, update lastNode pointer
            if (position == size - 1) {
                lastNode = currentNode;
            }
        }
        size--;
	}
	
	/**
	 * Traverses from 'head' and retrieves the payload at the requested index
	 * @param position zero-based index of the element to retrieve
	 * @return the payload stored in the target node
	 * @throws IndexOutOfBoundsException if position is negative or greater than or equal to size
	 * @author bitcorabyte
	 */
	public Object getNode(int position) {
		if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Posición inválida: " + position);
        }
        Node currentNode = head;
        for (int i = 0; i < position; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getData();
    }

	/**
	 * Returns current number of nodes in O(1)
	 * @return number of elements in O(1) time complexity
	 * @author bitacorabyte
	 */
	public int getSize() {
		return this.size;
	}
	
	/**
	 * Helper method to display list state in console
	 * @author bitacorabyte
	 */
    public void showList() {
        Node currentNode = head;
        StringBuilder sb = new StringBuilder();
        while (currentNode != null) {
            sb.append("[").append(currentNode.getData()).append("] -> ");
            currentNode = currentNode.getNextNode();
        }
        sb.append("null");
        System.out.println(sb.toString());
    }
}
