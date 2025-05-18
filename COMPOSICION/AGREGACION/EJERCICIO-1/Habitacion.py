# Clase Habitación
class Habitacion:
    def __init__(self, nombre: str, tamaño: float):
        self.nombre = nombre
        self.tamaño = tamaño
    
    # Getters y setters (usando propiedades)
    @property
    def nombre(self):
        return self._nombre
    
    @nombre.setter
    def nombre(self, value):
        self._nombre = value
    
    @property
    def tamaño(self):
        return self._tamaño
    
    @tamaño.setter
    def tamaño(self, value):
        self._tamaño = value
    
    def mostrar_info(self):
        print(f"Habitación: {self.nombre}, Tamaño: {self.tamaño} m²")

# Clase Casa que contiene Habitaciones (composición)
class Casa:
    def __init__(self, direccion: str):
        self.direccion = direccion
        self.habitaciones = []
    
    # Getters y setters
    @property
    def direccion(self):
        return self._direccion
    
    @direccion.setter
    def direccion(self, value):
        self._direccion = value
    
    @property
    def habitaciones(self):
        return self._habitaciones
    
    @habitaciones.setter
    def habitaciones(self, value):
        self._habitaciones = value
    
    def agregar_habitacion(self, habitacion: Habitacion):
        self.habitaciones.append(habitacion)
    
    def mostrar_casa(self):
        print(f"Casa en: {self.direccion}")
        print("Habitaciones:")
        for habitacion in self.habitaciones:
            habitacion.mostrar_info()

def main():
    # b) Crear una casa y agregar habitaciones
    mi_casa = Casa("Calle Principal 123")
    
    mi_casa.agregar_habitacion(Habitacion("Sala", 20.5))
    mi_casa.agregar_habitacion(Habitacion("Cocina", 15.0))
    mi_casa.agregar_habitacion(Habitacion("Dormitorio Principal", 25.0))
    mi_casa.agregar_habitacion(Habitacion("Baño", 8.5))

    # c) Mostrar información de la casa y sus habitaciones
    mi_casa.mostrar_casa()

if __name__ == "__main__":
    main()