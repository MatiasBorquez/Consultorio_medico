package Exepcion;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 * @author Boros
 */
public class TurnoExistenteEnElHorario extends ErrorEnFormulario{
    public TurnoExistenteEnElHorario(String mensaje, LocalDateTime horario){
        super(mensaje);
        JOptionPane.showMessageDialog(null, "Turno Existente en el horirio: " + horario);
    }
}
