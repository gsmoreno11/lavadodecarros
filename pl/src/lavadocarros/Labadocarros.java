package lavadocarros;
import Modelos.*;
import Controlador.Controlador;
import Vista.InterfaceDos;
import Vista.InterfaceUno;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Labadocarros{
       public static void main(String arf[]){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(UnsupportedLookAndFeelException e){
        }catch(ClassNotFoundException e){
        }catch(InstantiationException e){
        }catch(IllegalAccessException e){
        }
        Modelo modelo = new Modelo();
        InterfaceUno vista =new InterfaceUno();
        InterfaceDos vistaDos =new InterfaceDos();
        Controlador controlador = new Controlador(vista,vistaDos, modelo);
        controlador.Iniciar();

    }

       
    
}