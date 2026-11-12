package unal.residencias.utils;

import unal.residencias.Estudiante;
import unal.residencias.estructuras.ListaDinamica;
import java.util.Random;
import java.util.UUID;

public class GeneradorDatos {
    public static ListaDinamica generarMockupData(int cantidad) {
        ListaDinamica lista = new ListaDinamica();
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            String id = UUID.randomUUID().toString().substring(0, 8);
            String nombre = "Estudiante_" + i;
            lista.agregar(new Estudiante(id, nombre, random.nextInt(1000)));
        }
        return lista;
    }
}
