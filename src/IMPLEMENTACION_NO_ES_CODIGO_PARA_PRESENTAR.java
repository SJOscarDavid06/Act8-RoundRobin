public class IMPLEMENTACION_NO_ES_CODIGO_PARA_PRESENTAR {

    // Ejemplo del uso de la GUI
    try {
        int tiempo = InputValidator.validarEntero(txtTiempo.getText());
    } catch (NumberFormatException e) {
        InputValidator.mostrarError(e.getMessage());
    }

    //Ejemplo con el scheduler ( bandera booleana )

    SchedulerController control = new SchedulerController();

    btnIniciar.addActionListener(e -> {
        if (!control.isRunning()) {
            new Thread(() -> scheduler.execute()).start();
            control.iniciar();
        }
    });

    btnDetener.addActionListener(e -> {
        control.detener();
    });

}
