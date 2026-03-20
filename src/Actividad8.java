import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Clase principal que controla la venta y la simulación.
 * Esta clase se encarga de recibir los datos del usuario,
 * los guarda en una lista y ejecuta un hilo que muestra el conteo del tiempo en pantalla
 *
 */
public class Actividad8 {

    private JPanel panel;
    private JSlider slider1;
    private JList list1;
    private JLabel label1;
    private JPanel panel2;
    private JButton agregarProcesoButton;
    private JButton iniciarSimulacionButton;
    private JList list2;
    private JLabel label2;
    private JPanel panel3;
    private DefaultListModel<String> listModel;
    private DefaultListModel<String> listModel2;
    private java.util.ArrayList<Integer> procesos = new java.util.ArrayList<>();
    private Timer guiTimer; // Atributo para el Timer (Punto 4)
    private java.util.List<Proceso> listaProcesosObj = new java.util.ArrayList<>();
    private int contadorIds = 1;
    /**
     * Constructor de la clase
     * Se limpia la interfaz, se aplican los colores ya definidos y se preparan los botones
     */
    public Actividad8() {
        //Modelos
        listModel = new DefaultListModel();
        list1.setModel(listModel);
        listModel2 = new DefaultListModel<>();
        list2.setModel(listModel2);

        //rango del slider
        slider1.setMaximum(10);
        slider1.setMinimum(1);
        slider1.setValue(1);
        slider1.addChangeListener(e -> label2.setText("Valor: " + slider1.getValue()));
        //Acciones de botones
        agregarProcesoButton.addActionListener(e -> agregarProceso());
        iniciarSimulacionButton.addActionListener(e -> simular());
        //Colores
        panel.setOpaque(true);
        panel2.setOpaque(true);

        list1.setOpaque(true);
        list2.setOpaque(true);

        label1.setOpaque(true);
        label2.setOpaque(true);
        //Colores
        panel.setBackground(PaletaColores.FONDO_PANEL);
        panel2.setBackground(PaletaColores.FONDO_PANEL);
        panel3.setBackground(PaletaColores.FONDO_PANEL);

        list1.setBackground(PaletaColores.FONDO_LISTA);
        list1.setForeground(PaletaColores.TEXTO_LISTA);

        list1.setSelectionBackground(PaletaColores.FONDO_BOTON);
        list1.setSelectionForeground(Color.WHITE);

        list2.setSelectionBackground(PaletaColores.FONDO_BOTON);
        list2.setSelectionForeground(Color.WHITE);

        label1.setForeground(PaletaColores.TEXTO_LABEL);
        label2.setForeground(PaletaColores.TEXTO_LABEL);

        label1.setBackground(PaletaColores.FONDO_PANEL);
        label2.setBackground(PaletaColores.FONDO_PANEL);

        slider1.setBackground(PaletaColores.FONDO_PANEL);
        // 🔘 BOTONES PERSONALIZADOS
        agregarProcesoButton.setUI(new CustomButtonUI());
        iniciarSimulacionButton.setUI(new CustomButtonUI());

        agregarProcesoButton.setContentAreaFilled(false);
        iniciarSimulacionButton.setContentAreaFilled(false);

        agregarProcesoButton.setBorderPainted(false);
        iniciarSimulacionButton.setBorderPainted(false);

        agregarProcesoButton.setFocusPainted(false);
        iniciarSimulacionButton.setFocusPainted(false);

        configurarTimerRefresco();// LLAMADA AL PUNTO 4
    }
    private void configurarTimerRefresco() {
        // Creamos el Timer de Swing (ejecuta cada 200ms)
        guiTimer = new Timer(200, e -> {
            actualizarInterfaz();
        });
        guiTimer.start();
    }

    private void actualizarInterfaz() {
        // Esta es la "Sincronización GUI-Modelo"
        // Limpiamos el modelo visual y lo repoblamos con los datos reales del objeto Proceso
        listModel.clear(); 
        for (Proceso p : listaProcesosObj) {
            String info = "Proceso " + p.getId() + " - " + p.getEstado() + " (" + p.getTiempoRestante() + "s)";
            listModel.addElement(info);
        }
    }

    /**
     * Este metodo es el motor que corre un hilo por separado
     * Va tomando cada tiempo de lista y lo muestra
     */
    private void simular() {
        new Thread(() -> {
            while (!listaProcesosObj.isEmpty()) {
                // Tomamos el proceso en turno
                Proceso pActual = listaProcesosObj.get(0);
                pActual.setEstado("Procesando");

                // Encabezado visual en la lista 2
                SwingUtilities.invokeLater(() -> {
                    listModel2.addElement("Proceso " + pActual.getId() + " (" + pActual.getTiempoTotal() + "s)");
                });

                // Ciclo de vida del proceso
                while (pActual.getTiempoRestante() > 0) {
                    try {
                        Thread.sleep(500); // Simulamos el paso del tiempo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    pActual.decrementarTiempo(); // El Timer reflejará esto en list1 automáticamente

                    // Actualizar slider y conteo en list2
                    int progreso = pActual.getTiempoTotal() - pActual.getTiempoRestante();
                    SwingUtilities.invokeLater(() -> {
                        listModel2.addElement("  " + progreso);
                        slider1.setValue(progreso);
                    });
                }

                pActual.setEstado("Terminado");
                SwingUtilities.invokeLater(() -> listModel2.addElement("✔ Terminado\n"));

                // Lo sacamos de la lista, el Timer lo borrará de la pantalla
                listaProcesosObj.remove(0);

                try {
                    Thread.sleep(500); // Breve pausa antes del siguiente proceso
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Resetear slider al terminar todos los procesos
            SwingUtilities.invokeLater(() -> slider1.setValue(0));
        }).start();
    }

    /**
     * Toma el valor que el usuario eligió del slider y lo guarda
     * en la lista de procesos para que después pueda ser simulado
     *
     */
    private void agregarProceso() {
        int valor = slider1.getValue();
        Proceso nuevoProceso = new Proceso(contadorIds++, valor);
        listaProcesosObj.add(nuevoProceso);
    }

    /**
     * Clase principal
     * Es el punto de entrada del programa. Crea la ventana, le pone título y tamaño
     *
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Actividad 7");
            frame.setContentPane(new Actividad8().panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 320);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

}
