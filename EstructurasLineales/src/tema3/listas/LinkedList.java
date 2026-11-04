package tema3.listas;

public class LinkedList {
	private Node head;	//Es el nodo de cabecera
	private Node lastNode; //Es el último nodo
	private int size;	//Cantidad de nodos en la lista
	
	//En esta clase no se gestionan direcciones porque eso es cosa del nodo, aquí se gestonan objetos nodos "completo" y el tamaño de la propia lista
	
	//Constructor
	public LinkedList() {
		this.head=null;
		this.lastNode=null;
		this.size=0;
	}
	
	// Añadir nodo al final de la lista
	public void addNode(Object node) {
		Node newNode = new Node(node);	//Creamos el objeto newNode de tipo Node para recoger el parámetro
		// Hay que diferenciar 2 casos, si la lista está vacia. Esto es cuando head (objeto de tipo Node) está vacio
		if (head == null) {
			head=newNode;
			lastNode=newNode;
		}else { //y el caso contrario, que la lista no está vacia, ya contiene algún elemento, ya hay un Node en head y se busca el último Node para anexarlo al final
			lastNode.setNextNode(newNode);
			lastNode = newNode;
		}
		// Actualizamos el tamaño de la lista
		size++;
	}
	
	// Añadir un nodo en una posición concreta
	public void addNode(int position, Object node) {
		//Lo primero validar datos de entrada, que la posición sea lógica
		if (position < 0 || position > size) {
			// No podemos agragar un nuevo nodo ni en posición negatva ni fuera del tamaño del objeto
			throw new IndexOutOfBoundsException("Posición fuera de rango: " + position);
		// Con la posición validada
		}else if (position==size) {
			// Caso particular, se inserta como último nodo
			addNode(node); //Usamos el método que ya existe en la clase para añadir al final
			size++;
		}else {
			// Se inserta en cualquier otra posisción de la lista
			Node newNode = new Node(node);
			if (position==0) {
				//Se inserta al inicio
				newNode.setNextNode(head); //en el nodo recien insertado, indicamos que su nextNode es el que todavía está en cabecera
				head=newNode; //Actualizamos la cebecera de la lista para que sea el nuevo nodo insertado
			}else {
				Node nodoActual = head;	//Inicializamos un objeto de tipo nodo, al nodo de cabecera, que usaremos para reccorrer la lista
				// Cada iteracción nos asignará el nodo siguiente al actual, por tanto en la primera iteración i=0 y nodo actual será la posición 1 (no la 0)
				// en la segunda iteración i=1 y nodoActual será la posicion 2 (no la 1)
				// en la tercera iteración i=2 por tanto no se ejecuta el if y nodoActual es la posición 2. Nosotros queremos usar esa posición para el nuevo
				// por tanto debemos retroceder un nodo para coger el valor de su nodoSiguiente
				// por eso en la condición del IF se usa "position-1"
				// así en la primera iteración i=0 y nodoActual será el de posición 0
				for (int i=0; i<position-1; i++) {
					nodoActual=nodoActual.getNextNode();	//actualizamos el nodoActual
				}
				Node aux = nodoActual.getNextNode();	//En un nuevo objeto auxiliar de tipo nodo guardamos la referencia al "nodo siguente" que tiene nuestro nodo actual, el que hemos encontrado en las iteraciones 
				nodoActual.setNextNode(newNode);	//En este nodo, le decimos que su siguiente nodo es el nuevo
				newNode.setNextNode(aux);	//Al nuevo le decmos que su siguiente nodo es el que hemos guardo en el auxiliar, que es "siguiente nodo" antigua del nodo encontrado
			}
			size++;	//aumentamo el tamaño de la  lista
		}
		
	}
	
	// Delete a Node in position "position"
	public void deleteNode(int position) {
		if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Posición inválida: " + position);
        }

        if (position == 0) {
            head = head.getNextNode();
            if (size == 1) {
                lastNode = null;
            }
        } else {
            Node actual = head;
            for (int i = 0; i < position - 1; i++) {
                actual = actual.getNextNode();
            }
            Node nodoABorrar = actual.getNextNode();
            actual.setNextNode(nodoABorrar.getNextNode());

            // Si borramos el último nodo, actualizamos ultimoNodo
            if (position == size - 1) {
                lastNode = actual;
            }
        }
        size--;
	}
	
	//Start in "head" and read node by node until position
	public Object getData(int position) {
		return position;
		//Devuelve el dato del Node
	}
	
	//
	public int getSize() {
		return this.size;
	}
	
	// Método auxiliar para imprimir el estado de la lista por consola
    public void showList() {
        Node actual = head;
        StringBuilder sb = new StringBuilder();
        while (actual != null) {
            sb.append("[").append(actual.getData()).append("] -> ");
            actual = actual.getNextNode();
        }
        sb.append("null");
        System.out.println(sb.toString());
    }
}
