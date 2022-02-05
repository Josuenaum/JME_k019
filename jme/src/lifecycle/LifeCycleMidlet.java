package lifecycle;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.midlet.*;

/**
 * @author Josue Naum Ramirez B
 */
public class LifeCycleMidlet extends MIDlet implements CommandListener {
private Form formulario;
private Display pantalla;
private Command cmdExit;
private StringItem message;

    public LifeCycleMidlet() {
        System.out.println("llamamos a la inicializacion de midlet");
        formulario = new Form("Midlet lifecycle");
        message = new StringItem(null, "Construyendo el Midlet");
        formulario.append(message);
      cmdExit = new Command("Salir", Command.EXIT, 1);
      formulario.addCommand(cmdExit);
      formulario.setCommandListener(this);
      pantalla = Display.getDisplay(this);
      pantalla.setCurrent(formulario);
    }



    public void startApp() {
      System.out.println("startApp() is called");
      message.setText("Iniciando Midlet");
    }
    
    public void pauseApp() {
        System.out.println("pauseApp() is called");
      message.setText("Midlet en pausa");
    }
    
    public void destroyApp(boolean unconditional) {
        System.out.println("destroyApp() is called");
      message.setText("Midlet destroyed...");
    }

    public void commandAction(Command c, Displayable d) {
         if (c == cmdExit) {
         destroyApp(true);  
         notifyDestroyed();
      }
    }
}
