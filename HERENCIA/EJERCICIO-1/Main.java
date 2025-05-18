// Clase base Vehículo
class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int año;
    protected double precioBase;

    public Vehiculo(String marca, String modelo, int año, double precioBase) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.precioBase = precioBase;
    }

    // Getters y setters
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    
    public int getAño() { return año; }
    public void setAño(int año) { this.año = año; }
    
    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }

    public void mostrarInfo() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + 
                          ", Año: " + año + ", Precio Base: " + precioBase);
    }
}

// Clase Coche que hereda de Vehículo
class Coche extends Vehiculo {
    private int numPuertas;
    private String tipoCombustible;

    public Coche(String marca, String modelo, int año, double precioBase, 
                 int numPuertas, String tipoCombustible) {
        super(marca, modelo, año, precioBase);
        this.numPuertas = numPuertas;
        this.tipoCombustible = tipoCombustible;
    }

    // Getters y setters
    public int getNumPuertas() { return numPuertas; }
    public void setNumPuertas(int numPuertas) { this.numPuertas = numPuertas; }
    
    public String getTipoCombustible() { return tipoCombustible; }
    public void setTipoCombustible(String tipoCombustible) { this.tipoCombustible = tipoCombustible; }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Número de puertas: " + numPuertas + 
                         ", Tipo de combustible: " + tipoCombustible);
    }
}

// Clase Moto que hereda de Vehículo
class Moto extends Vehiculo {
    private int cilindrada;
    private String tipoMotor;

    public Moto(String marca, String modelo, int año, double precioBase, 
                int cilindrada, String tipoMotor) {
        super(marca, modelo, año, precioBase);
        this.cilindrada = cilindrada;
        this.tipoMotor = tipoMotor;
    }

    // Getters y setters
    public int getCilindrada() { return cilindrada; }
    public void setCilindrada(int cilindrada) { this.cilindrada = cilindrada; }
    
    public String getTipoMotor() { return tipoMotor; }
    public void setTipoMotor(String tipoMotor) { this.tipoMotor = tipoMotor; }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Cilindrada: " + cilindrada + 
                          ", Tipo de motor: " + tipoMotor);
    }
}

public class Main {
    public static void main(String[] args) {
        // b) Crear instancias de Coche y Moto
        Coche coche1 = new Coche("Toyota", "Corolla", 2020, 25000, 4, "Gasolina");
        Coche coche2 = new Coche("Ford", "Mustang", 2021, 45000, 2, "Gasolina");
        Coche coche3 = new Coche("Tesla", "Model S", 2022, 80000, 5, "Eléctrico");
        
        Moto moto1 = new Moto("Honda", "CBR600", 2019, 12000, 600, "4T");
        Moto moto2 = new Moto("Yamaha", "MT-07", 2020, 8000, 700, "2T");
        
        // Mostrar información de los vehículos
        System.out.println("=== Información de vehículos ===");
        coche1.mostrarInfo();
        System.out.println("----------------");
        moto1.mostrarInfo();
        System.out.println("----------------");
        
        // c) Mostrar coches con más de 4 puertas
        System.out.println("\n=== Coches con más de 4 puertas ===");
        Coche[] coches = {coche1, coche2, coche3};
        for (Coche c : coches) {
            if (c.getNumPuertas() > 4) {
                c.mostrarInfo();
                System.out.println("----------------");
            }
        }
        
        // d) Mostrar vehículos actuales (año 2025)
        System.out.println("\n=== Vehículos actuales (2025) ===");
        Vehiculo[] vehiculos = {coche1, coche2, coche3, moto1, moto2};
        for (Vehículo v : vehiculos) {
            if (v.getAño() >= 2025) {
                v.mostrarInfo();
                System.out.println("----------------");
            }
        }
    }
}