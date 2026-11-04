package tema3.listas;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList lista = new LinkedList();

        // 1. Inserción inicial según la teoría
        lista.addNode("A");
        lista.addNode("B");
        lista.addNode("D");
        lista.addNode("E");

        System.out.println("Lista inicial (tamaño " + lista.getSize() + "):");
        lista.showList();

        // 2. Insertar "C" en la posición 2
        System.out.println("\nInsertando 'C' en la posición 2...");
        lista.addNode(2, "C");
        lista.showList();

        // 3. Borrar el elemento de la posición 2 ("C")
        System.out.println("\nBorrando posición 2...");
        lista.deleteNode(2);
        lista.showList();

        // 4. Borrar la cabeza (posición 0: "A")
        System.out.println("\nBorrando cabecera (posición 0)...");
        lista.deleteNode(0);
        lista.showList();
		
	}

}
