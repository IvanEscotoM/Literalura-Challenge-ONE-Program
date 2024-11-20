# JPALibros

**JPALibros** es una aplicación Java que permite interactuar con la API de Gutendex para buscar libros, registrar datos en una base de datos PostgreSQL y realizar consultas a través de una interfaz intuitiva.
Fue creada como parte de los retos propuestos en la formacion de Back-End del programa Oracle Next Education.

## 🚀 Funcionalidades

- **Buscar libros**: Busca libros por título usando la API de Gutendex.
- **Listar libros**: Muestra los libros registrados en la base de datos.
- **Consultar autores**: Consulta información sobre autores registrados, incluyendo rangos de vida.
- **Filtrar libros por idioma**: Busca libros registrados según su idioma.
- **Almacenamiento**: Registra libros en una base de datos PostgreSQL utilizando JPA.

---

## 🗂️ Estructura del Proyecto

### **Package Main**
- **`MenuMain.java`**:  
  Contiene el menú principal que permite al usuario interactuar con las funcionalidades del programa.  
  Ofrece opciones para buscar libros, listar datos almacenados y realizar búsquedas avanzadas.

### **Package Model**
Clases para modelar y manejar los datos de los libros y autores:
- **`Datos`**: Representa la estructura de los datos obtenidos de la API Gutendex.
- **`DatosAutor`**: Contiene información de los autores, como nombre, año de nacimiento y año de fallecimiento.
- **`Libro`**: Modelo para los libros almacenados en la base de datos.
- **`LibroR`**: Clase `record` utilizada para convertir los datos JSON de la API en objetos manejables.

### **Package Repositorio**
- **`LibroRepositorio`**:  
  Interfaz JPA que define métodos para realizar consultas en PostgreSQL, como búsqueda de libros y autores.

### **Package Service**
Servicios para la integración y manejo de datos:
- **`ApiService`**:  
  Gestiona la conexión con la API de Gutendex para obtener información de libros en formato JSON.
- **`ConversorData`**:  
  Convierte los datos JSON obtenidos de la API en objetos Java utilizando Jackson `ObjectMapper`.
- **`IConversorDatos`**:  
  Interfaz para estandarizar la conversión de datos JSON.

---

## 🛠️ Tecnologías Usadas

- **Java**: Lenguaje de programación principal.
- **Spring Data JPA**: Para la persistencia y consultas a la base de datos.
- **PostgreSQL**: Base de datos utilizada.
- **Gutendex API**: Fuente de datos para información de libros.
- **Jackson**: Para la conversión de JSON a objetos Java.

---

## 💻 Instalación y Uso

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/usuario/JPALibros.git
   cd JPALibros
2. Configura la base de datos:

Crea una base de datos en PostgreSQL.
Configura las credenciales en el archivo application.properties de la aplicacion.
