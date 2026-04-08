package Propias1;

public class JuegoTurnosCircular {
    private static class Nodo {
        String jugador;
        Nodo prev;
        Nodo next;
        Nodo(String j) { jugador = j; }
    }

    private Nodo actual;
    private int tamaño = 0;

    public void agregarJugador(String nombre) {
        Nodo n = new Nodo(nombre);
        if (actual == null) {
            actual = n;
            actual.next = actual.prev = actual;
        } else {
            Nodo last = actual.prev;
            last.next = n;
            n.prev = last;
            n.next = actual;
            actual.prev = n;
        }
        tamaño++;
    }

    public boolean eliminarJugador(String nombre) {
        if (actual == null) return false;
        Nodo p = actual;
        int recorridos = 0;
        while (recorridos < tamaño) {
            if (p.jugador.equals(nombre)) {
                if (tamaño == 1) { actual = null; }
                else {
                    p.prev.next = p.next;
                    p.next.prev = p.prev;
                    if (p == actual) actual = p.next;
                }
                tamaño--;
                return true;
            }
            p = p.next;
            recorridos++;
        }
        return false;
    }

    public void siguiente() {
        if (actual != null) actual = actual.next;
    }

    public void anterior() {
        if (actual != null) actual = actual.prev;
    }

    public String jugadorActual() {
        return (actual != null) ? actual.jugador : null;
    }

    public void mostrarOrden() {
        System.out.println("Orden de jugadores (circular):");
        if (actual == null) { System.out.println("  (vacío)"); return; }
        Nodo p = actual;
        int i = 0;
        do {
            System.out.print("  [" + i + "] " + p.jugador);
            p = p.next;
            i++;
            if (p != actual) System.out.print(" ->");
        } while (p != actual);
        System.out.println();
    }

    public int tamaño() { return tamaño; }
}
