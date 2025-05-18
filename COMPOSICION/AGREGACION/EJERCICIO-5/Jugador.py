from abc import ABC, abstractmethod
from typing import List

# Clase base abstracta Jugador
class Jugador(ABC):
    def __init__(self, nombre: str, numero: int, posicion: str):
        self.nombre = nombre
        self.numero = numero
        self.posicion = posicion
    
    # Getters y setters (usando propiedades)
    @property
    def nombre(self):
        return self._nombre
    
    @nombre.setter
    def nombre(self, value):
        self._nombre = value
    
    @property
    def numero(self):
        return self._numero
    
    @numero.setter
    def numero(self, value):
        self._numero = value
    
    @property
    def posicion(self):
        return self._posicion
    
    @posicion.setter
    def posicion(self, value):
        self._posicion = value
    
    @abstractmethod
    def habilidad_especial(self) -> str:
        pass
    
    def mostrar_info(self):
        print(f"Nombre: {self.nombre}, Número: {self.numero}, "
              f"Posición: {self.posicion}, "
              f"Habilidad especial: {self.habilidad_especial()}")

# Clases derivadas de Jugador
class Portero(Jugador):
    def __init__(self, nombre: str, numero: int):
        super().__init__(nombre, numero, "Portero")
    
    def habilidad_especial(self) -> str:
        return "Atajadas"

class Defensa(Jugador):
    def __init__(self, nombre: str, numero: int):
        super().__init__(nombre, numero, "Defensa")
    
    def habilidad_especial(self) -> str:
        return "Marcaje"

class Mediocampista(Jugador):
    def __init__(self, nombre: str, numero: int):
        super().__init__(nombre, numero, "Mediocampista")
    
    def habilidad_especial(self) -> str:
        return "Pases"

class Delantero(Jugador):
    def __init__(self, nombre: str, numero: int):
        super().__init__(nombre, numero, "Delantero")
    
    def habilidad_especial(self) -> str:
        return "Goles"

# Clase Equipo que contiene Jugadores (composición)
class Equipo:
    def __init__(self, nombre: str):
        self.nombre = nombre
        self.jugadores: List[Jugador] = []
    
    # Getters y setters
    @property
    def nombre(self):
        return self._nombre
    
    @nombre.setter
    def nombre(self, value):
        self._nombre = value
    
    @property
    def jugadores(self):
        return self._jugadores
    
    @jugadores.setter
    def jugadores(self, value):
        self._jugadores = value
    
    def agregar_jugador(self, jugador: Jugador):
        self.jugadores.append(jugador)
    
    def mostrar_equipo(self):
        print(f"Equipo: {self.nombre}")
        print("Jugadores:")
        for jugador in self.jugadores:
            jugador.mostrar_info()

def main():
    # b) Crear un equipo y agregar jugadores
    barcelona = Equipo("FC Barcelona")
    
    barcelona.agregar_jugador(Portero("Ter Stegen", 1))
    barcelona.agregar_jugador(Defensa("Araujo", 4))
    barcelona.agregar_jugador(Defensa("Piqué", 3))
    barcelona.agregar_jugador(Mediocampista("Pedri", 8))
    barcelona.agregar_jugador(Mediocampista("Gavi", 6))
    barcelona.agregar_jugador(Delantero("Lewandowski", 9))
    barcelona.agregar_jugador(Delantero("Dembélé", 7))

    # c) Mostrar información del equipo y sus jugadores
    barcelona.mostrar_equipo()

if __name__ == "__main__":
    main()