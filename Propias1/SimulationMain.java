package Propias1;

public class SimulationMain {
    public static void main(String[] args) {
        System.out.println("--- Escenario 1: Panaderia (Cola) ---");
        ColaPanaderia cola = new ColaPanaderia();
        cola.encolar("Cliente A");
        cola.encolar("Cliente B");
        cola.encolar("Cliente C");
        cola.mostrar();
        System.out.println("Siguiente: " + cola.siguiente());
        System.out.println("Atendiendo: " + cola.atender());
        cola.mostrar();

        System.out.println();
        System.out.println("--- Escenario 2: Historial Navegador (Doble enlazada) ---");
        HistorialNavegador hist = new HistorialNavegador();
        hist.visitar("google.com");
        hist.visitar("openai.com");
        hist.visitar("github.com");
        hist.mostrarHistorial();
        System.out.println("Retroceder: " + hist.retroceder());
        System.out.println("Pagina actual: " + hist.paginaActual());
        hist.visitar("stackoverflow.com");
        hist.mostrarHistorial();

        System.out.println();
        System.out.println("--- Escenario 3: Playlist Circular ---");
        PlaylistCircular list = new PlaylistCircular();
        list.agregar("Song 1");
        list.agregar("Song 2");
        list.agregar("Song 3");
        list.mostrar();
        System.out.println("Actual: " + list.actual());
        list.avanzar();
        System.out.println("Avanzar -> Actual: " + list.actual());
        list.eliminar("Song 2");
        list.mostrar();

        System.out.println();
        System.out.println("--- Escenario 4: Juego por turnos circular ---");
        JuegoTurnosCircular juego = new JuegoTurnosCircular();
        juego.agregarJugador("Alice");
        juego.agregarJugador("Bob");
        juego.agregarJugador("Carol");
        juego.mostrarOrden();
        System.out.println("Jugador actual: " + juego.jugadorActual());
        juego.siguiente();
        System.out.println("Siguiente turno -> " + juego.jugadorActual());
        juego.eliminarJugador("Bob");
        juego.mostrarOrden();
    }
}
