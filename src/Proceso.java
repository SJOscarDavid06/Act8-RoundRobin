public class Proceso {
    private int id;
    private String estado;
    private int tiempoRestante;
    private int tiempoTotal;

    public Proceso(int id, int tiempoRestante) {
        this.id = id;
        this.tiempoRestante = tiempoRestante;
        this.tiempoTotal = tiempoRestante;
        this.estado = "En espera";
    }

    public int getId() { return id; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public int getTiempoRestante() { return tiempoRestante; }
    public int getTiempoTotal() { return tiempoTotal; }
    public void decrementarTiempo() { this.tiempoRestante--; }
}