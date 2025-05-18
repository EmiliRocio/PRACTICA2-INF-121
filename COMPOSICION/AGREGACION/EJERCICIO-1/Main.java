import java.util.ArrayList;
import java.util.List;

// Clase Habitación
class Habitacion {
    private String nombre;
    private double tamaño;

    public Habitacion(String nombre, double tamaño) {
        this.nombre = nombre;
        this.tamaño = tamaño;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public double getTamaño() { return tamaño; }
    public void setTamaño(double tamaño) { this.tamaño = tamaño; }

    public void mostrarInfo() {
        System.out.println("Habitación: " + nombre + ", Tamaño: " + tamaño + " m²");
    }
}

// Clase Casa que contiene Habitaciones (composición)
class Casa {
    private String direccion;
    private List<Habitacion> habitaciones;

    public Casa(String direccion) {
        this.direccion = direccion;
        this.habitaciones = new ArrayList<>();
    }

    // Getters y setters
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    public List<Habitacion> getHabitaciones() { return habitaciones; }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public void mostrarCasa() {
        System.out.println("Casa en: " + direccion);
        System.out.println("Habitaciones:");
        for (Habitacion h : habitaciones) {
            h.mostrarInfo();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // b) Crear una casa y agregar habitaciones
        Casa miCasa = new Casa("Calle Principal 123");
        
        miCasa.agregarHabitacion(new Habitacion("Sala", 20.5));
        miCasa.agregarHabitacion(new Habitacion("Cocina", 15.0));
        miCasa.agregarHabitacion(new Habitacion("Dormitorio Principal", 25.0));
        miCasa.agregarHabitacion(new Habitacion("Baño", 8.5));

        // c) Mostrar información de la casa y sus habitaciones
        miCasa.mostrarCasa();
    }
}