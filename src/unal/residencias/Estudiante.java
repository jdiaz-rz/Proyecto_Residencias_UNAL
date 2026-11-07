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

    public String getId() { return id; }
    public String getNombreCompleto() { return nombreCompleto; }
    public int getPuntajeSocioeconomico() { return puntajeSocioeconomico; }
    public void setPuntajeSocioeconomico(int puntajeSocioeconomico) { this.puntajeSocioeconomico = puntajeSocioeconomico; }
    public boolean isAsignado() { return asignado; }
    public void setAsignado(boolean asignado) { this.asignado = asignado; }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombreCompleto + " | Puntaje: " + puntajeSocioeconomico;
    }
}
