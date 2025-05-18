from typing import List

# Clase Estudiante
class Estudiante:
    def __init__(self, nombre: str, carrera: str, semestre: int):
        self.nombre = nombre
        self.carrera = carrera
        self.semestre = semestre
    
    # Getters y setters (usando propiedades)
    @property
    def nombre(self):
        return self._nombre
    
    @nombre.setter
    def nombre(self, value):
        self._nombre = value
    
    @property
    def carrera(self):
        return self._carrera
    
    @carrera.setter
    def carrera(self, value):
        self._carrera = value
    
    @property
    def semestre(self):
        return self._semestre
    
    @semestre.setter
    def semestre(self, value):
        self._semestre = value
    
    def mostrar_info(self):
        print(f"Estudiante: {self.nombre}, Carrera: {self.carrera}, "
              f"Semestre: {self.semestre}")

# Clase Universidad (agregación con Estudiante)
class Universidad:
    def __init__(self, nombre: str):
        self.nombre = nombre
        self.estudiantes: List[Estudiante] = []
    
    # Getters y setters
    @property
    def nombre(self):
        return self._nombre
    
    @nombre.setter
    def nombre(self, value):
        self._nombre = value
    
    @property
    def estudiantes(self):
        return self._estudiantes
    
    @estudiantes.setter
    def estudiantes(self, value):
        self._estudiantes = value
    
    def agregar_estudiante(self, estudiante: Estudiante):
        self.estudiantes.append(estudiante)
    
    def mostrar_universidad(self):
        print(f"Universidad: {self.nombre}")
        print("Estudiantes:")
        for estudiante in self.estudiantes:
            estudiante.mostrar_info()

def main():
    # b) Crear estudiantes independientes
    est1 = Estudiante("Juan Pérez", "Ingeniería Informática", 4)
    est2 = Estudiante("María Gómez", "Medicina", 6)
    est3 = Estudiante("Carlos López", "Derecho", 2)
    
    # Crear universidad y agregar estudiantes
    umca = Universidad("UMCA")
    umca.agregar_estudiante(est1)
    umca.agregar_estudiante(est2)
    
    otra_uni = Universidad("Otra Universidad")
    otra_uni.agregar_estudiante(est3)
    otra_uni.agregar_estudiante(est2)  # Mismo estudiante en otra universidad

    # c) Mostrar información de las universidades
    print("=== Información UMCA ===")
    umca.mostrar_universidad()
    
    print("\n=== Información Otra Universidad ===")
    otra_uni.mostrar_universidad()
    
    # Demostrar que los estudiantes existen independientemente
    print("\n=== Información de estudiantes independientes ===")
    est1.mostrar_info()
    est2.mostrar_info()
    est3.mostrar_info()

if __name__ == "__main__":
    main()