from datetime import date, datetime
from typing import List

# Clase base Persona
class Persona:
    def __init__(self, ci: str = "0000000", nombre: str = "Sin nombre", 
                 apellido: str = "Sin apellido", celular: str = "00000000", 
                 fecha_na: date = date.today(), sexo: str = "No especificado"):
        self.ci = ci
        self.nombre = nombre
        self.apellido = apellido
        self.celular = celular
        self.fecha_na = fecha_na
        self.sexo = sexo
    
    def calcular_edad(self) -> int:
        hoy = date.today()
        return hoy.year - self.fecha_na.year - ((hoy.month, hoy.day) < (self.fecha_na.month, self.fecha_na.day))
    
    def mostrar(self):
        print(f"CI: {self.ci}, Nombre: {self.nombre} {self.apellido}, "
              f"Celular: {self.celular}, Fecha Nacimiento: {self.fecha_na}, "
              f"Sexo: {self.sexo}, Edad: {self.calcular_edad()}")

# Clase Estudiante que hereda de Persona
class Estudiante(Persona):
    def __init__(self, ci: str = "0000000", nombre: str = "Sin nombre", 
                 apellido: str = "Sin apellido", celular: str = "00000000", 
                 fecha_na: date = date.today(), sexo: str = "No especificado",
                 ru: str = "000000", fecha_ingreso: date = date.today(), 
                 semestre: int = 1):
        super().__init__(ci, nombre, apellido, celular, fecha_na, sexo)
        self.ru = ru
        self.fecha_ingreso = fecha_ingreso
        self.semestre = semestre
    
    def mostrar(self):
        super().mostrar()
        print(f"RU: {self.ru}, Fecha Ingreso: {self.fecha_ingreso}, "
              f"Semestre: {self.semestre}")

# Clase Docente que hereda de Persona
class Docente(Persona):
    def __init__(self, ci: str = "0000000", nombre: str = "Sin nombre", 
                 apellido: str = "Sin apellido", celular: str = "00000000", 
                 fecha_na: date = date.today(), sexo: str = "No especificado",
                 nit: str = "0000000", profesion: str = "Sin profesión", 
                 especialidad: str = "Sin especialidad"):
        super().__init__(ci, nombre, apellido, celular, fecha_na, sexo)
        self.nit = nit
        self.profesion = profesion
        self.especialidad = especialidad
    
    def mostrar(self):
        super().mostrar()
        print(f"NIT: {self.nit}, Profesión: {self.profesion}, "
              f"Especialidad: {self.especialidad}")

def main():
    # Crear lista de estudiantes
    estudiantes: List[Estudiante] = [
        Estudiante("1234567", "Juan", "Perez", "77712345", 
                  date(1995, 5, 15), "M", "123456", date(2020, 3, 1), 5),
        Estudiante("7654321", "Maria", "Gomez", "77754321", 
                  date(2000, 8, 20), "F", "654321", date(2021, 8, 15), 3),
        Estudiante("9876543", "Carlos", "Perez", "77798765", 
                  date(1998, 11, 30), "M", "987654", date(2019, 1, 10), 7)
    ]

    # Crear lista de docentes
    docentes: List[Docente] = [
        Docente("1122334", "Pedro", "Lopez", "77711223", 
               date(1980, 2, 10), "M", "4455667", "Ingeniero", "Sistemas"),
        Docente("4433221", "Ana", "Gomez", "77744332", 
               date(1975, 7, 25), "F", "7788990", "Licenciada", "Educación"),
        Docente("5566778", "Luis", "Perez", "77755667", 
               date(1970, 9, 5), "M", "9900112", "Ingeniero", "Electrónica")
    ]

    # b) Mostrar todos los estudiantes y docentes
    print("=== Todos los estudiantes ===")
    for e in estudiantes:
        e.mostrar()
        print("----------------")

    print("\n=== Todos los docentes ===")
    for d in docentes:
        d.mostrar()
        print("----------------")

    # c) Mostrar estudiantes mayores de 25 años
    print("\n=== Estudiantes mayores de 25 años ===")
    for e in estudiantes:
        if e.calcular_edad() > 25:
            e.mostrar()
            print("----------------")

    # d) Mostrar docente ingeniero, masculino y mayor
    print("\n=== Docente ingeniero, masculino y mayor ===")
    mayor_ingeniero = None
    for d in docentes:
        if d.profesion.lower() == "ingeniero" and d.sexo == "M":
            if mayor_ingeniero is None or d.fecha_na < mayor_ingeniero.fecha_na:
                mayor_ingeniero = d
    if mayor_ingeniero:
        mayor_ingeniero.mostrar()
    else:
        print("No se encontró docente que cumpla los criterios")

    # e) Mostrar estudiantes y docentes con mismo apellido
    print("\n=== Personas con mismo apellido ===")
    for e in estudiantes:
        for d in docentes:
            if e.apellido.lower() == d.apellido.lower():
                print(f"Estudiante y Docente con apellido {e.apellido}:")
                e.mostrar()
                d.mostrar()
                print("----------------")

if __name__ == "__main__":
    main()