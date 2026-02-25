// Este código demuestra el uso de HashMap, LinkedHashMap y TreeMap para gestionar productos y ventas en un sistema de ventas.
// Caso de estudio: Registro y consulta de ventas por código de producto, mostrando diferencias en ordenamiento y complejidad.



import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    /* ============================================================
       Clase Product
       Representa un producto del sistema.
       ============================================================ */
    static class Product {
        private final String id;
        private final String name;
        private final double price;

        public Product(String id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public double getPrice() { return price; }
    }

    /* ============================================================
       Clase Sale
       Representa una venta asociada a un producto.
       ============================================================ */
    static class Sale {
        private final String productId;
        private final int quantity;

        public Sale(String productId, int quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }

        public String getProductId() { return productId; }
        public int getQuantity() { return quantity; }
    }

    /* ============================================================
       1. Registrar venta por código de producto
       Complejidad:
       - HashMap / LinkedHashMap: O(1) promedio
       - TreeMap: O(log n)
       ============================================================ */
    private static void registerSale(Map<String, Product> productMap,
                                     Map<String, Sale> salesMap,
                                     String productId,
                                     int quantity) {

        Product product = productMap.get(productId);

        if (product != null) {
            salesMap.put(productId, new Sale(productId, quantity));
            System.out.println("Venta registrada -> Producto: "
                    + product.getName() + ", Cantidad: " + quantity);
        } else {
            System.out.println("No se puede registrar la venta. Producto inexistente.");
        }
    }

    /* ============================================================
       2. Consultar producto por código
       Complejidad:
       - HashMap / LinkedHashMap: O(1) promedio
       - TreeMap: O(log n)
       ============================================================ */
    private static void consultProduct(Map<String, Product> productMap,
                                       String productId) {

        Product product = productMap.get(productId);

        if (product != null) {
            System.out.println("Producto encontrado -> "
                    + product.getName() + " | Precio: $" + product.getPrice());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    /* ============================================================
       3. Mostrar todas las ventas registradas
       Complejidad: O(n)
       El orden depende del tipo de Map utilizado.
       ============================================================ */
    private static void showAllSales(Map<String, Sale> salesMap) {

        System.out.println("Listado completo de ventas:");
        for (Sale sale : salesMap.values()) {
            System.out.println("Producto ID: "
                    + sale.getProductId()
                    + " | Cantidad: " + sale.getQuantity());
        }
    }

    /* ============================================================
       4. Mostrar ventas ordenadas por código de producto
       - En TreeMap ya están ordenadas naturalmente.
       - En HashMap y LinkedHashMap se ordenan manualmente.
       Complejidad:
       - TreeMap: O(n)
       - HashMap / LinkedHashMap: O(n log n)
       ============================================================ */
    private static void showSalesSortedByProductId(Map<String, Sale> salesMap) {

        System.out.println("Ventas ordenadas por código de producto:");

        if (salesMap instanceof TreeMap) {
            // Ya están ordenadas por clave
            for (Map.Entry<String, Sale> entry : salesMap.entrySet()) {
                System.out.println("Producto ID: "
                        + entry.getKey()
                        + " | Cantidad: " + entry.getValue().getQuantity());
            }
        } else {
            // Ordenamiento manual
            salesMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry ->
                            System.out.println("Producto ID: "
                                    + entry.getKey()
                                    + " | Cantidad: "
                                    + entry.getValue().getQuantity())
                    );
        }
    }

    /* ============================================================
       5. Mostrar ventas en orden de registro
       - LinkedHashMap respeta orden de inserción.
       - HashMap no lo garantiza.
       - TreeMap ordena por clave, no por inserción.
       Complejidad: O(n)
       ============================================================ */
    private static void showSalesInInsertionOrder(Map<String, Sale> salesMap) {

        System.out.println("Ventas en orden de registro:");

        for (Sale sale : salesMap.values()) {
            System.out.println("Producto ID: "
                    + sale.getProductId()
                    + " | Cantidad: " + sale.getQuantity());
        }
    }

    /* ============================================================
       Método general de demostración
       ============================================================ */
    private static void runDemo(Map<String, Product> productMap,
                                Map<String, Sale> salesMap,
                                String mapType) {

        System.out.println("\n==============================");
        System.out.println("Demostración con " + mapType);
        System.out.println("==============================");

        // Carga de productos (en orden desordenado)
        productMap.put("3", new Product("3", "Tablet", 300));
        productMap.put("1", new Product("1", "Laptop", 1000));
        productMap.put("5", new Product("5", "Keyboard", 50));
        productMap.put("2", new Product("2", "Phone", 500));
        productMap.put("4", new Product("4", "Monitor", 200));

        // 1. Registrar ventas
        registerSale(productMap, salesMap, "3", 2);
        registerSale(productMap, salesMap, "1", 5);
        registerSale(productMap, salesMap, "5", 1);
        registerSale(productMap, salesMap, "2", 3);
        registerSale(productMap, salesMap, "4", 4);

        // 2. Consultar producto
        System.out.println("\nConsulta de producto (ID=2):");
        consultProduct(productMap, "2");

        // 3. Mostrar todas las ventas
        System.out.println();
        showAllSales(salesMap);

        // 4. Mostrar ventas ordenadas por código
        System.out.println();
        showSalesSortedByProductId(salesMap);

        // 5. Mostrar ventas en orden de registro
        System.out.println();
        showSalesInInsertionOrder(salesMap);
    }

    public static void main(String[] args) {

        runDemo(new HashMap<>(), new HashMap<>(), "HashMap");
        runDemo(new LinkedHashMap<>(), new LinkedHashMap<>(), "LinkedHashMap");
        runDemo(new TreeMap<>(), new TreeMap<>(), "TreeMap");
    }
}