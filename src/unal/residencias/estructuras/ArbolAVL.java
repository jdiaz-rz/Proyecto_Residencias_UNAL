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

  private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierdo;
        NodoAVL T2 = x.derecho;
        x.derecho = y;
        y.izquierdo = T2;
        y.altura = max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = max(altura(x.izquierdo), altura(x.derecho)) + 1;
        return x;
    }

  private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecho;
        NodoAVL T2 = y.izquierdo;
        y.izquierdo = x;
        x.derecho = T2;
        x.altura = max(altura(x.izquierdo), altura(x.derecho)) + 1;
        y.altura = max(altura(y.izquierdo), altura(y.derecho)) + 1;
        return y;
    }

    public void insertar(Estudiante estudiante) {
        raiz = insertarRecursivo(raiz, estudiante);
    }

    private NodoAVL insertarRecursivo(NodoAVL nodo, Estudiante estudiante) {
        if (nodo == null) return new NodoAVL(estudiante);

        if (estudiante.getPuntajeSocioeconomico() < nodo.estudiante.getPuntajeSocioeconomico()) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, estudiante);
        } else if (estudiante.getPuntajeSocioeconomico() > nodo.estudiante.getPuntajeSocioeconomico()) {
            nodo.derecho = insertarRecursivo(nodo.derecho, estudiante);
        } else {
            if (estudiante.getId().compareTo(nodo.estudiante.getId()) < 0) {
                nodo.izquierdo = insertarRecursivo(nodo.izquierdo, estudiante);
            } else if (estudiante.getId().compareTo(nodo.estudiante.getId()) > 0) {
                nodo.derecho = insertarRecursivo(nodo.derecho, estudiante);
            } else {
                return nodo; 
            }
        }
        return nodo;
    }
    

}
