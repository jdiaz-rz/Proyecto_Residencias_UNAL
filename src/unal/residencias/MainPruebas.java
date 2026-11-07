package unal.residencias;

import unal.residencias.utils.GeneradorDatos;
import java.util.List;

public class MainPruebas {
    public static void main(String[] args) {
        System.out.println("=== ANÁLISIS DE RENDIMIENTO: ÁRBOL AVL ===");
        int[] tamaños = {10_000, 100_000, 1_000_000};
        
        for (int tamaño : tamaños) {
            System.out.println("\n--------------------------------------------------");
            System.out.println("Preparando entorno para N = " + tamaño + " estudiantes...");
            List<Estudiante> mockupData = GeneradorDatos.generarMockupData(tamaño);
            GestorResidencias gestor = new GestorResidencias();

            long startInsert = System.nanoTime();
            for (Estudiante e : mockupData) {
                gestor.registrarEstudianteMasivo(e);
            }    
            long endInsert = System.nanoTime();
            double tiempoInsertMs = (endInsert - startInsert) / 1_000_000.0;
            System.out.println("Tiempo total Inserción AVL: " + tiempoInsertMs + " ms");
        }
    }
}