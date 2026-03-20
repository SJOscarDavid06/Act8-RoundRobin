import javax.swing.*;

public class CustomButton extends JButton {

    public CustomButton(String text) {
        super(text);
        setUI(new CustomButtonUI());
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }
}