package unal.residencias.estructuras;
import unal.residencias.Estudiante;

public class ListaDinamica {
    private Estudiante[] elementos;
    private int tamaño;

    public ListaDinamica() {
        this.elementos = new Estudiante[10];
        this.tamaño = 0;
    }

    public void agregar(Estudiante e) {
        if (tamaño == elementos.length) {
            Estudiante[] nuevoArreglo = new Estudiante[elementos.length * 2];
            System.arraycopy(elementos, 0, nuevoArreglo, 0, elementos.length);
            this.elementos = nuevoArreglo;
        }
        this.elementos[tamaño++] = e;
    }

    public Estudiante obtener(int indice) { return elementos[indice]; }
    public int tamaño() { return tamaño; }
}