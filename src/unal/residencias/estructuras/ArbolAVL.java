package unal.residencias.estructuras;

import unal.residencias.Estudiante;
import java.util.List;

public class ArbolAVL {
  private NodoAVL raiz;

    private int altura(NodoAVL n) {
        return n == null ? 0 : n.altura;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private int getBalance(NodoAVL n) {
        return n == null ? 0 : altura(n.izquierdo) - altura(n.derecho);
    }
}
