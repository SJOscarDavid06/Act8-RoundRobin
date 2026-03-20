import javax.swing.*;
import java.awt.Color;

/**
 * ESta clase controla la paleta de colores de la interfaz, hace que el programa mantenga
 * coherencia en cuanto a diseño
 */
public class PaletaColores {

    /**
     * Color de fondo general
     */
    public static Color FONDO_PANEL = new Color(155, 235, 250);// Fondo general

    /**
     * Define el color de las de procesos.
     */
    public static Color FONDO_LISTA = new Color(190, 235, 250); // Listas
    /**
     * Color de la fuente para los elementos de las listas
     */
    public static Color TEXTO_LISTA = new Color(80, 80, 100);

    /**
     * Color para las etiquetas de texto
     */
    public static Color TEXTO_LABEL = new Color(120, 120, 150);    // Labels


    // Botones
    /**
     * Color base de los botones en su estado normal.
     */
    public static Color FONDO_BOTON = new Color(167, 199, 231);
    /**
     * Color de boton cuando el cursor es encima de el.
     */
    public static Color HOVER_BOTON = new Color(216, 180, 248);
    /**
     * Color aplicado al contorno de los botones.
     */
    public static Color BORDE_BOTON = new Color(184, 224, 210);
    /**
     * Color de la funete de los botones.
     */
    public static Color TEXTO_BOTON = Color.WHITE;
}