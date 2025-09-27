/*
 */
package Laboratorio.Practica8;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NavegacionUrbana {
    private String[] vertices;
    private long[][] matrizAdyacencia;
    private long[][] matrizDistancias;
    private int[][] matrizRutas;
    private Map<String, Integer> indiceVertices;
    private Scanner scanner = new Scanner(System.in);

    public NavegacionUrbana() {
        // Definir los lugares de la ciudad
        this.vertices = new String[] {
            "Casa", "Iglesia", "Farmacia", "Bolos", "Banco", 
            "Panaderia", "Supermercado", "Tienda de Ropa", "Lavanderia", 
            "Parque", "Fabrica", "Veterinaria", "Casino", "Pizzeria", 
            "Libreria", "Cine", "BarberShop", "Tienda De Plantas", "Hamburgueseria", 
            "Gasolinera", "Night Club", "Escuela", "Cantina"
        };
        
        // Inicializar mapa de índices
        this.indiceVertices = new HashMap<>();
        for (int i = 0; i < vertices.length; i++) {
            indiceVertices.put(vertices[i], i);
        }
        
        // Inicializar matriz de adyacencia con INFINITO
        int n = vertices.length;
        long INF = 1000000;
        this.matrizAdyacencia = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizAdyacencia[i][j] = (i == j) ? 0 : INF;
            }
        }
        
        // Establecer conexiones entre lugares
        agregarArista(0, 1, 2);   // Casa -> Iglesia
        agregarArista(0, 3, 7);    // Casa -> Bolos
        agregarArista(0, 16, 10); // Casa -> BarberShop
        agregarArista(0, 13, 3);  // Casa -> Pizzeria
        agregarArista(0, 14, 9);  // Casa -> Libreria
        
        agregarArista(1, 0, 2);   // Iglesia -> Casa
        agregarArista(1, 3, 3);    // Iglesia -> Bolos
        agregarArista(1, 2, 6);    // Iglesia -> Farmacia
        
        agregarArista(2, 3, 11);   // Farmacia -> Bolos
        agregarArista(2, 4, 3);    // Farmacia -> Banco
        agregarArista(2, 5, 12);   // Farmacia -> Panaderia
        
        agregarArista(3, 1, 3);    // Bolos -> Iglesia
        agregarArista(3, 16, 5);   // Bolos -> BarberShop
        agregarArista(3, 2, 11);   // Bolos -> Farmacia
        
        agregarArista(4, 16, 6);   // Banco -> BarberShop
        agregarArista(4, 5, 4);    // Banco -> Panaderia  

        agregarArista(5, 2, 12);   // Panaderia -> Farmacia
        agregarArista(5, 6, 6);    // Panaderia -> Supermercado
        agregarArista(5, 8, 3);    // Panaderia -> Lavanderia
        agregarArista(5, 9, 5);    // Panaderia -> Parque
        
        agregarArista(6, 5, 6);    // Supermercado -> Panaderia
        agregarArista(6, 8, 3);    // Supermercado -> Lavanderia
        agregarArista(6, 18, 2);   // Supermercado -> Hamburgueseria
       
        agregarArista(8, 6, 3);    // Lavanderia -> Supermercado
        
        agregarArista(9, 10, 5);   // Parque -> Fabrica
        agregarArista(9, 11, 4);   // Parque -> Veterinaria
        
        agregarArista(10, 11, 2);  // Fabrica -> Veterinaria
        agregarArista(10, 8, 11);  // Fabrica -> Lavanderia
        agregarArista(10, 12, 4);  // Fabrica -> Casino
        agregarArista(10, 20, 5);  // Fabrica -> Night Club
        
        agregarArista(11, 9, 4);   // Veterinaria -> Parque
        agregarArista(11, 12, 9);  // Veterinaria -> Casino
        
        agregarArista(12, 10, 4);  // Casino -> Fabrica
        agregarArista(12, 22, 5);  // Casino -> Cantina
       
        agregarArista(22, 12, 5);  // Cantina -> Casino
        agregarArista(22, 20, 9);  // Cantina -> Night Club
        agregarArista(22, 21, 3);  // Cantina -> Escuela
        
        agregarArista(20, 10, 5);  // Night Club -> Fabrica
        agregarArista(20, 22, 9);  // Night Club -> Cantina
        agregarArista(20, 21, 7);  // Night Club -> Escuela
       
        agregarArista(13, 16, 5);  // Pizzeria -> BarberShop
        agregarArista(13, 15, 2);  // Pizzeria -> Cine
        agregarArista(13, 14, 5);  // Pizzeria -> Libreria
        
        agregarArista(14, 13, 5);  // Libreria -> Pizzeria
        agregarArista(14, 15, 11); // Libreria -> Cine
        agregarArista(14, 17, 6);  // Libreria -> Tienda De Plantas
        
        agregarArista(15, 14, 2);  // Cine -> Pizzeria
        agregarArista(15, 16, 5);  // Cine -> BarberShop
        agregarArista(15, 17, 3);  // Cine -> Tienda De Plantas
        
        agregarArista(16, 0, 10);  // BarberShop -> Casa
        agregarArista(16, 15, 5);  // BarberShop -> Cine
        agregarArista(16, 17, 4);  // BarberShop -> Tienda De Plantas
        agregarArista(16, 18, 4);  // BarberShop -> Hamburgueseria
        
        agregarArista(17, 14, 6);  // Tienda De Plantas -> Libreria
        agregarArista(17, 16, 4);  // Tienda De Plantas -> Barbershop
        agregarArista(17, 18, 6);  // Tienda De Plantas -> Hamburgueseria
        agregarArista(17, 19, 4);  // Tienda De Plantas -> Gasolinera
        
        agregarArista(18, 19, 3);  // Hamburgueseria -> Gasolinera
        agregarArista(18, 4, 12);  // Hamburgueseria -> Banco
        agregarArista(18, 6, 2);   // Hamburgueseria -> Supermercado
        agregarArista(18, 20, 9);  // Hamburgueseria -> Night Club
        agregarArista(18, 21, 11); // Hamburgueseria -> Escuela
        
        agregarArista(19, 17, 4);  // Gasolinera -> Tienda De Plantas
        agregarArista(19, 21, 6);  // Gasolinera -> Escuela
        
        agregarArista(21, 18, 11); // Escuela -> Hamburgueseria
        
        // Calcular rutas óptimas iniciales
        calcularRutasOptimas();
    }

    private void agregarArista(int origen, int destino, long peso) {
        matrizAdyacencia[origen][destino] = peso;
    }

    private void calcularRutasOptimas() {
        int n = vertices.length;
        matrizDistancias = new long[n][n];
        matrizRutas = new int[n][n];

        // Inicialización
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizDistancias[i][j] = matrizAdyacencia[i][j];
                matrizRutas[i][j] = j;
            }
        }

        // Algoritmo de Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrizDistancias[i][k] + matrizDistancias[k][j] < matrizDistancias[i][j]) {
                        matrizDistancias[i][j] = matrizDistancias[i][k] + matrizDistancias[k][j];
                        matrizRutas[i][j] = matrizRutas[i][k];
                    }
                }
            }
        }
    }

    public void iniciarNavegacion() {
        System.out.println("=== Sistema de Navegacion Urbana ===");
        System.out.println("Lugares disponibles: \n" + String.join("\n", vertices) + "\n");
        
        String origen = solicitarVertice("Ingrese el punto de partida: ");
        String destino = solicitarVertice("Ingrese el punto de destino: ");
        
        String ubicacionActual = origen;
        String ubicacionAnterior = null;
        int pasos = 0;
        
        while (!ubicacionActual.equals(destino)) {
            pasos++;
            System.out.println("\n--- Paso " + pasos + " ---");
            System.out.println("Ubicacion actual: " + ubicacionActual);
            
            // Obtener información de navegación
            List<String> vecinos = obtenerVecinos(ubicacionActual, ubicacionAnterior);
            String sugerencia = obtenerSugerencia(ubicacionActual, destino, ubicacionAnterior);
            
            // Mostrar menú principal
            System.out.println("\nOpciones principales:");
            System.out.println("1. Seguir recomendacion: Ir a " + sugerencia);
            System.out.println("2. Elegir otro lugar vecino");
            System.out.println("3. Modificar calles (crear caos)");
            
            int opcion = solicitarOpcion(1, 3);
            
            switch (opcion) {
                case 1:
                    ubicacionAnterior = ubicacionActual;
                    ubicacionActual = sugerencia;
                    System.out.println("Avanzando a " + sugerencia + " segun recomendacion.");
                    break;
                    
                case 2:
                    if (vecinos.isEmpty()) {
                        System.out.println("No hay lugares vecinos disponibles.");
                        continue;
                    }
                    
                    System.out.println("\nLugares vecinos disponibles:");
                    for (int i = 0; i < vecinos.size(); i++) {
                        System.out.println((i+1) + ". " + vecinos.get(i));
                    }
                    
                    int eleccion = solicitarOpcion(1, vecinos.size());
                    ubicacionAnterior = ubicacionActual;
                    ubicacionActual = vecinos.get(eleccion-1);
                    System.out.println("Avanzando a " + ubicacionActual);
                    break;
                    
                case 3:
                    menuModificarCalles();
                    break;
            }
        }
        
        System.out.println("\n¡Felicidades! Ha llegado a su destino: " + destino);
        System.out.println("Total de pasos: " + pasos);
    }

    private void menuModificarCalles() {
        System.out.println("\n--- Modificacion de Calles ---");
        System.out.println("1. Cerrar calle (un sentido)");
        System.out.println("2. Cerrar calle (ambos sentidos)");
        System.out.println("3. Establecer marcha (duplicar peso)");
        System.out.println("4. Volver al menu principal");
        
        int opcion = solicitarOpcion(1, 5);
        
        if (opcion == 5) return;
        
        // Mostrar todas las calles existentes
        System.out.println("\nCalles disponibles:");
        List<String> calles = obtenerCallesExistentes();
        for (int i = 0; i < calles.size(); i++) {
            System.out.println((i+1) + ". " + calles.get(i));
        }
        
        System.out.print("Seleccione una calle (1-" + calles.size() + "): ");
        int seleccionCalle = solicitarOpcion(1, calles.size());
        String calleSeleccionada = calles.get(seleccionCalle-1);
        
        // Obtener los lugares de la calle seleccionada
        String[] partes = calleSeleccionada.split(" -> ");
        String origen = partes[0];
        String destino = partes[1];
        int idxOrigen = indiceVertices.get(origen);
        int idxDestino = indiceVertices.get(destino);
        
        switch (opcion) {
            case 1: // Cerrar un sentido
                matrizAdyacencia[idxOrigen][idxDestino] = 1000000;
                System.out.println("Calle " + calleSeleccionada + " cerrada en un sentido.");
                break;
                
            case 2: // Cerrar ambos sentidos
                matrizAdyacencia[idxOrigen][idxDestino] = 1000000;
                matrizAdyacencia[idxDestino][idxOrigen] = 1000000;
                System.out.println("Calle " + origen + " <-> " + destino + " cerrada en ambos sentidos.");
                break;
                
            case 3: // Establecer marcha (duplicar peso)
                if (matrizAdyacencia[idxOrigen][idxDestino] != 1000000) {
                    matrizAdyacencia[idxOrigen][idxDestino] *= 2;
                    System.out.println("Marcha establecida en " + calleSeleccionada + ". Peso duplicado: " + 
                                      matrizAdyacencia[idxOrigen][idxDestino]);
                } else {
                    System.out.println("No se puede establecer marcha en calle cerrada.");
                }
                break;
        }
        
        // Recalcular rutas después de modificar calles
        calcularRutasOptimas();
    }
    
    private List<String> obtenerVecinos(String actual, String anterior) {
        List<String> vecinos = new ArrayList<>();
        int actualIdx = indiceVertices.get(actual);
        
        for (int j = 0; j < vertices.length; j++) {
            if (matrizAdyacencia[actualIdx][j] != 1000000 && actualIdx != j) {
                // No agregar el lugar anterior a menos que sea la sugerencia
                if (anterior == null || !vertices[j].equals(anterior)) {
                    vecinos.add(vertices[j]);
                }
            }
        }
        
        return vecinos;
    }

    private String obtenerSugerencia(String actual, String destino, String anterior) {
        int actualIdx = indiceVertices.get(actual);
        int destinoIdx = indiceVertices.get(destino);
        
        if (actualIdx == destinoIdx) {
            return actual;
        }
        
        int siguienteIdx = matrizRutas[actualIdx][destinoIdx];
        return vertices[siguienteIdx];
    }

    private int solicitarOpcion(int min, int max) {
        while (true) {
            System.out.print("\nElija una opcion (" + min + ", " + max + "): ");
            try {
                int opcion = Integer.parseInt(scanner.nextLine());
                if (opcion >= min && opcion <= max) {
                    return opcion;
                }
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida");
            }
            System.out.println("Por favor ingrese un numero entre " + min + "y " + max);
        }
    }

    private List<String> obtenerCallesExistentes() {
        List<String> calles = new ArrayList<>();
        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices.length; j++) {
                if (i != j && matrizAdyacencia[i][j] != 1000000) {
                    calles.add(vertices[i] + " -> " + vertices[j]);
                }
            }
        }
        return calles;
    }

    private String solicitarVertice(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();
            // Buscar coincidencia parcial para hacer más fácil la entrada
            for (String lugar : vertices) {
                if (lugar.equalsIgnoreCase(input)) {
                    return lugar;
                }
            }
            System.out.println("Lugar no valido. Los lugares disponibles son: \n" + String.join("\n", vertices) + "\n");
        }
    }

    public static void main(String[] args) {
        NavegacionUrbana navegador = new NavegacionUrbana();
        navegador.iniciarNavegacion();
    }
}