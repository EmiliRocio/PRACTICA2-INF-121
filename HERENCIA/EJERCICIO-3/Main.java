import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

// Clase base Persona
class Persona {
    protected String ci;
    protected String nombre;
    protected String apellido;
    protected String celular;
    protected LocalDate fechaNa;
    protected String sexo;

    public Persona(String ci, String nombre, String apellido, String celular, LocalDate fechaNa, String sexo) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.fechaNa = fechaNa;
        this.sexo = sexo;
    }

    // Constructor con datos por defecto
    public Persona() {
        this("0000000", "Sin nombre", "Sin apellido", "00000000", LocalDate.now(), "No especificado");
    }

    public int calcularEdad() {
        return Period.between(fechaNa, LocalDate.now()).getYears();
    }

    public void mostrar() {
        System.out.println("CI: " + ci + ", Nombre: " + nombre + " " + apellido + 
                         ", Celular: " + celular + ", Fecha Nacimiento: " + fechaNa + 
                         ", Sexo: " + sexo + ", Edad: " + calcularEdad());
    }

    // Getters
    public String getApellido() { return apellido; }
    public String getSexo() { return sexo; }
    public LocalDate getFechaNa() { return fechaNa; }
}

// Clase Estudiante que hereda de Persona
class Estudiante extends Persona {
    private String ru;
    private LocalDate fechaIngreso;
    private int semestre;

    public Estudiante(String ci, String nombre, String apellido, String celular, 
                     LocalDate fechaNa, String sexo, String ru, LocalDate fechaIngreso, int semestre) {
        super(ci, nombre, apellido, celular, fechaNa, sexo);
        this.ru = ru;
        this.fechaIngreso = fechaIngreso;
        this.semestre = semestre;
    }

    // Constructor con datos por defecto
    public Estudiante() {
        super();
        this.ru = "000000";
        this.fechaIngreso = LocalDate.now();
        this.semestre = 1;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("RU: " + ru + ", Fecha Ingreso: " + fechaIngreso + 
                          ", Semestre: " + semestre);
    }
}

// Clase Docente que hereda de Persona
class Docente extends Persona {
    private String nit;
    private String profesion;
    private String especialidad;

    public Docente(String ci, String nombre, String apellido, String celular, 
                  LocalDate fechaNa, String sexo, String nit, String profesion, String especialidad) {
        super(ci, nombre, apellido, celular, fechaNa, sexo);
        this.nit = nit;
        this.profesion = profesion;
        this.especialidad = especialidad;
    }

    // Constructor con datos por defecto
    public Docente() {
        super();
        this.nit = "0000000";
        this.profesion = "Sin profesión";
        this.especialidad = "Sin especialidad";
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("NIT: " + nit + ", Profesión: " + profesion + 
                          ", Especialidad: " + especialidad);
    }

    // Getters
    public String getProfesion() { return profesion; }
}

public class Main {
    public static void main(String[] args) {
        // Crear lista de estudiantes
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("1234567", "Juan", "Perez", "77712345", 
                                      LocalDate.of(1995, 5, 15), "M", "123456", 
                                      LocalDate.of(2020, 3, 1), 5));
        estudiantes.add(new Estudiante("7654321", "Maria", "Gomez", "77754321", 
                                      LocalDate.of(2000, 8, 20), "F", "654321", 
                                      LocalDate.of(2021, 8, 15), 3));
        estudiantes.add(new Estudiante("9876543", "Carlos", "Perez", "77798765", 
                                      LocalDate.of(1998, 11, 30), "M", "987654", 
                                      LocalDate.of(2019, 1, 10), 7));

        // Crear lista de docentes
        List<Docente> docentes = new ArrayList<>();
        docentes.add(new Docente("1122334", "Pedro", "Lopez", "77711223", 
                               LocalDate.of(1980, 2, 10), "M", "4455667", 
                               "Ingeniero", "Sistemas"));
        docentes.add(new Docente("4433221", "Ana", "Gomez", "77744332", 
                               LocalDate.of(1975, 7, 25), "F", "7788990", 
                               "Licenciada", "Educación"));
        docentes.add(new Docente("5566778", "Luis", "Perez", "77755667", 
                               LocalDate.of(1970, 9, 5), "M", "9900112", 
                               "Ingeniero", "Electrónica"));

        // b) Mostrar todos los estudiantes y docentes
        System.out.println("=== Todos los estudiantes ===");
        for (Estudiante e : estudiantes) {
            e.mostrar();
            System.out.println("----------------");
        }

        System.out.println("\n=== Todos los docentes ===");
        for (Docente d : docentes) {
            d.mostrar();
            System.out.println("----------------");
        }

        // c) Mostrar estudiantes mayores de 25 años
        System.out.println("\n=== Estudiantes mayores de 25 años ===");
        for (Estudiante e : estudiantes) {
            if (e.calcularEdad() > 25) {
                e.mostrar();
                System.out.println("----------------");
            }
        }

        // d) Mostrar docente ingeniero, masculino y mayor
        System.out.println("\n=== Docente ingeniero, masculino y mayor ===");
        Docente mayorIngeniero = null;
        for (Docente d : docentes) {
            if (d.getProfesion().equalsIgnoreCase("ingeniero") && d.getSexo().equals("M")) {
                if (mayorIngeniero == null || d.getFechaNa().isBefore(mayorIngeniero.getFechaNa())) {
                    mayorIngeniero = d;
                }
            }
        }
        if (mayorIngeniero != null) {
            mayorIngeniero.mostrar();
        } else {
            System.out.println("No se encontró docente que cumpla los criterios");
        }

        // e) Mostrar estudiantes y docentes con mismo apellido
        System.out.println("\n=== Personas con mismo apellido ===");
        for (Estudiante e : estudiantes) {
            for (Docente d : docentes) {
                if (e.getApellido().equalsIgnoreCase(d.getApellido())) {
                    System.out.println("Estudiante y Docente con apellido " + e.getApellido() + ":");
                    e.mostrar();
                    d.mostrar();
                    System.out.println("----------------");
                }
            }
        }
    }
}