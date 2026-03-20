public class Proceso {

    private int id;
    private int tiempoEjecucionTotal;
    private int tiempoRestante;
    private Estado estado;


    public enum Estado { //posibles estados
        EN_EJECUCION,
        EN_ESPERA,
        TERMINADO
    }


    public Proceso(int id, int tiempoEjecucionTotal) {
        this.id = id;
        this.tiempoEjecucionTotal = tiempoEjecucionTotal;
        this.tiempoRestante = tiempoEjecucionTotal;
        this.estado = Estado.EN_ESPERA;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTiempoEjecucionTotal() {
        return tiempoEjecucionTotal;
    }

    public void setTiempoEjecucionTotal(int tiempoEjecucionTotal) {
        this.tiempoEjecucionTotal = tiempoEjecucionTotal;
    }

    public int getTiempoRestante() {
        return tiempoRestante;
    }

    public void setTiempoRestante(int tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    public void restarTiempo(int cantidad) { //Reduce el tiempo restante
        tiempoRestante -= cantidad;

        if (tiempoRestante <= 0) {
            tiempoRestante = 0;
            estado = Estado.TERMINADO;
        }
    }
}