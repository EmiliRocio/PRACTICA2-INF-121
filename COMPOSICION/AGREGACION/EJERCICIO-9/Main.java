import java.util.ArrayList;
import java.util.List;

// Clase Producto
class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public void mostrarInfo() {
        System.out.println("Producto: " + nombre + ", Precio: $" + precio);
    }
}

// Clase CarritoCompras (agregación con Producto)
class CarritoCompras {
    private static final int MAX_PRODUCTOS = 10;
    private List<Producto> productos;

    public CarritoCompras() {
        this.productos = new ArrayList<>();
    }

    // Getters
    public List<Producto> getProductos() { return productos; }

    public void agregarProducto(Producto producto) {
        if (productos.size() < MAX_PRODUCTOS) {
            productos.add(producto);
            System.out.println("Producto '" + producto.getNombre() + "' agregado al carrito");
        } else {
            System.out.println("¡No se puede agregar '" + producto.getNombre() + "'! El carrito está lleno (máximo " + MAX_PRODUCTOS + " productos)");
        }
    }

    public void mostrarCarrito() {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío");
            return;
        }

        System.out.println("Contenido del carrito:");
        double total = 0;
        for (Producto p : productos) {
            p.mostrarInfo();
            total += p.getPrecio();
        }
        System.out.println("Total: $" + total);
        System.out.println("Productos en carrito: " + productos.size() + "/" + MAX_PRODUCTOS);
    }
}

public class Main {
    public static void main(String[] args) {
        // b) Crear productos independientes
        Producto p1 = new Producto("Laptop", 1200.00);
        Producto p2 = new Producto("Teléfono", 800.50);
        Producto p3 = new Producto("Tablet", 350.75);
        Producto p4 = new Producto("Auriculares", 150.25);
        Producto p5 = new Producto("Mouse", 25.99);
        Producto p6 = new Producto("Teclado", 45.50);
        Producto p7 = new Producto("Monitor", 300.00);
        Producto p8 = new Producto("Impresora", 200.00);
        Producto p9 = new Producto("Disco Duro", 120.00);
        Producto p10 = new Producto("Webcam", 75.00);
        Producto p11 = new Producto("Micrófono", 90.00);

        // Crear carrito y agregar productos
        CarritoCompras carrito = new CarritoCompras();
        
        // Agregar productos (algunos no cabrán)
        carrito.agregarProducto(p1);
        carrito.agregarProducto(p2);
        carrito.agregarProducto(p3);
        carrito.agregarProducto(p4);
        carrito.agregarProducto(p5);
        carrito.agregarProducto(p6);
        carrito.agregarProducto(p7);
        carrito.agregarProducto(p8);
        carrito.agregarProducto(p9);
        carrito.agregarProducto(p10);
        carrito.agregarProducto(p11); // Este no debería agregarse

        // c) Mostrar información del carrito
        System.out.println("\n=== Estado del carrito ===");
        carrito.mostrarCarrito();

        // Demostrar que los productos existen independientemente
        System.out.println("\n=== Productos independientes ===");
        p11.mostrarInfo(); // Producto que no entró en el carrito
    }
}