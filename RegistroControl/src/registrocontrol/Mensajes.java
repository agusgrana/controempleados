package registrocontrol;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Mensajes {

    public static void Error(Object padre, String mensaje)
    {
        JOptionPane.showMessageDialog((Component) padre,mensaje,"Error",JOptionPane.ERROR_MESSAGE);
    }

    public static void Ok(Object padre, String mensaje)
    {
        JOptionPane.showMessageDialog((Component) padre,mensaje,"Correcto",JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean Confirm(Object padre, String pregunta)
    {
        if(JOptionPane.showConfirmDialog((Component) padre,pregunta,"Confirmacion",JOptionPane.OK_OPTION)==JOptionPane.OK_OPTION)
            return true;
        else return false;
    }


}
