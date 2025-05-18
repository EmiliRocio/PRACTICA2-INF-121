// Clase base Empleado
class Empleado {
    private String nombre;
    private String apellido;
    private double salarioBase;
    private int añosAntigüedad;

    public Empleado(String nombre, String apellido, double salarioBase, int añosAntigüedad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.salarioBase = salarioBase;
        this.añosAntigüedad = añosAntigüedad;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    
    public double getSalarioBase() { return salarioBase; }
    public void setSalarioBase(double salarioBase) { this.salarioBase = salarioBase; }
    
    public int getAñosAntigüedad() { return añosAntigüedad; }
    public void setAñosAntigüedad(int añosAntigüedad) { this.añosAntigüedad = añosAntigüedad; }

    public double calcularSalario() {
        return salarioBase + (salarioBase * 0.05 * añosAntigüedad);
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - Salario base: " + salarioBase + 
               " - Años antigüedad: " + añosAntigüedad;
    }
}

// Clase Gerente que hereda de Empleado
class Gerente extends Empleado {
    private String departamento;
    private double bonoGerencial;

    public Gerente(String nombre, String apellido, double salarioBase, 
                  int añosAntigüedad, String departamento, double bonoGerencial) {
        super(nombre, apellido, salarioBase, añosAntigüedad);
        this.departamento = departamento;
        this.bonoGerencial = bonoGerencial;
    }

    // Getters y setters
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
    
    public double getBonoGerencial() { return bonoGerencial; }
    public void setBonoGerencial(double bonoGerencial) { this.bonoGerencial = bonoGerencial; }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + bonoGerencial;
    }

    @Override
    public String toString() {
        return super.toString() + " - Departamento: " + departamento + 
               " - Bono gerencial: " + bonoGerencial;
    }
}

// Clase Desarrollador que hereda de Empleado
class Desarrollador extends Empleado {
    private String lenguajeProgramacion;
    private int horasExtras;

    public Desarrollador(String nombre, String apellido, double salarioBase, 
                        int añosAntigüedad, String lenguajeProgramacion, int horasExtras) {
        super(nombre, apellido, salarioBase, añosAntigüedad);
        this.lenguajeProgramacion = lenguajeProgramacion;
        this.horasExtras = horasExtras;
    }

    // Getters y setters
    public String getLenguajeProgramacion() { return lenguajeProgramacion; }
    public void setLenguajeProgramacion(String lenguajeProgramacion) { 
        this.lenguajeProgramacion = lenguajeProgramacion; 
    }
    
    public int getHorasExtras() { return horasExtras; }
    public void setHorasExtras(int horasExtras) { this.horasExtras = horasExtras; }

    @Override
    public double calcularSalario() {
        // Suponemos que cada hora extra vale el 1% del salario base
        return super.calcularSalario() + (getSalarioBase() * 0.01 * horasExtras);
    }

    @Override
    public String toString() {
        return super.toString() + " - Lenguaje: " + lenguajeProgramacion + 
               " - Horas extras: " + horasExtras;
    }
}

public class Main {
    public static void main(String[] args) {
        // b) Crear instancias de Gerente y Desarrollador
        Gerente gerente1 = new Gerente("Carlos", "Gómez", 5000, 5, "TI", 1500);
        Gerente gerente2 = new Gerente("Ana", "Pérez", 4500, 3, "RRHH", 800);
        
        Desarrollador dev1 = new Desarrollador("Luis", "Martínez", 3000, 2, "Java", 15);
        Desarrollador dev2 = new Desarrollador("María", "Rodríguez", 3500, 4, "Python", 8);

        // Mostrar salarios calculados
        System.out.println("=== Salarios calculados ===");
        System.out.println(gerente1 + " - Salario total: " + gerente1.calcularSalario());
        System.out.println(gerente2 + " - Salario total: " + gerente2.calcularSalario());
        System.out.println(dev1 + " - Salario total: " + dev1.calcularSalario());
        System.out.println(dev2 + " - Salario total: " + dev2.calcularSalario());

        // c) Mostrar gerentes con bono gerencial > 1000
        System.out.println("\n=== Gerentes con bono > 1000 ===");
        Gerente[] gerentes = {gerente1, gerente2};
        for (Gerente g : gerentes) {
            if (g.getBonoGerencial() > 1000) {
                System.out.println(g + " - Bono: " + g.getBonoGerencial());
            }
        }

        // d) Mostrar desarrolladores con más de 10 horas extras
        System.out.println("\n=== Desarrolladores con más de 10 horas extras ===");
        Desarrollador[] desarrolladores = {dev1, dev2};
        for (Desarrollador d : desarrolladores) {
            if (d.getHorasExtras() > 10) {
                System.out.println(d + " - Horas extras: " + d.getHorasExtras());
            }
        }
    }
}