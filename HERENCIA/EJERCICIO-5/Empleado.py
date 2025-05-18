# Clase base Empleado
class Empleado:
    def __init__(self, nombre: str, apellido: str, salario_base: float, años_antigüedad: int):
        self.nombre = nombre
        self.apellido = apellido
        self.salario_base = salario_base
        self.años_antigüedad = años_antigüedad
    
    # Getters y setters (usando propiedades en Python)
    @property
    def nombre(self):
        return self._nombre
    
    @nombre.setter
    def nombre(self, value):
        self._nombre = value
    
    @property
    def apellido(self):
        return self._apellido
    
    @apellido.setter
    def apellido(self, value):
        self._apellido = value
    
    @property
    def salario_base(self):
        return self._salario_base
    
    @salario_base.setter
    def salario_base(self, value):
        self._salario_base = value
    
    @property
    def años_antigüedad(self):
        return self._años_antigüedad
    
    @años_antigüedad.setter
    def años_antigüedad(self, value):
        self._años_antigüedad = value
    
    def calcular_salario(self) -> float:
        return self.salario_base + (self.salario_base * 0.05 * self.años_antigüedad)
    
    def __str__(self):
        return f"{self.nombre} {self.apellido} - Salario base: {self.salario_base} - Años antigüedad: {self.años_antigüedad}"

# Clase Gerente que hereda de Empleado
class Gerente(Empleado):
    def __init__(self, nombre: str, apellido: str, salario_base: float, 
                 años_antigüedad: int, departamento: str, bono_gerencial: float):
        super().__init__(nombre, apellido, salario_base, años_antigüedad)
        self.departamento = departamento
        self.bono_gerencial = bono_gerencial
    
    # Getters y setters
    @property
    def departamento(self):
        return self._departamento
    
    @departamento.setter
    def departamento(self, value):
        self._departamento = value
    
    @property
    def bono_gerencial(self):
        return self._bono_gerencial
    
    @bono_gerencial.setter
    def bono_gerencial(self, value):
        self._bono_gerencial = value
    
    def calcular_salario(self) -> float:
        return super().calcular_salario() + self.bono_gerencial
    
    def __str__(self):
        return f"{super().__str__()} - Departamento: {self.departamento} - Bono gerencial: {self.bono_gerencial}"

# Clase Desarrollador que hereda de Empleado
class Desarrollador(Empleado):
    def __init__(self, nombre: str, apellido: str, salario_base: float, 
                 años_antigüedad: int, lenguaje_programacion: str, horas_extras: int):
        super().__init__(nombre, apellido, salario_base, años_antigüedad)
        self.lenguaje_programacion = lenguaje_programacion
        self.horas_extras = horas_extras
    
    # Getters y setters
    @property
    def lenguaje_programacion(self):
        return self._lenguaje_programacion
    
    @lenguaje_programacion.setter
    def lenguaje_programacion(self, value):
        self._lenguaje_programacion = value
    
    @property
    def horas_extras(self):
        return self._horas_extras
    
    @horas_extras.setter
    def horas_extras(self, value):
        self._horas_extras = value
    
    def calcular_salario(self) -> float:
        # Suponemos que cada hora extra vale el 1% del salario base
        return super().calcular_salario() + (self.salario_base * 0.01 * self.horas_extras)
    
    def __str__(self):
        return f"{super().__str__()} - Lenguaje: {self.lenguaje_programacion} - Horas extras: {self.horas_extras}"

def main():
    # b) Crear instancias de Gerente y Desarrollador
    gerente1 = Gerente("Carlos", "Gómez", 5000, 5, "TI", 1500)
    gerente2 = Gerente("Ana", "Pérez", 4500, 3, "RRHH", 800)
    
    dev1 = Desarrollador("Luis", "Martínez", 3000, 2, "Java", 15)
    dev2 = Desarrollador("María", "Rodríguez", 3500, 4, "Python", 8)

    # Mostrar salarios calculados
    print("=== Salarios calculados ===")
    print(f"{gerente1} - Salario total: {gerente1.calcular_salario()}")
    print(f"{gerente2} - Salario total: {gerente2.calcular_salario()}")
    print(f"{dev1} - Salario total: {dev1.calcular_salario()}")
    print(f"{dev2} - Salario total: {dev2.calcular_salario()}")

    # c) Mostrar gerentes con bono gerencial > 1000
    print("\n=== Gerentes con bono > 1000 ===")
    gerentes = [gerente1, gerente2]
    for g in gerentes:
        if g.bono_gerencial > 1000:
            print(f"{g} - Bono: {g.bono_gerencial}")

    # d) Mostrar desarrolladores con más de 10 horas extras
    print("\n=== Desarrolladores con más de 10 horas extras ===")
    desarrolladores = [dev1, dev2]
    for d in desarrolladores:
        if d.horas_extras > 10:
            print(f"{d} - Horas extras: {d.horas_extras}")

if __name__ == "__main__":
    main()