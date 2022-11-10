package FacadeStrategy.Facade.Objetos;
import SwingTablero.JuegoTablero;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class UIprefas implements ActionListener {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Test");
    ImageIcon icon;
    JPanel panel1;
    JPanel panel2;
    JButton btnEle;
    JButton btnCruz;
    JButton btnZeta;
    JButton btnPe;
    JButton btnU;
    JButton btnTe;
    private String prefaSeleccionada;
    private int rotacionPrefa;
    JButton btnV1;
    JButton btnV2;
    JButton btnV3;
    JButton btnV4;

    public UIprefas(){
        label.setBounds(0,0,100,50);
        label.setFont(new Font(null, Font.ITALIC, 25));

        frame.setTitle("Escoger figura");
        frame.setSize(1000,800);
        frame.setVisible(true);

        frame.setLayout(new GridLayout(2, 0));

        panel1 = new JPanel(new GridLayout(1, 6));
        panel1.setBackground(Color.black);

        btnEle = new JButton();
        btnEle.setBounds(10, 10, 165, 200);
        btnEle.addActionListener(this);
        btnEle.setFocusable(false);
        icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("EleV1.png")));
        btnEle.setIcon(icon);

        btnCruz = new JButton();
        btnCruz.setBounds(10, 10, 165, 200);
        btnCruz.addActionListener(this);
        btnCruz.setFocusable(false);
        icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Cruz.png")));
        btnCruz.setIcon(icon);

        btnZeta = new JButton();
        btnZeta.setBounds(10, 10, 165, 200);
        btnZeta.addActionListener(this);
        btnZeta.setFocusable(false);
        icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("ZetaV1.png")));
        btnZeta.setIcon(icon);

        btnPe = new JButton();
        btnPe.setBounds(10, 10, 165, 200);
        btnPe.addActionListener(this);
        btnPe.setFocusable(false);
        icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("PeV1.png")));
        btnPe.setIcon(icon);

        btnU = new JButton();
        btnU.setBounds(10, 10, 165, 200);
        btnU.addActionListener(this);
        btnU.setFocusable(false);
        icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("UV1.png")));
        btnU.setIcon(icon);

        btnTe = new JButton();
        btnTe.setBounds(10, 10, 165, 200);
        btnTe.addActionListener(this);
        btnTe.setFocusable(false);
        icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("TeV1.png")));
        btnTe.setIcon(icon);

        panel1.add(btnEle);
        panel1.add(btnCruz);
        panel1.add(btnZeta);
        panel1.add(btnPe);
        panel1.add(btnU);
        panel1.add(btnTe);
        frame.add(panel1);

        panel2 = new JPanel();
        panel2.setBackground(Color.GRAY);
        frame.add(panel2);
    }

    public void inicializarBTNv1(String prefa){
        switch (prefa) {
            case "Ele" -> {
                btnV1 = new JButton();
                btnV1.setBounds(10, 10, 165, 200);
                btnV1.addActionListener(this);
                btnV1.setFocusable(false);
                icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("EleV1.png")));
                btnV1.setIcon(icon);
                btnV2 = new JButton();
                btnV2.setBounds(10, 10, 165, 200);
                btnV2.addActionListener(this);
                btnV2.setFocusable(false);
                icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("EleV2.png")));
                btnV2.setIcon(icon);
                btnV3 = new JButton();
                btnV3.setBounds(10, 10, 165, 200);
                btnV3.addActionListener(this);
                btnV3.setFocusable(false);
                icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("EleV3.png")));
                btnV3.setIcon(icon);
                btnV4 = new JButton();
                btnV4.setBounds(10, 10, 165, 200);
                btnV4.addActionListener(this);
                btnV4.setFocusable(false);
                icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("EleV4.png")));
                btnV4.setIcon(icon);
                panel2.add(btnV1);
                panel2.add(btnV2);
                panel2.add(btnV3);
                panel2.add(btnV4);
            }
            case "Cruz" -> {
                btnV1 = new JButton();
                btnV1.setBounds(10, 10, 165, 200);
                btnV1.addActionListener(this);
                btnV1.setFocusable(false);
                icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("Cruz.png")));
                btnV1.setIcon(icon);
                panel2.add(btnV1);
            }
            case "Pe" -> {
                btnV1 = new JButton();
                btnV1.setBounds(10, 10, 165, 200);
                btnV1.addActionListener(this);
                btnV1.setFocusable(false);
                icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("PeV1.png")));
                btnV1.setIcon(icon);
                btnV2 = new JButton();
                btnV2.setBounds(10, 10, 165, 200);
                btnV2.addActionListener(this);
                btnV2.setFocusable(false);
                icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("PeV2.png")));
                btnV2.setIcon(icon);
                btnV3 = new JButton();
                btnV3.setBounds(10, 10, 165, 200);
                btnV3.addActionListener(this);
                btnV3.setFocusable(false);
                icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("PeV3.png")));
                btnV3.setIcon(icon);
                btnV4 = new JButton();
                btnV4.setBounds(10, 10, 165, 200);
                btnV4.addActionListener(this);
                btnV4.setFocusable(false);
                icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("PeV4.png")));
                btnV4.setIcon(icon);
                panel2.add(btnV1);
                panel2.add(btnV2);
                panel2.add(btnV3);
                panel2.add(btnV4);
            }
            case "Te" -> {
                btnV1 = new JButton();
                btnV1.setBounds(10, 10, 165, 200);
                btnV1.addActionListener(this);
                btnV1.setFocusable(false);
                icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("TeV1.png")));
                btnV1.setIcon(icon);
                btnV2 = new JButton();
                btnV2.setBounds(10, 10, 165, 200);
                btnV2.addActionListener(this);
                btnV2.setFocusable(false);
                icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("TeV2.png")));
                btnV2.setIcon(icon);
                btnV3 = new JButton();
                btnV3.setBounds(10, 10, 165, 200);
                btnV3.addActionListener(this);
                btnV3.setFocusable(false);
                icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("TeV3.png")));
                btnV3.setIcon(icon);
                btnV4 = new JButton();
                btnV4.setBounds(10, 10, 165, 200);
                btnV4.addActionListener(this);
                btnV4.setFocusable(false);
                icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("TeV4.png")));
                btnV4.setIcon(icon);
                panel2.add(btnV1);
                panel2.add(btnV2);
                panel2.add(btnV3);
                panel2.add(btnV4);
            }
            case "U" -> {
                btnV1 = new JButton();
                btnV1.setBounds(10, 10, 165, 200);
                btnV1.addActionListener(this);
                btnV1.setFocusable(false);
                icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("UV1.png")));
                btnV1.setIcon(icon);
                btnV2 = new JButton();
                btnV2.setBounds(10, 10, 165, 200);
                btnV2.addActionListener(this);
                btnV2.setFocusable(false);
                icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("UV2.png")));
                btnV2.setIcon(icon);
                btnV3 = new JButton();
                btnV3.setBounds(10, 10, 165, 200);
                btnV3.addActionListener(this);
                btnV3.setFocusable(false);
                icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("UV3.png")));
                btnV3.setIcon(icon);
                btnV4 = new JButton();
                btnV4.setBounds(10, 10, 165, 200);
                btnV4.addActionListener(this);
                btnV4.setFocusable(false);
                icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("UV4.png")));
                btnV4.setIcon(icon);
                panel2.add(btnV1);
                panel2.add(btnV2);
                panel2.add(btnV3);
                panel2.add(btnV4);
            }
            case "Zeta" -> {
                btnV1 = new JButton();
                btnV1.setBounds(10, 10, 165, 200);
                btnV1.addActionListener(this);
                btnV1.setFocusable(false);
                icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("ZetaV1.png")));
                btnV1.setIcon(icon);
                btnV2 = new JButton();
                btnV2.setBounds(10, 10, 165, 200);
                btnV2.addActionListener(this);
                btnV2.setFocusable(false);
                icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("ZetaV2.png")));
                btnV2.setIcon(icon);
                panel2.add(btnV1);
                panel2.add(btnV2);
            }
        }
    }

    public void actualizarVariablesEnJuegoTablero(){
        JuegoTablero.setPrefaSeleccionada(prefaSeleccionada);
        JuegoTablero.setFormaSeleccionada(rotacionPrefa);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEle) {
            prefaSeleccionada = "Ele";
            inicializarBTNv1(prefaSeleccionada);
            panel2.updateUI();
        }
        if (e.getSource() == btnCruz) {
            prefaSeleccionada = "Cruz";
            inicializarBTNv1(prefaSeleccionada);
            panel2.updateUI();
        }
        if (e.getSource() == btnZeta) {
            prefaSeleccionada = "Zeta";
            inicializarBTNv1(prefaSeleccionada);
            panel2.updateUI();
        }
        if (e.getSource() == btnPe) {
            prefaSeleccionada = "Pe";
            inicializarBTNv1(prefaSeleccionada);
            panel2.updateUI();
        }
        if (e.getSource() == btnU) {
            prefaSeleccionada = "U";
            inicializarBTNv1(prefaSeleccionada);
            panel2.updateUI();
        }
        if (e.getSource() == btnTe) {
            prefaSeleccionada = "Te";
            inicializarBTNv1(prefaSeleccionada);
            panel2.updateUI();
        }

        if (e.getSource() == btnV1){
            rotacionPrefa = 1;
            frame.setVisible(false);
            actualizarVariablesEnJuegoTablero();
        }
        if (e.getSource() == btnV2){
            rotacionPrefa = 2;
            frame.setVisible(false);
            actualizarVariablesEnJuegoTablero();
        }
        if (e.getSource() == btnV3){
            rotacionPrefa = 3;
            frame.setVisible(false);
            actualizarVariablesEnJuegoTablero();
        }
        if (e.getSource() == btnV4){
            rotacionPrefa = 4;
            frame.setVisible(false);
            actualizarVariablesEnJuegoTablero();
        }
    }
}