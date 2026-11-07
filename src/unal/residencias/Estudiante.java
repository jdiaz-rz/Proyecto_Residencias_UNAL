package unal.residencias;

public class Estudiante {
    private String id;
    private String nombreCompleto;
    private int puntajeSocioeconomico;
    private boolean asignado;

    public Estudiante(String id, String nombreCompleto, int puntajeSocioeconomico) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.puntajeSocioeconomico = puntajeSocioeconomico;
        this.asignado = false;
    }
}
