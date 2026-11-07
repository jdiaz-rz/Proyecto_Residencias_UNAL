package unal.residencias.estructuras;

import unal.residencias.Estudiante;

public class NodoAVL {
    public Estudiante estudiante;
    public NodoAVL izquierdo;
    public NodoAVL derecho;
    public int altura;

    public NodoAVL(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.altura = 1;
    }
}
