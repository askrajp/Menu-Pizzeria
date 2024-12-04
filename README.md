
# Sistema de Gestión de Pedidos para Pizzería

Este proyecto es un sistema de gestión de pedidos para una pizzería. Permite a los usuarios gestionar los pedidos, incluyendo la selección de productos, la cantidad deseada y la creación de pedidos.

## Características

- **Gestión de Clientes:** Entrada para el nombre del cliente.
- **Categorías de Productos:** Selección de categorías de productos disponibles (Pizzas, Empanadas, Bebidas, etc.).
- **Selección de Productos:** Listado desplegable de productos filtrados por categoría.
- **Cantidad de Productos:** Selección de la cantidad de productos disponibles mediante un spinner.
- **Detalles del Pedido:** Visualización de los detalles del pedido con la información del producto, cantidad y precio.
- **Creación de Pedidos:** Funcionalidad para crear y almacenar nuevos pedidos.
- **Lista de Pedidos:** Visualización de todos los pedidos realizados.

## Requisitos

- Java 11 o superior
- JavaFX 11 o superior
- Gson 2.8.6 o superior

## Instalación

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/tu-usuario/nombre-del-repo.git
   cd nombre-del-repo
   ```

2. **Compilar y ejecutar:**
   ```bash
   ./gradlew run
   ```

## Estructura del Proyecto

- **`src/main/java/com/pizzeria/menupizzeria/logica/pedido`**: Contiene la lógica de la gestión de pedidos.
  - `PedidoController.java`: Controlador principal para gestionar la interfaz de usuario y la lógica de negocio.
  - `DetallePedido.java`: Clase que representa los detalles de un producto en el pedido.
  - `PedidoService.java`: Servicio que maneja la creación y almacenamiento de pedidos.
- **`src/main/resources`**: Contiene archivos de recursos como archivos FXML y JSON.
  - `pedido.fxml`: Archivo FXML para la interfaz de gestión de pedidos.
  - `productos.json`: Archivo JSON que contiene la lista de productos disponibles.
  - `pedidos.json`: Archivo JSON que contiene la lista de pedidos realizados.

## Uso

1. **Abrir el proyecto en tu IDE favorito (por ejemplo, IntelliJ, Eclipse).**
2. **Ejecutar la clase principal del proyecto.**
3. **Interfaz de usuario:**
   - Ingresar el nombre del cliente.
   - Seleccionar una categoría de productos.
   - Seleccionar un producto disponible.
   - Seleccionar la cantidad deseada y agregar el detalle al pedido.
   - Crear el pedido para almacenarlo.

## Contribuciones

¡Contribuciones son bienvenidas! Si deseas contribuir a este proyecto, por favor sigue estos pasos:

1. **Haz un fork del repositorio.**
2. **Crea una rama para tu feature o fix:**
   ```bash
   git checkout -b feature/nueva-feature
   ```
3. **Realiza los cambios necesarios y haz commit:**
   ```bash
   git commit -m "Añadir nueva feature"
   ```
4. **Envía los cambios a tu repositorio fork:**
   ```bash
   git push origin feature/nueva-feature
   ```
5. **Crea un Pull Request en GitHub.**

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Para más detalles, consulta el archivo [LICENSE](LICENSE).

---



