import java.util.ArrayList;
import java.util.List;

// Clase Parte
class Parte {
    private String nombre;
    private double peso;

    public Parte(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public void mostrarInfo() {
        System.out.println("Parte: " + nombre + ", Peso: " + peso + " kg");
    }
}

// Clase Avión que contiene Partes (composición)
class Avion {
    private String modelo;
    private String fabricante;
    private List<Parte> partes;

    public Avion(String modelo, String fabricante) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.partes = new ArrayList<>();
    }

    // Getters y setters
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    
    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }
    
    public List<Parte> getPartes() { return partes; }

    public void agregarParte(Parte parte) {
        partes.add(parte);
    }

    public void mostrarAvion() {
        System.out.println("Avión: " + modelo + " - Fabricante: " + fabricante);
        System.out.println("Partes del avión:");
        for (Parte p : partes) {
            p.mostrarInfo();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // b) Crear un avión y agregar partes
        Avion boeing747 = new Avion("747", "Boeing");
        
        boeing747.agregarParte(new Parte("Motor izquierdo", 4500));
        boeing747.agregarParte(new Parte("Motor derecho", 4500));
        boeing747.agregarParte(new Parte("Ala izquierda", 12000));
        boeing747.agregarParte(new Parte("Ala derecha", 12000));
        boeing747.agregarParte(new Parte("Tren de aterrizaje delantero", 2500));
        boeing747.agregarParte(new Parte("Tren de aterrizaje principal", 3500));

        // c) Mostrar información del avión y sus partes
        boeing747.mostrarAvion();
    }
}