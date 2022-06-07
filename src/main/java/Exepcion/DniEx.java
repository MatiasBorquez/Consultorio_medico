package Exepcion;

import javax.swing.JOptionPane;

/**
 * @author Boros
 */
public class DniEx extends ErrorEnFormulario{
    public DniEx(String mensaje){
        super(mensaje);
        JOptionPane.showMessageDialog(null, "La persona ya existe en el registro");
    }
}
