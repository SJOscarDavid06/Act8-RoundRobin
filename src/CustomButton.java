import javax.swing.*;

/**
 * Esta clase es un boton especifico que ya esta personalizado
 */
public class CustomButton extends JButton {

    /**
     * Crea el boton con el texto que queramos y con la personalizacion ya antes definida
     *
     * @param text es el texto que llevara el boton
     */
    public CustomButton(String text) {
        super(text);
        setUI(new CustomButtonUI());
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }
}