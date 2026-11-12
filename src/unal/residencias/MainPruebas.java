package unal.residencias;

import unal.residencias.utils.GeneradorDatos;
import unal.residencias.estructuras.ListaDinamica;

public class MainPruebas {
    public static void main(String[] args) {
        System.out.println("=== ANÁLISIS DE RENDIMIENTO: ÁRBOL AVL ===");
        int[] tamaños = {10_000, 100_000, 1_000_000};
        
        for (int tamaño : tamaños) {
            System.out.println("\n--------------------------------------------------");
            System.out.println("Preparando entorno para N = " + tamaño + " estudiantes...");
            ListaDinamica mockupData = GeneradorDatos.generarMockupData(tamaño);
            GestorResidencias gestor = new GestorResidencias();

            long startInsert = System.nanoTime();
            for (int i = 0; i < mockupData.tamaño(); i++) {
                gestor.registrarEstudianteMasivo(mockupData.obtener(i));
            }
            long endInsert = System.nanoTime();
            double tiempoInsertMs = (endInsert - startInsert) / 1_000_000.0;
            System.out.println("Tiempo total Inserción AVL: " + tiempoInsertMs + " ms");

            int cuposSimulados = 500; 
            long startAsignacion = System.nanoTime();
            gestor.simularAsignacion(cuposSimulados);
            long endAsignacion = System.nanoTime();
            double tiempoAsignMs = (endAsignacion - startAsignacion) / 1_000_000.0;
            System.out.println("Tiempo Extracción de " + cuposSimulados + " cupos: " + tiempoAsignMs + " ms");
        }
    }
}