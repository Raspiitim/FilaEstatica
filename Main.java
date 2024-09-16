package Estatica;

public class Main {

    public static void main(String[] args) {
        Fila f1 = new Fila(5);

        System.out.println("Tamanho da fila: " + f1.size());
        System.out.println("Inserindo na fila: " + f1.enqueue(10));
        System.out.println("Inserindo na fila: " + f1.enqueue(20));
        System.out.println("Inserindo na fila: " + f1.enqueue(30));
        System.out.println("Primeiro elemento da fila: " + f1.front());
        System.out.println("Removendo o primeiro: " + f1.dequeue());
        System.out.println("Primeiro elemento da fila: " + f1.front());
        System.out.println("Tamanho da fila: " + f1.size());
        System.out.println("Primeiro elemento da fila: " + f1.front());
        f1.mostrarFila();
    }
}
