# Clase Parte
class Parte:
    def __init__(self, nombre: str, peso: float):
        self.nombre = nombre
        self.peso = peso
    
    # Getters y setters (usando propiedades)
    @property
    def nombre(self):
        return self._nombre
    
    @nombre.setter
    def nombre(self, value):
        self._nombre = value
    
    @property
    def peso(self):
        return self._peso
    
    @peso.setter
    def peso(self, value):
        self._peso = value
    
    def mostrar_info(self):
        print(f"Parte: {self.nombre}, Peso: {self.peso} kg")

# Clase Avión que contiene Partes (composición)
class Avion:
    def __init__(self, modelo: str, fabricante: str):
        self.modelo = modelo
        self.fabricante = fabricante
        self.partes = []
    
    # Getters y setters
    @property
    def modelo(self):
        return self._modelo
    
    @modelo.setter
    def modelo(self, value):
        self._modelo = value
    
    @property
    def fabricante(self):
        return self._fabricante
    
    @fabricante.setter
    def fabricante(self, value):
        self._fabricante = value
    
    @property
    def partes(self):
        return self._partes
    
    @partes.setter
    def partes(self, value):
        self._partes = value
    
    def agregar_parte(self, parte: Parte):
        self.partes.append(parte)
    
    def mostrar_avion(self):
        print(f"Avión: {self.modelo} - Fabricante: {self.fabricante}")
        print("Partes del avión:")
        for parte in self.partes:
            parte.mostrar_info()

def main():
    # b) Crear un avión y agregar partes
    boeing747 = Avion("747", "Boeing")
    
    boeing747.agregar_parte(Parte("Motor izquierdo", 4500))
    boeing747.agregar_parte(Parte("Motor derecho", 4500))
    boeing747.agregar_parte(Parte("Ala izquierda", 12000))
    boeing747.agregar_parte(Parte("Ala derecha", 12000))
    boeing747.agregar_parte(Parte("Tren de aterrizaje delantero", 2500))
    boeing747.agregar_parte(Parte("Tren de aterrizaje principal", 3500))

    # c) Mostrar información del avión y sus partes
    boeing747.mostrar_avion()

if __name__ == "__main__":
    main()