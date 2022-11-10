package SwingTablero;

import javax.swing.*;
import java.awt.*;

public class PopUp {
    JFrame popUP = new JFrame();
    JLabel label;
    Timer timer;
    boolean mostrar;

    public PopUp(String msj){
        mostrar = true;
        label = new JLabel(msj);
        label.setBounds(0, 0, 250, 90);
        label.setFont(new Font(null, Font.ITALIC, 25));

        popUP.setTitle("Error");
        popUP.setSize(900, 150);

        popUP.add(label);
        popUP.setVisible(true);
        timer = new Timer(2000, e -> changeMostrar());
        timer.start();
        if (!timer.isRunning()){
            popUP.setVisible(false);
            //timer.stop();
        }
    }

    public void changeMostrar(){
        mostrar = false;
    }
}