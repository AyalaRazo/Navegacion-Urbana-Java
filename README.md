# 🏙️ Urban Navigation Simulation - Simulación de Navegación Urbana - Java

---

## English

This project implements an **urban navigation simulation** in **Java**, where the user can move between different city locations and receive **optimal routes**.  
The system allows **modifying streets** (closing them or doubling their weights) and automatically recalculates the routes using the **Floyd-Warshall algorithm**.

### ✨ Main Features

- **Navigate the city**  
  - Select a **starting point** and a **destination**.  
  - Receive **optimal route suggestions** at each step.

- **Navigation options**  
  - Follow the automatic recommendation.  
  - Choose another neighboring location manually.  
  - Modify streets to simulate closures or traffic changes.

- **Modify streets**  
  - Close streets in **one direction** or **both directions**.  
  - Set "traffic" by doubling the street's weight.  
  - Routes are recalculated automatically after any modification.

- **City information**  
  - 23 different locations: House, Church, Pharmacy, Bowling, Bank, Bakery, Supermarket, Clothing Store, Laundry, Park, Factory, Veterinary, Casino, Pizzeria, Library, Cinema, BarberShop, Plant Store, Burger Place, Gas Station, Night Club, School, Cantina.  
  - Connections between locations with weights representing distance or travel time.

### 🧑‍💻 Technologies and Data Structures

- **Java** for implementation.  
- **Data structures**:
  - `ArrayList` → for dynamic lists of neighbors and streets.  
  - `HashMap` → to map location names to indices in the adjacency matrix.  
  - `long[][]` → **adjacency and distance matrices** representing the graph.  
  - `int[][]` → **route matrix** to reconstruct optimal paths.  
- **Optimal route algorithm**:
  - **Floyd-Warshall** → calculates all shortest paths between each pair of city locations.

- **User input** using `Scanner` to select destinations and navigation options.

### ▶️ How to Run

Compile and execute:

```bash
javac NavegacionUrbana.java
java NavegacionUrbana
```

<a href="#"><img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif"></a>

## Español

Este proyecto implementa una **simulación de navegación urbana** en **Java**, donde el usuario puede moverse entre distintos puntos de una ciudad y recibir **rutas óptimas**.  
El sistema permite **modificar calles** (cerrarlas o duplicar su peso) y recalcula automáticamente las rutas usando **Floyd-Warshall**.

### ✨ Funcionalidades principales

- **Moverse por la ciudad**  
  - Seleccionar un **punto de partida** y un **destino**.  
  - Recibir **sugerencias de ruta óptima** en cada paso.

- **Opciones de navegación**  
  - Seguir la recomendación automática.  
  - Elegir otro lugar vecino manualmente.  
  - Modificar calles para simular cambios en el tráfico o cierres.

- **Modificar calles**  
  - Cerrar calle en **un sentido** o en **ambos sentidos**.  
  - Establecer “marcha” duplicando el peso de la calle (simula tráfico o dificultad).  
  - Las rutas se recalculan automáticamente después de cualquier cambio.

- **Información de la ciudad**  
  - 23 lugares distintos: Casa, Iglesia, Farmacia, Bolos, Banco, Panadería, Supermercado, Tienda de Ropa, Lavandería, Parque, Fábrica, Veterinaria, Casino, Pizzería, Librería, Cine, BarberShop, Tienda De Plantas, Hamburguesería, Gasolinera, Night Club, Escuela, Cantina.  
  - Conexiones entre los lugares con pesos que representan la distancia o el tiempo de desplazamiento.

### 🧑‍💻 Tecnologías y estructuras usadas

- **Java** para la implementación.  
- **Estructuras de datos**:
  - `ArrayList` → para manejar listas dinámicas de vecinos y calles.  
  - `HashMap` → para mapear nombres de lugares a índices en la matriz.  
  - `long[][]` → **matriz de adyacencia** y **matriz de distancias** para representar el grafo.  
  - `int[][]` → **matriz de rutas** para reconstruir caminos óptimos.  
- **Algoritmo de rutas óptimas**:
  - **Floyd-Warshall** → calcula todas las rutas más cortas entre cada par de lugares en la ciudad.

- **Entrada de usuario** mediante `Scanner` para seleccionar destinos y opciones de navegación.

### ▶️ Cómo ejecutar

Compilar y ejecutar:

```bash
javac NavegacionUrbana.java
java NavegacionUrbana
```
## Images

<div align=center >
  <img width="862" height="768" alt="image" src="https://github.com/user-attachments/assets/0c11b600-d3da-4a97-9e70-8e1129aa1399" />

  #

  <img width="717" height="714" alt="image" src="https://github.com/user-attachments/assets/e5f6d594-7b4a-410d-a744-c6c07791802c" />

  #

  <img width="675" height="803" alt="image" src="https://github.com/user-attachments/assets/4ee832f0-f065-4af6-9bcc-668091489737" />

  #

  <img width="720" height="735" alt="image" src="https://github.com/user-attachments/assets/20f0ff56-a379-4186-913e-2bfa4effe62e" />

</div>

