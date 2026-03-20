
import javax.swing.JOptionPane;

public class inputValidator {

    public static int validarEntero(String texto) throws NumberFormatException { // arroja excepcion de formato incorrecto

        if (texto == null || texto.trim().isEmpty()) {
            throw new NumberFormatException("El campo está vacío");
        }

        int valor = Integer.parseInt(texto); // se guarda el texto en una variable

        if (valor <= 0) {
            throw new NumberFormatException("El valor debe ser mayor a 0");
        }

        return valor;
    }

    // muetodo para mostrar errores
    public static void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null,mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }


}
