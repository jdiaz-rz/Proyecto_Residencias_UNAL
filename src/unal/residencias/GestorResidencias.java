package unal.residencias;

import unal.residencias.estructuras.ArbolAVL;
import unal.residencias.estructuras.ListaDinamica;

public class GestorResidencias {

    private ArbolAVL arbol;

    public GestorResidencias() { this.arbol = new ArbolAVL(); }

  public void registrarEstudianteMasivo(Estudiante estudiante) {
        arbol.insertar(estudiante);
    }

    public ListaDinamica simularAsignacion(int cupos) {
        ListaDinamica asignados = new ListaDinamica();
        arbol.extraerMinimos(cupos, asignados);
        return asignados;
    }
}
