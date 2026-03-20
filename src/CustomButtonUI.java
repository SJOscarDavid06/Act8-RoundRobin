import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.JButton;
import java.awt.*;

public class CustomButtonUI extends BasicButtonUI {

    @Override
    public void paint(Graphics g, javax.swing.JComponent c) {
        JButton button = (JButton) c;
        Graphics2D g2 = (Graphics2D) g.create();

        if (button.getModel().isRollover()) {
            g2.setColor(PaletaColores.HOVER_BOTON);
        } else {
            g2.setColor(PaletaColores.FONDO_BOTON);
        }

        g2.fillRoundRect(0, 0, button.getWidth(), button.getHeight(), 20, 20);

        g2.setColor(PaletaColores.BORDE_BOTON);
        g2.drawRoundRect(0, 0, button.getWidth()-1, button.getHeight()-1, 20, 20);

        g2.setColor(PaletaColores.TEXTO_BOTON);
        FontMetrics fm = g2.getFontMetrics();
        int x = (button.getWidth() - fm.stringWidth(button.getText())) / 2;
        int y = (button.getHeight() + fm.getAscent()) / 2 - 2;
        g2.drawString(button.getText(), x, y);

        g2.dispose();
    }
}