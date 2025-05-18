import java.util.ArrayList;
import java.util.List;

// Clase base Jugador
abstract class Jugador {
    private String nombre;
    private int numero;
    private String posicion;

    public Jugador(String nombre, int numero, String posicion) {
        this.nombre = nombre;
        this.numero = numero;
        this.posicion = posicion;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    
    public String getPosicion() { return posicion; }
    public void setPosicion(String posicion) { this.posicion = posicion; }

    public abstract String getHabilidadEspecial();

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + ", Número: " + numero + 
                         ", Posición: " + posicion + 
                         ", Habilidad especial: " + getHabilidadEspecial());
    }
}

// Clases derivadas de Jugador
class Portero extends Jugador {
    public Portero(String nombre, int numero) {
        super(nombre, numero, "Portero");
    }

    @Override
    public String getHabilidadEspecial() {
        return "Atajadas";
    }
}

class Defensa extends Jugador {
    public Defensa(String nombre, int numero) {
        super(nombre, numero, "Defensa");
    }

    @Override
    public String getHabilidadEspecial() {
        return "Marcaje";
    }
}

class Mediocampista extends Jugador {
    public Mediocampista(String nombre, int numero) {
        super(nombre, numero, "Mediocampista");
    }

    @Override
    public String getHabilidadEspecial() {
        return "Pases";
    }
}

class Delantero extends Jugador {
    public Delantero(String nombre, int numero) {
        super(nombre, numero, "Delantero");
    }

    @Override
    public String getHabilidadEspecial() {
        return "Goles";
    }
}

// Clase Equipo que contiene Jugadores (composición)
class Equipo {
    private String nombre;
    private List<Jugador> jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public List<Jugador> getJugadores() { return jugadores; }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void mostrarEquipo() {
        System.out.println("Equipo: " + nombre);
        System.out.println("Jugadores:");
        for (Jugador j : jugadores) {
            j.mostrarInfo();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // b) Crear un equipo y agregar jugadores
        Equipo barcelona = new Equipo("FC Barcelona");
        
        barcelona.agregarJugador(new Portero("Ter Stegen", 1));
        barcelona.agregarJugador(new Defensa("Araujo", 4));
        barcelona.agregarJugador(new Defensa("Piqué", 3));
        barcelona.agregarJugador(new Mediocampista("Pedri", 8));
        barcelona.agregarJugador(new Mediocampista("Gavi", 6));
        barcelona.agregarJugador(new Delantero("Lewandowski", 9));
        barcelona.agregarJugador(new Delantero("Dembélé", 7));

        // c) Mostrar información del equipo y sus jugadores
        barcelona.mostrarEquipo();
    }
}