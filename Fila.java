package Estatica;

public class Fila {
    private Object[] elemento;
    private int inicio;
    private int fim;
    private int tamanho;

    public Fila(int capacidade) {
        this.elemento = new Object[capacidade];
        this.inicio = 0;
        this.fim = -1;
        this.tamanho = 0;
    }

    // Adiciona um elemento ao final da fila (enqueue)
    public Boolean enqueue(Object elemento) {
        if (this.tamanho < this.elemento.length) {
            this.fim = (this.fim + 1) % this.elemento.length; // Operação circular
            this.elemento[this.fim] = elemento;
            this.tamanho++;
            return true;
        }
        return false; // Fila cheia
    }

    // Remove um elemento do início da fila (dequeue)
    public Object dequeue() {
        if (!isEmpty()) {
            Object removido = this.elemento[this.inicio];
            this.inicio = (this.inicio + 1) % this.elemento.length; // Operação circular
            this.tamanho--;
            return removido;
        }
        return null; // Fila vazia
    }

    // Verifica se a fila está vazia
    public Boolean isEmpty() {
        return this.tamanho == 0;
    }

    // Verifica o tamanho da fila
    public int size() {
        return this.tamanho;
    }

    // Retorna o primeiro elemento da fila
    public Object front() {
        if (!this.isEmpty()) {
            return this.elemento[this.inicio];
        }
        return null;
    }

    // Aumenta a capacidade da fila
    private void aumentarCapacidade() {
        int novaCapacidade = this.elemento.length * 2;
        Object[] novoArray = new Object[novaCapacidade];
        for (int i = 0; i < this.elemento.length; i++) {
            novoArray[i] = this.elemento[(this.inicio + i) % this.elemento.length];
        }
        this.elemento = novoArray;
        this.inicio = 0;
        this.fim = this.tamanho - 1;
    }

    // Adiciona elemento aumentando a capacidade se necessário
    public Boolean enqueueAumentaCap(Object elemento) {
        if (this.tamanho == this.elemento.length) {
            aumentarCapacidade();
        }
        return enqueue(elemento);
    }

    // Verifica se uma fila tem mais elementos que outra
    public Boolean verificaF1F2(Fila f1, Fila f2) {
        return f1.size() > f2.size();
    }

    // Verifica se duas filas são iguais
    public Boolean filasIguais(Fila f1, Fila f2) {
        if (f1.size() != f2.size()) {
            return false;
        }
        for (int i = 0; i < f1.size(); i++) {
            if (!f1.elemento[(f1.inicio + i) % f1.elemento.length].equals(f2.elemento[(f2.inicio + i) % f2.elemento.length])) {
                return false;
            }
        }
        return true;
    }

    // Duplica os elementos da fila
    public void duplicarElementos() {
        int tamanhoAtual = size();
        if (tamanhoAtual == 0) return;

        if (this.tamanho + tamanhoAtual > this.elemento.length) {
            aumentarCapacidade();
        }

        for (int i = 0; i < tamanhoAtual; i++) {
            enqueue(this.elemento[(this.inicio + i) % this.elemento.length]);
        }
    }

    // Remove um elemento específico da fila
    public void removerElemento(Object elemento) {
        Fila filaAuxiliar = new Fila(this.size());

        while (!this.isEmpty()) {
            Object primeiroElemento = this.dequeue();
            if (!primeiroElemento.equals(elemento)) {
                filaAuxiliar.enqueue(primeiroElemento);
            }
        }

        while (!filaAuxiliar.isEmpty()) {
            this.enqueue(filaAuxiliar.dequeue());
        }
    }

    // Exibe os elementos da fila
    public void mostrarFila() {
        if (this.isEmpty()) {
            System.out.println("A fila está vazia.");
            return;
        }

        System.out.println("Conteúdo da fila (do início para o fim):");
        for (int i = 0; i < this.tamanho; i++) {
            System.out.println(this.elemento[(this.inicio + i) % this.elemento.length]);
        }
    }

    // Intercala duas filas em uma nova fila
    public static Fila intercalar(Fila f1, Fila f2) {
        int novaCapacidade = f1.size() + f2.size();
        Fila novaFila = new Fila(novaCapacidade);

        while (!f1.isEmpty() || !f2.isEmpty()) {
            if (!f1.isEmpty()) {
                novaFila.enqueue(f1.dequeue());
            }
            if (!f2.isEmpty()) {
                novaFila.enqueue(f2.dequeue());
            }
        }

        return novaFila;
    }

    // Getter e Setter para os elementos da fila
    public Object[] getElemento() {
        return elemento;
    }

    public void setElemento(Object[] elemento) {
        this.elemento = elemento;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFim() {
        return fim;
    }

    public void setFim(int fim) {
        this.fim = fim;
    }
}

