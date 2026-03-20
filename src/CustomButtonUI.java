import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.JButton;
import java.awt.*;

/**
 * Clase encargada de redibujar la interfaz y sus componentes.
 * Implementa un diseño con bordes redondeados
 *
 */
public class CustomButtonUI extends BasicButtonUI {

    /**
     * Sobrescribe el metodo de dibujado para poder dibujar el boton de manera manual y personalizarlo.
     *
     * @param g contexto grafico
     * @param c Es el componente a que se esta personalizando en este caso el boton
     *
     */
    @Override
    public void paint(Graphics g, javax.swing.JComponent c) {
        JButton button = (JButton) c;
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//activa el Antialiasing, haciendo que las curvas de tus botones se vean profesionales.

        if (button.getModel().isRollover()) {
            g2.setColor(PaletaColores.HOVER_BOTON);
        } else {
            g2.setColor(PaletaColores.FONDO_BOTON);
        }

        g2.fillRoundRect(0, 0, button.getWidth(), button.getHeight(), 20, 20);

        g2.setColor(PaletaColores.BORDE_BOTON);
        g2.drawRoundRect(0, 0, button.getWidth() - 1, button.getHeight() - 1, 20, 20);

        g2.setColor(PaletaColores.TEXTO_BOTON);
        FontMetrics fm = g2.getFontMetrics();
        int x = (button.getWidth() - fm.stringWidth(button.getText())) / 2;
        int y = (button.getHeight() + fm.getAscent()) / 2 - 2;
        g2.drawString(button.getText(), x, y);

        g2.dispose();
    }
}