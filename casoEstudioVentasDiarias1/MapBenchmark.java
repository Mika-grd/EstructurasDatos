import java.util.*;

public class MapBenchmark {

    private static final long DEFAULT_ELEMENTS = 1_000_000; 

    public static void main(String[] args) {

        long elements = DEFAULT_ELEMENTS;
        if (args.length > 0) {
            try {
                elements = Long.parseLong(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Recuento de elementos no válido, usando el valor por defecto: " + DEFAULT_ELEMENTS);
            }
        }

        testMap(new HashMap<>(), "HashMap", elements);
        testMap(new LinkedHashMap<>(), "LinkedHashMap", elements);
        testMap(new TreeMap<>(), "TreeMap", elements);
    }

    private static void testMap(Map<Long, String> map, String name, long elements) {

        Runtime runtime = Runtime.getRuntime();
        System.gc(); 
        try { Thread.sleep(100); } catch (InterruptedException ignored) {}

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        // Medición de inserción
        long startInsert = System.nanoTime();
        try {
            for (long i = 0; i < elements; i++) {
                map.put(i, "Producto" + i);
            }
        } catch (OutOfMemoryError e) {
            System.err.println("OutOfMemoryError al insertar en " + name + ". Intente con un recuento de elementos más pequeño o aumente el tamaño del montón con -Xmx.");
            return;
        }
        long endInsert = System.nanoTime();

        // Medición de búsqueda
        long startSearch = System.nanoTime();
        for (long i = 0; i < elements; i++) {
            map.get(i);
        }
        long endSearch = System.nanoTime();

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

        long insertTime = (endInsert - startInsert) / 1_000_000; // ms
        long searchTime = (endSearch - startSearch) / 1_000_000; // ms
        long memoryUsed = (memoryAfter - memoryBefore) / (1024 * 1024); // MB

        System.out.println("==== " + name + " ====");
        System.out.println("Tiempo inserción: " + insertTime + " ms");
        System.out.println("Tiempo búsqueda: " + searchTime + " ms");
        System.out.println("Memoria aproximada usada: " + memoryUsed + " MB");
        System.out.println();
    }
}