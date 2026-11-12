package unal.residencias.estructuras;

import unal.residencias.Estudiante;
import unal.residencias.estructuras.ListaDinamica;

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

        // 1. Inserción normal de BST (con desempate por ID)
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
                return nodo; // Duplicado exacto (no debería pasar por el UUID)
            }
        }

        // 2. Actualizar altura
        nodo.altura = 1 + max(altura(nodo.izquierdo), altura(nodo.derecho));

        // 3. Obtener factor de balance
        int balance = getBalance(nodo);

        // 4. Lógica de balanceo a prueba de empates (basada en el estado del hijo)

        // Caso Izquierda - Izquierda
        if (balance > 1 && getBalance(nodo.izquierdo) >= 0)
            return rotacionDerecha(nodo);

        // Caso Izquierda - Derecha
        if (balance > 1 && getBalance(nodo.izquierdo) < 0) {
            nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
            return rotacionDerecha(nodo);
        }

        // Caso Derecha - Derecha
        if (balance < -1 && getBalance(nodo.derecho) <= 0)
            return rotacionIzquierda(nodo);

        // Caso Derecha - Izquierda
        if (balance < -1 && getBalance(nodo.derecho) > 0) {
            nodo.derecho = rotacionDerecha(nodo.derecho);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    public void extraerMinimos(int cantidad, ListaDinamica asignados) {
        extraerMinimosRecursivo(raiz, cantidad, asignados);
    }

    private void extraerMinimosRecursivo(NodoAVL nodo, int cantidad, ListaDinamica asignados) {
        if (nodo == null || asignados.tamaño() >= cantidad) return;

        extraerMinimosRecursivo(nodo.izquierdo, cantidad, asignados);

        if (asignados.tamaño() < cantidad) {
            asignados.agregar(nodo.estudiante);
        }

        extraerMinimosRecursivo(nodo.derecho, cantidad, asignados);
    }
}
