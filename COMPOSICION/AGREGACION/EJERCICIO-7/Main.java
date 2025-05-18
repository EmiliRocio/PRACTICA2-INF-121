import java.util.ArrayList;
import java.util.List;

// Clase Estudiante
class Estudiante {
    private String nombre;
    private String carrera;
    private int semestre;

    public Estudiante(String nombre, String carrera, int semestre) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.semestre = semestre;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }
    
    public int getSemestre() { return semestre; }
    public void setSemestre(int semestre) { this.semestre = semestre; }

    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + ", Carrera: " + carrera + 
                         ", Semestre: " + semestre);
    }
}

// Clase Universidad (agregación con Estudiante)
class Universidad {
    private String nombre;
    private List<Estudiante> estudiantes;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public List<Estudiante> getEstudiantes() { return estudiantes; }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void mostrarUniversidad() {
        System.out.println("Universidad: " + nombre);
        System.out.println("Estudiantes:");
        for (Estudiante e : estudiantes) {
            e.mostrarInfo();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // b) Crear estudiantes independientes
        Estudiante est1 = new Estudiante("Juan Pérez", "Ingeniería Informática", 4);
        Estudiante est2 = new Estudiante("María Gómez", "Medicina", 6);
        Estudiante est3 = new Estudiante("Carlos López", "Derecho", 2);
        
        // Crear universidad y agregar estudiantes
        Universidad umca = new Universidad("UMCA");
        umca.agregarEstudiante(est1);
        umca.agregarEstudiante(est2);
        
        Universidad otraUni = new Universidad("Otra Universidad");
        otraUni.agregarEstudiante(est3);
        otraUni.agregarEstudiante(est2);  // Mismo estudiante en otra universidad

        // c) Mostrar información de las universidades
        System.out.println("=== Información UMCA ===");
        umca.mostrarUniversidad();
        
        System.out.println("\n=== Información Otra Universidad ===");
        otraUni.mostrarUniversidad();
        
        // Demostrar que los estudiantes existen independientemente
        System.out.println("\n=== Información de estudiantes independientes ===");
        est1.mostrarInfo();
        est2.mostrarInfo();
        est3.mostrarInfo();
    }
}