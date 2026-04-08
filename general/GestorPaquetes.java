import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class GestorPaquetes<T>{

    public PriorityQueue<Paquete> listaPaquetes;

    public GestorPaquetes() {
        this.listaPaquetes = new PriorityQueue<>(new ComparadorPaquete());
    }

    public void agregarPaquete(Paquete paquete){
        listaPaquetes.add(paquete);
    }

    public void eliminar(){
        listaPaquetes.poll();
    }

    public void recorrer(){
        Iterator<Paquete> it = listaPaquetes.iterator();
        recursividad(it);
    }

    private void recursividad(Iterator<Paquete> it){
        if (it.hasNext()){
            System.out.println(it.next());
            recursividad(it);
        }
    }

    private static class ComparadorPaquete implements Comparator<Paquete>{
        @Override
        public int compare(Paquete p1, Paquete p2){
            return Integer.compare(p2.getPrioridad(), p1.getPrioridad());
        }
    }

    public static class Paquete implements Comparable<Paquete>{

        String id;
        int prioridad;
        String direccion;

        public Paquete(String id, int prioridad, String direccion){
            this.id = id;
            this.prioridad = prioridad;
            this.direccion = direccion;
        }

        @Override
        public int compareTo(Paquete p2){
            return this.id.compareTo(p2.id);
        }

        public String getId() {
            return id;
        }

        public int getPrioridad() {
            return prioridad;
        }

        public String getDireccion() {
            return direccion;
        }

        @Override
        public String toString() {
            return "id=" + id + ", prioridad=" + prioridad + ", direccion=" + direccion;
        }
    }

    public static void main(String[] args) {
        GestorPaquetes gestor = new GestorPaquetes();

        gestor.agregarPaquete(new Paquete("null", 100, "Calle 1"));
        gestor.agregarPaquete(new Paquete("1", 2, "Calle 2"));
        gestor.agregarPaquete(new Paquete("null", 300, "Calle 3"));

        gestor.agregarPaquete(new Paquete("null", 4, null));
        gestor.agregarPaquete(new Paquete("null", 500, null));

        gestor.recorrer();


        gestor.eliminar();


        gestor.recorrer();

        gestor.eliminar();

        gestor.recorrer();

        gestor.eliminar();

        gestor.recorrer();
        
        gestor.eliminar();

        gestor.recorrer();

        gestor.eliminar();

        gestor.recorrer();

    }
}