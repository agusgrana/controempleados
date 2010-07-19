
package registrocontrol.lib;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Valida {

    public static boolean isId(String id){
        try{
            Long iden = Long.parseLong(id);
            if(iden.toString().length()>=5 && iden>0)
                return true;
        }catch(NumberFormatException ne){  
        }
        return false;
    }

    public static boolean isPalabra(String palabra){
        if(palabra.length()>2 && palabra.length()<46)
            return true;
        else return false;
    }

    public static boolean isSalario(String salario){
        try{
            int num = Integer.parseInt(salario);
            if(num>=1000 && num<=1000000000)
                return true;
        }catch(NumberFormatException ne){}
        return false;
    }

    public static boolean isTelefono(String telefono){
        try{
            Long.parseLong(telefono);
            if(telefono.length()>6 && telefono.length()<11)
                return true;
        }catch(NumberFormatException ne){}
        return false;
        
    }

    public static boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            return true;
        }else{
            return false;
        }
    }

}
