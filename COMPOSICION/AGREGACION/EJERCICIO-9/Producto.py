from typing import List

# Clase Producto
class Producto:
    def __init__(self, nombre: str, precio: float):
        self.nombre = nombre
        self.precio = precio
    
    # Getters y setters (usando propiedades)
    @property
    def nombre(self):
        return self._nombre
    
    @nombre.setter
    def nombre(self, value):
        self._nombre = value
    
    @property
    def precio(self):
        return self._precio
    
    @precio.setter
    def precio(self, value):
        self._precio = value
    
    def mostrar_info(self):
        print(f"Producto: {self.nombre}, Precio: ${self.precio:.2f}")

# Clase CarritoCompras (agregación con Producto)
class CarritoCompras:
    MAX_PRODUCTOS = 10
    
    def __init__(self):
        self.productos: List[Producto] = []
    
    # Getters
    @property
    def productos(self):
        return self._productos
    
    @productos.setter
    def productos(self, value):
        self._productos = value
    
    def agregar_producto(self, producto: Producto):
        if len(self.productos) < self.MAX_PRODUCTOS:
            self.productos.append(producto)
            print(f"Producto '{producto.nombre}' agregado al carrito")
        else:
            print(f"¡No se puede agregar '{producto.nombre}'! El carrito está lleno (máximo {self.MAX_PRODUCTOS} productos)")
    
    def mostrar_carrito(self):
        if not self.productos:
            print("El carrito está vacío")
            return
        
        print("Contenido del carrito:")
        total = 0.0
        for producto in self.productos:
            producto.mostrar_info()
            total += producto.precio
        print(f"Total: ${total:.2f}")
        print(f"Productos en carrito: {len(self.productos)}/{self.MAX_PRODUCTOS}")

def main():
    # b) Crear productos independientes
    p1 = Producto("Laptop", 1200.00)
    p2 = Producto("Teléfono", 800.50)
    p3 = Producto("Tablet", 350.75)
    p4 = Producto("Auriculares", 150.25)
    p5 = Producto("Mouse", 25.99)
    p6 = Producto("Teclado", 45.50)
    p7 = Producto("Monitor", 300.00)
    p8 = Producto("Impresora", 200.00)
    p9 = Producto("Disco Duro", 120.00)
    p10 = Producto("Webcam", 75.00)
    p11 = Producto("Micrófono", 90.00)

    # Crear carrito y agregar productos
    carrito = CarritoCompras()
    
    # Agregar productos (algunos no cabrán)
    carrito.agregar_producto(p1)
    carrito.agregar_producto(p2)
    carrito.agregar_producto(p3)
    carrito.agregar_producto(p4)
    carrito.agregar_producto(p5)
    carrito.agregar_producto(p6)
    carrito.agregar_producto(p7)
    carrito.agregar_producto(p8)
    carrito.agregar_producto(p9)
    carrito.agregar_producto(p10)
    carrito.agregar_producto(p11)  # Este no debería agregarse

    # c) Mostrar información del carrito
    print("\n=== Estado del carrito ===")
    carrito.mostrar_carrito()

    # Demostrar que los productos existen independientemente
    print("\n=== Productos independientes ===")
    p11.mostrar_info()  # Producto que no entró en el carrito

if __name__ == "__main__":
    main()