package Propias1;

public class HistorialNavegador {
    private static class Nodo {
        String url;
        Nodo prev;
        Nodo next;
        Nodo(String u) { url = u; }
    }

    private Nodo actual;
    private int tamaño = 0;

    public void visitar(String url) {
        Nodo nodo = new Nodo(url);
        if (actual != null) {
            // cortar el futuro
            actual.next = null;
            nodo.prev = actual;
            actual.next = nodo;
        }
        actual = nodo;
        tamaño++;
    }

    public boolean retroceder() {
        if (actual == null || actual.prev == null) return false;
        actual = actual.prev;
        return true;
    }

    public boolean avanzar() {
        if (actual == null || actual.next == null) return false;
        actual = actual.next;
        return true;
    }

    public String paginaActual() {
        return (actual != null) ? actual.url : null;
    }

    public void mostrarHistorial() {
        System.out.println("Historial (desde el primero hasta el último):");
        // retroceder hasta el inicio
        Nodo p = actual;
        if (p == null) { System.out.println("  (vacío)"); return; }
        while (p.prev != null) p = p.prev;
        while (p != null) {
            if (p == actual) System.out.print(" *" + p.url + "*");
            else System.out.print(" " + p.url);
            if (p.next != null) System.out.print(" ->");
            p = p.next;
        }
        System.out.println();
    }

    public boolean buscar(String url) {
        if (actual == null) return false;
        Nodo p = actual;
        while (p.prev != null) p = p.prev;
        while (p != null) { if (p.url.equals(url)) return true; p = p.next; }
        return false;
    }

    public int tamaño() { return tamaño; }
}
