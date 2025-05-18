# Clase base Vehículo
class Vehiculo:
    def __init__(self, marca, modelo, año, precio_base):
        self.marca = marca
        self.modelo = modelo
        self.año = año
        self.precio_base = precio_base
    
    # Getters y setters (usando propiedades en Python)
    @property
    def marca(self):
        return self._marca
    
    @marca.setter
    def marca(self, value):
        self._marca = value
    
    @property
    def modelo(self):
        return self._modelo
    
    @modelo.setter
    def modelo(self, value):
        self._modelo = value
    
    @property
    def año(self):
        return self._año
    
    @año.setter
    def año(self, value):
        self._año = value
    
    @property
    def precio_base(self):
        return self._precio_base
    
    @precio_base.setter
    def precio_base(self, value):
        self._precio_base = value
    
    def mostrar_info(self):
        print(f"Marca: {self.marca}, Modelo: {self.modelo}, Año: {self.año}, Precio Base: {self.precio_base}")

# Clase Coche que hereda de Vehículo
class Coche(Vehiculo):
    def __init__(self, marca, modelo, año, precio_base, num_puertas, tipo_combustible):
        super().__init__(marca, modelo, año, precio_base)
        self.num_puertas = num_puertas
        self.tipo_combustible = tipo_combustible
    
    # Getters y setters
    @property
    def num_puertas(self):
        return self._num_puertas
    
    @num_puertas.setter
    def num_puertas(self, value):
        self._num_puertas = value
    
    @property
    def tipo_combustible(self):
        return self._tipo_combustible
    
    @tipo_combustible.setter
    def tipo_combustible(self, value):
        self._tipo_combustible = value
    
    def mostrar_info(self):
        super().mostrar_info()
        print(f"Número de puertas: {self.num_puertas}, Tipo de combustible: {self.tipo_combustible}")

# Clase Moto que hereda de Vehículo
class Moto(Vehiculo):
    def __init__(self, marca, modelo, año, precio_base, cilindrada, tipo_motor):
        super().__init__(marca, modelo, año, precio_base)
        self.cilindrada = cilindrada
        self.tipo_motor = tipo_motor
    
    # Getters y setters
    @property
    def cilindrada(self):
        return self._cilindrada
    
    @cilindrada.setter
    def cilindrada(self, value):
        self._cilindrada = value
    
    @property
    def tipo_motor(self):
        return self._tipo_motor
    
    @tipo_motor.setter
    def tipo_motor(self, value):
        self._tipo_motor = value
    
    def mostrar_info(self):
        super().mostrar_info()
        print(f"Cilindrada: {self.cilindrada}, Tipo de motor: {self.tipo_motor}")

# b) Crear instancias de Coche y Moto
coche1 = Coche("Toyota", "Corolla", 2020, 25000, 4, "Gasolina")
coche2 = Coche("Ford", "Mustang", 2021, 45000, 2, "Gasolina")
coche3 = Coche("Tesla", "Model S", 2022, 80000, 5, "Eléctrico")

moto1 = Moto("Honda", "CBR600", 2019, 12000, 600, "4T")
moto2 = Moto("Yamaha", "MT-07", 2020, 8000, 700, "2T")

# Mostrar información de los vehículos
print("=== Información de vehículos ===")
coche1.mostrar_info()
print("----------------")
moto1.mostrar_info()
print("----------------")

# c) Mostrar coches con más de 4 puertas
print("\n=== Coches con más de 4 puertas ===")
coches = [coche1, coche2, coche3]
for coche in coches:
    if coche.num_puertas > 4:
        coche.mostrar_info()
        print("----------------")

# d) Mostrar vehículos actuales (año 2025)
print("\n=== Vehículos actuales (2025) ===")
vehiculos = [coche1, coche2, coche3, moto1, moto2]
for vehiculo in vehiculos:
    if vehiculo.año >= 2025:
        vehiculo.mostrar_info()
        print("----------------")