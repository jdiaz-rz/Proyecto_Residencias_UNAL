# Sistema de Asignación Prioritaria de Residencias Universitarias (SAPRU)

## Descripción del Proyecto
Este proyecto es una solución algorítmica desarrollada para la asignatura de Estructuras de Datos (2016699) de la Universidad Nacional de Colombia. El sistema busca optimizar la asignación de cupos en las residencias universitarias, priorizando a los estudiantes según su necesidad socioeconómica (a menor puntaje socioeconómico, mayor prioridad). 

Permite registrar solicitudes, ordenar dinámicamente a los estudiantes, reaccionar a modificaciones de puntaje socioeconómico y ejecutar la asignación justa de cupos garantizando eficiencia mediante el uso de estructuras de datos diseñadas desde cero.

## Integrantes del Equipo
* **Julián Andrés Díaz Rodríguez**
* **Amir Alejandro Narvaez Zuñiga**
* **Simón Alzate Luna**
* **Simón Matías Sánchez Calvo**
* **Nicolás Prada Sánchez**

## Lenguajes y Tecnologías
* **Lenguaje de Programación:** Java (JDK 17+)
* **IDE Recomendado:** NetBeans / IntelliJ IDEA
* **Control de Versiones:** Git y GitHub
* **Estructuras de Datos:** 
  * **Entrega 1 (Prototipo Inicial):** Árbol Binario de Búsqueda (BST) implementado manualmente.
  * **Entrega 2 (Evolución Planeada):** Árbol AVL con balanceo automático O(log n).
  * **Entrega 3 (Evolución Planeada):** Tabla Hash con acceso directo O(1) por ID y Min-Heap para extracción de prioridades.

## Estructura del Proyecto
El código fuente está organizado en los siguientes paquetes para separar la lógica del sistema de la implementación técnica y las pruebas de rendimiento:

```text
Residencias-UNAL/
├── .gitignore
├── README.md
├── analisis_avl.csv                      # Resultados exportados del rendimiento empírico (AVL)
├── analisis_lista.csv                    # Resultados exportados del rendimiento empírico (Lista Dinámica)
└── src/
    └── unal/
        └── residencias/
            ├── Estudiante.java               # Entidad modelo del estudiante
            ├── GestorResidencias.java        # Orquestador de la lógica de negocio (sin librerías nativas de colecciones)
            ├── Main.java                     # Punto de entrada interactivo básico
            ├── MainPruebasAVL.java           # Script de análisis de rendimiento empírico del Árbol AVL (10^4 a 10^6)
            ├── MainPruebasLista.java         # Script de análisis de rendimiento empírico de la Lista custom
            ├── estructuras/
            │   ├── ArbolAVL.java             # Árbol AVL implementado desde cero con auto-balanceo O(log n)
            │   ├── ListaDinamica.java        # Estructura customizada (reemplazo manual de java.util.ArrayList)
            │   └── NodoAVL.java              # Nodo con control de altura para el factor de balance
            └── utils/
                └── GeneradorDatos.java       # Generador de Mockup Data aleatoria para pruebas masivas
