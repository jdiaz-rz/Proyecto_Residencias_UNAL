package unal.residencias;

import unal.residencias.estructuras.ListaDinamica;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class MainPruebasLista {
    public static void main(String[] args) {
        int[] tamaños = {10_000, 100_000, 1_000_000};
        String archivoCSV = "analisis_lista.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(archivoCSV))) {
            writer.println("Tamaño(N),TiempoInsercionTotal_ms,TiempoAccesoTotal_ms");
            System.out.println("=== ANÁLISIS DE RENDIMIENTO: LISTA DINÁMICA ===");
            System.out.println("Exportando a: " + archivoCSV);

            for (int tamaño : tamaños) {
                System.out.println("\n--------------------------------------------------");
                System.out.println("Evaluando Lista Dinámica para N = " + tamaño + "...");
                ListaDinamica lista = new ListaDinamica();

                long startInsert = System.nanoTime();
                for (int i = 0; i < tamaño; i++) {
                    String id = UUID.randomUUID().toString().substring(0, 8);
                    lista.agregar(new Estudiante(id, "Estudiante_" + i, 500));
                }
                long endInsert = System.nanoTime();
                double tiempoInsertMs = (endInsert - startInsert) / 1_000_000.0;

                long startAccess = System.nanoTime();
                for (int i = 0; i < tamaño; i++) {
                    Estudiante e = lista.obtener(i);
                }
                long endAccess = System.nanoTime();
                double tiempoAccessMs = (endAccess - startAccess) / 1_000_000.0;

                writer.println(tamaño + "," + tiempoInsertMs + "," + tiempoAccessMs);
                System.out.println("Tiempo total Inserción Lista: " + tiempoInsertMs + " ms");
                System.out.println("Tiempo Acceso Secuencial ("+tamaño+"): " + tiempoAccessMs + " ms");
            }
            System.out.println("\nAnálisis de Lista finalizado.");
        } catch (IOException e) {
            System.out.println("Error al escribir CSV: " + e.getMessage());
        }
    }
}