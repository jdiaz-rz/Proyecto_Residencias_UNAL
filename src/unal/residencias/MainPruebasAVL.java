package unal.residencias;

import unal.residencias.estructuras.ListaDinamica;
import unal.residencias.utils.GeneradorDatos;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainPruebasAVL {
    public static void main(String[] args) {
        int[] tamaños = {10_000, 100_000, 1_000_000};
        String archivoCSV = "analisis_avl.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(archivoCSV))) {
            writer.println("Tamaño(N),TiempoInsercionTotal_ms,TiempoExtraccion_ms");
            System.out.println("=== ANÁLISIS DE RENDIMIENTO: ÁRBOL AVL ===");
            System.out.println("Exportando a: " + archivoCSV);

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

                int cuposASimular = tamaño / 10;
                long startExtract = System.nanoTime();
                gestor.simularAsignacion(cuposASimular);
                long endExtract = System.nanoTime();
                double tiempoExtractMs = (endExtract - startExtract) / 1_000_000.0;

                writer.println(tamaño + "," + tiempoInsertMs + "," + tiempoExtractMs);
                System.out.println("Tiempo total Inserción AVL: " + tiempoInsertMs + " ms");
                System.out.println("Tiempo Extracción de " + cuposASimular + " cupos: " + tiempoExtractMs + " ms");
            }
            System.out.println("\nAnálisis AVL finalizado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }
}
