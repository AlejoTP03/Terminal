/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;


import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *
 * @author PC
 */
public class VerificarEntradaDeHora extends InputVerifier{
    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    public VerificarEntradaDeHora() {
        timeFormat.setLenient(false); // Para asegurar que el formato sea exacto
    }

    @Override
    public boolean verify(JComponent input) {
        JTextField textField = (JTextField) input;
        String text = textField.getText();

        try {
            timeFormat.parse(text); // Intenta analizar el texto como una hora
            return true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de tiempo inválido. Use HH:mm:ss.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
