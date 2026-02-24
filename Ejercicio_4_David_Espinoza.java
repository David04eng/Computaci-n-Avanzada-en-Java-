public class Ejercicio_4_David_Espinoza {

    static class Node {
        int valor;
        Node siguiente;

        public Node(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    static class ListaSimple {
        Node inicio;

        public void insertarFinal(int valor) {
            Node nuevo = new Node(valor);

            if (inicio == null) {
                inicio = nuevo;
                return;
            }

            Node actual = inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }

            actual.siguiente = nuevo;
        }

        public void reverse() {
            Node anterior = null;
            Node actual = inicio;
            Node siguiente;

            while (actual != null) {

                siguiente = actual.siguiente;

                actual.siguiente = anterior;

                anterior = actual;
                actual = siguiente;
            }

            inicio = anterior;
        }

        public void mostrar() {
            Node actual = inicio;

            while (actual != null) {
                System.out.print(actual.valor + " -> ");
                actual = actual.siguiente;
            }

            System.out.println("null");
        }
    }

    public static void main(String[] args) {

        ListaSimple lista = new ListaSimple();

        lista.insertarFinal(10);
        lista.insertarFinal(20);
        lista.insertarFinal(30);
        lista.insertarFinal(40);

        System.out.println("Lista original:");
        lista.mostrar();

        lista.reverse();

        System.out.println("\nLista invertida:");
        lista.mostrar();
    }
}