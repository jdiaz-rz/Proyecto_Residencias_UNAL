package unal.residencias;

import unal.residencias.estructuras.ArbolAVL;
import java.util.ArrayList;
import java.util.List;

public class GestorResidencias {

  private ArbolAVL arbol;

    public GestorResidencias() {
        this.arbol = new ArbolAVL();
    }

  public void registrarEstudianteMasivo(Estudiante estudiante) {
        arbol.insertar(estudiante);
    }

    public List<Estudiante> simularAsignacion(int cupos) {
        List<Estudiante> asignados = new ArrayList<>();
        arbol.extraerMinimos(cupos, asignados);
        return asignados;
    }
}
