/*
 * RegistroControlApp.java
 */

package registrocontrol;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import registrocontrol.lib.Finger;

/**
 * The main class of the application.
 */
public class RegistroControlApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new RegistroControlView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
        root.setIconImage(new ImageIcon(getClass().getResource("resources/icono.png")).getImage());
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of RegistroControlApp
     */
    public static RegistroControlApp getApplication() {
        return Application.getInstance(RegistroControlApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(RegistroControlApp.class, args);
        String grFingerNativeDirectory = new File(".").getAbsolutePath();
        Finger.setFingerprintSDKNativeDirectory(grFingerNativeDirectory);
    }
}
