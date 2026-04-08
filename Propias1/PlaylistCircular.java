package Propias1;

public class PlaylistCircular {
    private static class Nodo {
        String cancion;
        Nodo siguiente;
        Nodo(String c) { cancion = c; }
    }

    private Nodo ultimo; // apuntará al último elemento para facilitar inserciones
    private int tamaño = 0;

    public void agregar(String cancion) {
        Nodo n = new Nodo(cancion);
        if (ultimo == null) {
            ultimo = n;
            ultimo.siguiente = ultimo;
        } else {
            n.siguiente = ultimo.siguiente;
            ultimo.siguiente = n;
            ultimo = n;
        }
        tamaño++;
    }

    public boolean eliminar(String cancion) {
        if (ultimo == null) return false;
        Nodo p = ultimo.siguiente; // inicio
        Nodo prev = ultimo;
        int recorridos = 0;
        while (recorridos < tamaño) {
            if (p.cancion.equals(cancion)) {
                if (p == ultimo && tamaño == 1) {
                    ultimo = null;
                } else {
                    prev.siguiente = p.siguiente;
                    if (p == ultimo) ultimo = prev;
                }
                tamaño--;
                return true;
            }
            prev = p;
            p = p.siguiente;
            recorridos++;
        }
        return false;
    }

    public void avanzar() {
        if (ultimo != null) ultimo = ultimo.siguiente;
    }

    public String actual() {
        return (ultimo != null) ? ultimo.siguiente.cancion : null;
    }

    public void mostrar() {
        System.out.println("Playlist circular:");
        if (ultimo == null) { System.out.println("  (vacía)"); return; }
        Nodo p = ultimo.siguiente;
        int i = 0;
        do {
            System.out.print("  [" + i + "] " + p.cancion);
            p = p.siguiente;
            i++;
            if (p != ultimo.siguiente) System.out.print(" ->");
        } while (p != null && p != ultimo.siguiente);
        System.out.println();
    }

    public boolean buscar(String cancion) {
        if (ultimo == null) return false;
        Nodo p = ultimo.siguiente;
        int recorridos = 0;
        while (recorridos < tamaño) {
            if (p.cancion.equals(cancion)) return true;
            p = p.siguiente;
            recorridos++;
        }
        return false;
    }

    public int tamaño() { return tamaño; }
}
