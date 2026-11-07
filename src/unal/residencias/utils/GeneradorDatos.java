package unal.residencias.utils;

import unal.residencias.Estudiante;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class GeneradorDatos {
  public static List<Estudiante> generarMockupData(int cantidad) {
        List<Estudiante> lista = new ArrayList<>(cantidad);
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            String id = UUID.randomUUID().toString().substring(0, 8); 
            String nombre = "Estudiante_" + i;
            int puntaje = random.nextInt(1000); 
            lista.add(new Estudiante(id, nombre, puntaje));
        }
        return lista;
    }
}
