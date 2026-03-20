public class SchedulerController {

    // CONTROL DE EJECUCION CON BOOLEANO
    private boolean isRunning = false; // bandera

    // iniciar  la  ejecucion
    public void iniciar() {
        isRunning = true;
    }

    // detiene la ejecucoon segura
    public void detener() {
        isRunning = false;
    }

    // verifica el estado
    public boolean isRunning() {
        return isRunning;
    }
}
