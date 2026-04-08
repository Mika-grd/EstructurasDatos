package Propias1;

public class ColaPanaderia {
    private static class Nodo {
        String cliente;
        Nodo siguiente;
        Nodo(String c) { cliente = c; }
    }

    private Nodo frente;
    private Nodo fin;
    private int tamaño = 0;

    public void encolar(String cliente) {
        Nodo nodo = new Nodo(cliente);
        if (fin == null) {
            frente = fin = nodo;
        } else {
            fin.siguiente = nodo;
            fin = nodo;
        }
        tamaño++;
    }

    public String atender() {
        if (frente == null) return null;
        String nombre = frente.cliente;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        tamaño--;
        return nombre;
    }

    public String siguiente() {
        return (frente != null) ? frente.cliente : null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public boolean buscar(String cliente) {
        Nodo p = frente;
        while (p != null) {
            if (p.cliente.equals(cliente)) return true;
            p = p.siguiente;
        }
        return false;
    }

    public void mostrar() {
        System.out.println("Cola de turnos (frente -> fin):");
        Nodo p = frente;
        if (p == null) {
            System.out.println("  (vacía)");
            return;
        }
        while (p != null) {
            System.out.print("  " + p.cliente);
            if (p.siguiente != null) System.out.print(" ->");
            p = p.siguiente;
        }
        System.out.println();
    }

    public int tamaño() { return tamaño; }
}
