package SwingTablero;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.*;
import javax.swing.border.LineBorder;

import Decorador.Componente_Concreto.Artillero;
import Decorador.Componente_Concreto.Infanteria;
import Decorador.Componente_Concreto.Tanque;
import FacadeStrategy.Facade.Main.Fachada_Prefas;
import Memento.main.Gestor_Memento1;
import Memento.main.Gestor_Memento2;
import Observador.Principal.Gestor_Observador;
import Proxy.Main.GestorProxy;
import BuilderPrototipo.objetos.IComponenteTablero;
import BuilderPrototipo.objetos.helperObjetos.ColorCuadrado;
import BuilderPrototipo.objetos.patronPrototipoCuadrado.iPrototipoCuadrado.Cuadrado;
import BuilderPrototipo.gestor.Gestor;

public class JuegoTablero extends JFrame implements MouseListener, ActionListener {
    static Gestor board = new Gestor();
    static Gestor_Observador gObservador= new Gestor_Observador();
    static JLabel[][] label;
    public static IComponenteTablero[][] squares = board.tableroPrincipal();
    static ImageIcon iconCastillo = new ImageIcon(JuegoTablero.class.getResource("Castillo1.jpg"));

    static ImageIcon iconWhite = new ImageIcon(JuegoTablero.class.getResource("grass1.jpeg"));
    static ImageIcon iconBrown = new ImageIcon(JuegoTablero.class.getResource("brown.png"));
    static ImageIcon iconGray = new ImageIcon(JuegoTablero.class.getResource("gray.png"));
    static String personajeAgregar;

    static JButton btnCofre1=new JButton();
    static JButton btnCofre2=new JButton();
    static JButton btnPrefas;
    JButton botonDados;
    static JButton btnTurno;
    static JLabel textoBu3 = new JLabel();
    static int turno = 0;
    static int jugador = 1;
    static boolean empezando = true;

    static String prefaSeleccionada;
    static int formaSeleccionada;
    private Fachada_Prefas fachada = new Fachada_Prefas();
    private static GestorProxy gestorProxy = new GestorProxy();

    //Variables movimiento personaje
    static int movDado;
    static int movADar;
    static String personaAMover;
    static String personaAMoverCol;
    static int personaAMoverReng;

    static int vidasJugador1 = 3;
    static int vidasJugador2 = 3;

    static String colAtaque;
    static int rowAtaque;
    static String colAtacado;
    static int rowAtacado;



    /**
     * Variable para el arreglo[][] de las casillas del tablero.
     */
    JLabel[][] l;
    JLabel[][] m;

    /**
     * Variable para la ventana de juego, que contiene todo lo que se va a imprimir.
     */
    JPanel panel = new JPanel(new GridLayout(22, 20));

    /**
     * Unicamente es para crear un espacio blanco arriba del tablero en la ventana de juego
     */
    public void filaBlanca1() {
        l = new JLabel[1][19];
        for (int j = 0; j < 19; j++) {
            if (j == 0) {
                l[0][j] = new JLabel();
                l[0][j].setIcon(iconCastillo);
                panel.add(l[0][j]);
            } else if(j==1) {
                l[0][j] = new JLabel();
                l[0][j].setOpaque(true);
                l[0][j].setText("Jugador 1");
                l[0][j].setBackground(new Color(77, 191, 99));
                panel.add(l[0][j]);
            } else if (j == 2) {
                l[0][j] = new JLabel();
                l[0][j].setOpaque(true);
                l[0][j].setText("Vidas: " + vidasJugador1);
                panel.add(l[0][j]);
            } else {
                l[0][j] = new JLabel();
                panel.add(l[0][j]);
            }
        }
    }
    public void filaBlanca2() {
        m = new JLabel[1][19];
        for (int j = 0; j < 19; j++) {
             if(j==17) {
                 m[0][j] = new JLabel();
                 m[0][j].setOpaque(true);
                 m[0][j].setText("Jugador 2");
                 m[0][j].setBackground(new Color(229, 77, 65));
                 panel.add(m[0][j]);
             }else if (j == 18) {
                     m[0][j] = new JLabel();
                     m[0][j].setIcon(iconCastillo);
                     panel.add(m[0][j]);
            } else if (j == 16) {
                 m[0][j] = new JLabel();
                 m[0][j].setOpaque(true);
                 m[0][j].setText("Vidas: " + vidasJugador2);
                 panel.add(m[0][j]);
             }else {
                m[0][j] = new JLabel();
                panel.add(m[0][j]);
            }
        }
    }

    /**
     * Constructor de la clase, llama al resto de las funciones para aparecer en el UI
     */
    public JuegoTablero() {
        super("Reinos Cenfotec Dungeons and Army");
        btnCofre1.addActionListener(this);
        btnCofre1.setText("Cofre");
        panel.add(btnCofre1);
        filaBlanca1();
        label = new JLabel[20][20];
        for (int j = 0; j < 20; j++) {
            for (int i = 0; i < 20; i++) {
                label[i][j] = new JLabel();
                label[i][j].setOpaque(true);
                if (((Cuadrado) squares[i][j]).getSquareColor() == ColorCuadrado.White) {
                    label[i][j].setIcon(iconWhite);
                }
                label[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label[i][j].addMouseListener(this);
                label[i][j].setName(((Cuadrado) squares[i][j]).toStringLocacion());
                panel.add(label[i][j]);
            }
        }
        filaBlanca2();
        btnCofre2.addActionListener(this);
        btnCofre2.setText("Cofre");
        panel.add(btnCofre2);
        JPanel panel2 = new JPanel(new GridLayout(1, 3));
        //Creación botón prefas
        btnPrefas = new JButton("Figuras");
        btnPrefas.addActionListener(this);
        btnPrefas.setSize(300, 30);
        btnPrefas.setBorder(new LineBorder(Color.gray));
        btnPrefas.setFont(new Font("Arial", Font.BOLD, 17));
        //Creación botón dados
        botonDados = new JButton("Dados");
        botonDados.setFont(new Font("Arial", Font.BOLD, 17));
        botonDados.setOpaque(true);
        botonDados.setBorder(new LineBorder(Color.gray));
        botonDados.addActionListener(this);
        //Creación botón finalizar turno
        btnTurno = new JButton("Finalizar turno");
        btnTurno.setFont(new Font("Arial", Font.BOLD, 17));
        btnTurno.setOpaque(true);
        btnTurno.setBorder(new LineBorder(Color.gray));
        btnTurno.addActionListener(this);
        //Creación mensaje
        JPanel bu3 = new JPanel();
        textoBu3.setText("1. Escoge una prefa.");
        textoBu3.setFont(new Font("Arial", Font.BOLD, 17));
        bu3.add(textoBu3);
        bu3.setOpaque(true);

        //Se añaden los componentes al panel principal
        panel2.add(btnPrefas);
        panel2.add(botonDados);
        panel2.add(btnTurno);
        panel2.add(bu3);

        //Se añade todos los paneles principales al frame
        //add(arriba,BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);
        inicializarCuadros();
        inicializarMementoDados();
    }

    public static void pintarPrefaJugador(String columna, int renglon) {
        int prox;
        if (jugador == 1) {
            prox = 2;
        } else {
            prox = 1;
        }
        if (personajeAgregar == "INFANTERIA") {
            gestorProxy.pintarPersonaje(columna, renglon, "INFANTERIA", jugador);
        } else if (personajeAgregar == "TANQUE") {
            gestorProxy.pintarPersonaje(columna, renglon, "TANQUE", jugador);
        } else if (personajeAgregar == "ARTILLERO") {
            gestorProxy.pintarPersonaje(columna, renglon, "ARTILLERO", jugador);
        }
    }

    /**
     * Esta funcion pinta cada cuadro al darle click
     *
     * @param arg0 .
     */
    public void mousePressed(MouseEvent arg0) {
        boolean entrar2click = false;
        Object source = arg0.getSource();
        if (source instanceof JLabel) {
            JLabel panelPressed = (JLabel) source;
            String lo = panelPressed.getName();
            String[] word = lo.split("");
            String columna = lo.charAt(0) + "";
            int renglon;

            if (word.length == 2) {
                renglon = Integer.parseInt(lo.charAt(1) + "");
            } else {
                String numero = word[1] + word[2];
                renglon = Integer.parseInt(numero);
            }
            //Imprimir prefa
            if (turno == 0) {
                if (jugador == 1) {
                    fachada.imprimirPrefa(getPrefaSeleccionada(), getFormaSeleccionada(), columna, renglon, "BROWN");
                } else {
                    fachada.imprimirPrefa(getPrefaSeleccionada(), getFormaSeleccionada(), columna, renglon, "GRAY");
                }
            }

            //Escoger personaje a mover
            if(turno==1){
                if(jugador==1) {
                    if (getCuadrado(columna, renglon).getSquareColor().toString().equalsIgnoreCase("Brown")) {
                        if(getCuadrado(columna, renglon).getOcupado()){
                            personaAMover=getCuadrado(columna, renglon).getPersonaje();
                            personaAMoverCol =columna;
                            personaAMoverReng=renglon;
                            personajeAgregar=personaAMover;
                            if(personaAMover=="INFANTERIA"){
                                getCuadrado(columna, renglon).setInfanteria(null);
                                getCuadrado(columna, renglon).setOcupado(false);
                                getCuadrado(columna, renglon).setPersonaje(null);
                                pintarCuadrado(columna,renglon, "BROWN");
                                turno=2;
                            }else if(personaAMover=="TANQUE"){
                                getCuadrado(columna, renglon).setTanque(null);
                                getCuadrado(columna, renglon).setOcupado(false);
                                getCuadrado(columna, renglon).setPersonaje(null);
                                pintarCuadrado(columna,renglon, "BROWN");
                                turno=2;
                            }else{
                                getCuadrado(columna, renglon).setArtillero(null);
                                getCuadrado(columna, renglon).setOcupado(false);
                                getCuadrado(columna, renglon).setPersonaje(null);
                                pintarCuadrado(columna,renglon, "BROWN");
                                turno=2;
                            }
                        }else{
                            new PopUp("No tiene un personaje en la casilla.");
                        }
                    }else{
                        new PopUp("No es su casilla.");
                    }
                }else{
                    if (getCuadrado(columna, renglon).getSquareColor().toString().equalsIgnoreCase("Gray")) {
                        if(getCuadrado(columna, renglon).getOcupado()){
                            personaAMover=getCuadrado(columna, renglon).getPersonaje();
                            personaAMoverCol =columna;
                            personaAMoverReng=renglon;
                            personajeAgregar=personaAMover;
                            if(personaAMover=="INFANTERIA"){
                                getCuadrado(columna, renglon).setInfanteria(null);
                                getCuadrado(columna, renglon).setOcupado(false);
                                getCuadrado(columna, renglon).setPersonaje(null);
                                pintarCuadrado(columna,renglon, "GRAY");
                                turno=2;
                            }else if(personaAMover=="TANQUE"){
                                getCuadrado(columna, renglon).setTanque(null);
                                getCuadrado(columna, renglon).setOcupado(false);
                                getCuadrado(columna, renglon).setPersonaje(null);
                                pintarCuadrado(columna,renglon, "GRAY");
                                turno=2;
                            }else{
                                getCuadrado(columna, renglon).setArtillero(null);
                                getCuadrado(columna, renglon).setOcupado(false);
                                getCuadrado(columna, renglon).setPersonaje(null);
                                pintarCuadrado(columna,renglon, "GRAY");
                                turno=2;
                            }
                        }else{
                            new PopUp("No tiene un personaje en la casilla.");
                        }
                    }else{
                        new PopUp("No es su casilla.");
                    }

                }
            }
            //Mover personaje
            if(turno==2){
                if (jugador == 1) {
                    if(movDado<=movADar) {
                        if (getCuadrado(columna, renglon).getSquareColor().toString().equalsIgnoreCase("Brown")) {
                            if (movDado == movADar) {
                                if (!getCuadrado(columna, renglon).getOcupado()) {
                                    pintarPrefaJugador(columna, renglon);
                                }else{
                                    new PopUp("Casilla ocupada.");
                                    movDado -= 1;
                                }
                            }
                        } else {
                            new PopUp("No es su casilla.");
                            movDado -= 1;
                        }
                        movDado += 1;
                    }
                } else {
                    if(movDado<=movADar) {
                        if (getCuadrado(columna, renglon).getSquareColor().toString().equalsIgnoreCase("Gray")) {
                            if (movDado == movADar) {
                                if (!getCuadrado(columna, renglon).getOcupado()) {
                                    pintarPrefaJugador(columna, renglon);
                                }else{
                                    new PopUp("Casilla ocupada.");
                                    movDado -= 1;
                                }
                            }
                        } else {
                            new PopUp("No es su casilla.");
                            movDado -= 1;
                        }
                        movDado += 1;
                    }
                }
            }
            //Escoger un personje para Atacar
            if (turno == 3){
                if (jugador == 1) {
                    if (getCuadrado(columna, renglon).getSquareColor().toString().equalsIgnoreCase("Brown")) {
                        if (getCuadrado(columna, renglon).getOcupado()) {
                            colAtaque = columna; //Guardar las casillas del personaje que va a atacar
                            rowAtaque = renglon;
                            //Si llega hasta aqui, es que escogio un personaje valido dentro de las casillas correctas
                            turno = 4;
                            entrar2click = true;

                        } else {
                            new PopUp("Personaje no seleccionado.");
                        }
                    } else {
                        new PopUp("No es su casilla.");
                    }
                } else {
                    if (getCuadrado(columna, renglon).getSquareColor().toString().equalsIgnoreCase("Gray")) {
                        if (getCuadrado(columna, renglon).getOcupado()) {
                            colAtaque = columna; //Guardar las casillas del personaje que va a atacar
                            rowAtaque = renglon;
                            //Si llega hasta aqui, es que escogio un personaje valido dentro de las casillas correctas
                            turno = 4;
                            entrar2click = true;
                        } else {
                            new PopUp("Personaje no seleccionado.");
                        }
                    } else {
                        new PopUp("No es su casilla.");
                    }
                }
            }
            //Escoger un personaje para ser atacado
            if (turno == 4 && entrar2click == false) {
                boolean funcionoAtaque = false;
                if (jugador == 1) {
                    if (getCuadrado(columna, renglon).getSquareColor().toString().equalsIgnoreCase("Gray")) {
                        if (getCuadrado(columna, renglon).getOcupado()) {
                            colAtacado = columna;
                            rowAtacado = renglon;
                            funcionoAtaque = true;
                        }
                    } else {
                        new PopUp("Ataca a los personajes del otro jugador.");
                    }
                } else {
                    if (getCuadrado(columna, renglon).getSquareColor().toString().equalsIgnoreCase("Brown")) {
                        if (getCuadrado(columna, renglon).getOcupado()) {
                            colAtacado = columna;
                            rowAtacado = renglon;
                            funcionoAtaque = true;
                        }
                    } else {
                        new PopUp("Ataca a los personajes del otro jugador.");
                    }
                }
                if (funcionoAtaque){
                    //aqui se debe restar la vida al personaje y eliminar del tablero de ser necesario, ademas de restar vida si lo amerita
                    Tanque t = getCuadrado(colAtaque, rowAtaque).getTanque();
                    Infanteria i = getCuadrado(colAtaque, rowAtaque).getInfanteria();
                    Artillero a = getCuadrado(colAtaque, rowAtaque).getArtillero();

                    Tanque tv = getCuadrado(colAtacado, rowAtacado).getTanque();
                    Infanteria iv = getCuadrado(colAtacado, rowAtacado).getInfanteria();
                    Artillero av = getCuadrado(colAtacado, rowAtacado).getArtillero();

                    int ataque = 0;
                    int vidaVictima = 0;

                    if (t != null && i == null && a == null){
                        //que es un tanque el que ataca
                        ataque = (int) t.getAtaque();
                    }
                    if (i != null && t == null && a == null){
                        //que es un infanteria el que ataca
                        ataque = (int)i.getAtaque();
                    }
                    if (a != null && i == null && t == null){
                        //que es un artillero el que ataca
                        ataque = (int)a.getAtaque();
                    }

                    if (tv != null && iv == null && av == null){
                        //que es un tanque el que es atacado
                        vidaVictima = tv.getVida();
                    }
                    if (iv != null && tv == null && av == null){
                        //que es un infanteria el que es atacado
                        vidaVictima = iv.getVida();
                    }
                    if (av != null && iv == null && tv == null){
                        //que es un artillero el que es atacado
                        vidaVictima = av.getVida();
                    }

                    System.out.println("Potencia de ataque del personaje: " + ataque);
                    System.out.println("Vida del personaje antes de ser atacado: " + vidaVictima);

                    if (atacar(colAtaque, rowAtaque, colAtacado, rowAtacado, 2, ataque, vidaVictima) <= 0 && atacar(colAtaque, rowAtaque, colAtacado, rowAtacado, 2, ataque, vidaVictima) != -99999){
                        //el personaje se murio
                        if (jugador == 1){
                            vidasJugador2--;
                            m[0][16].setText("Vidas: " + vidasJugador2);
                            //eliminar al personaje
                            String personaje = getCuadrado(colAtacado, rowAtacado).getPersonaje();
                            if(personaje=="INFANTERIA"){
                                getCuadrado(colAtacado, rowAtacado).setInfanteria(null);
                                getCuadrado(colAtacado, rowAtacado).setOcupado(false);
                                getCuadrado(colAtacado, rowAtacado).setPersonaje(null);
                                pintarCuadrado(colAtacado, rowAtacado, "GRAY");
                            }else if(personaje=="TANQUE"){
                                getCuadrado(colAtacado, rowAtacado).setTanque(null);
                                getCuadrado(colAtacado, rowAtacado).setOcupado(false);
                                getCuadrado(colAtacado, rowAtacado).setPersonaje(null);
                                pintarCuadrado(columna,renglon, "GRAY");
                            }else{
                                getCuadrado(colAtacado, rowAtacado).setArtillero(null);
                                getCuadrado(colAtacado, rowAtacado).setOcupado(false);
                                getCuadrado(colAtacado, rowAtacado).setPersonaje(null);
                                pintarCuadrado(colAtacado, rowAtacado, "GRAY");
                            }
                            gObservador.NuevasVidas(vidasJugador1,vidasJugador2);
                        } else {
                            vidasJugador1--;
                            l[0][2].setText("Vidas: " + vidasJugador1);
                            String personaje = getCuadrado(colAtacado, rowAtacado).getPersonaje();
                            if(personaje=="INFANTERIA"){
                                getCuadrado(colAtacado, rowAtacado).setInfanteria(null);
                                getCuadrado(colAtacado, rowAtacado).setOcupado(false);
                                getCuadrado(colAtacado, rowAtacado).setPersonaje(null);
                                pintarCuadrado(colAtacado, rowAtacado, "BROWN");
                            }else if(personaje=="TANQUE"){
                                getCuadrado(colAtacado, rowAtacado).setTanque(null);
                                getCuadrado(colAtacado, rowAtacado).setOcupado(false);
                                getCuadrado(colAtacado, rowAtacado).setPersonaje(null);
                                pintarCuadrado(colAtacado, rowAtacado, "BROWN");
                            }else{
                                getCuadrado(colAtacado, rowAtacado).setArtillero(null);
                                getCuadrado(colAtacado, rowAtacado).setOcupado(false);
                                getCuadrado(colAtacado, rowAtacado).setPersonaje(null);
                                pintarCuadrado(colAtacado, rowAtacado, "BROWN");
                            }
                            gObservador.NuevasVidas(vidasJugador1,vidasJugador2);
                        }
                    } else {
                        //El personaje no se murio, actualizar vida
                        System.out.println("Restante de vida del personaje atacado: " + (vidaVictima - ataque));
                        int restante = vidaVictima-ataque;
                        String personaje = getCuadrado(colAtacado, rowAtacado).getPersonaje();
                        if(personaje=="INFANTERIA"){
                            getCuadrado(colAtacado, rowAtacado).getInfanteria().setVida(restante);
                            System.out.println(getCuadrado(colAtacado, rowAtacado).getInfanteria().getVida() + "vida");
                        }else if(personaje=="TANQUE"){
                            getCuadrado(colAtacado, rowAtacado).getTanque().setVida(restante);
                            System.out.println(getCuadrado(colAtacado, rowAtacado).getTanque().getVida() + "vida");
                        }else{
                            getCuadrado(colAtacado, rowAtacado).getArtillero().setVida(restante);
                            System.out.println(getCuadrado(colAtacado, rowAtacado).getArtillero().getVida() + "vida");
                        }
                    }
                }
            }
        }
    }

    /**
     * Funcion simplificada para pintar un cuadro en la parte logica y en el UI
     *
     * @param column La columna es una letra que indica el numero de la columna del cuadro a pintar
     * @param row    El renglon es un numero que indica donde se encuentra el cuadro a pintar. Empieza en 0, termina en 19
     * @param color  El color es un string en mayuscula que indica que color debe ser aplicado al cuadro a pintar
     */
    static public void pintarCuadrado(String column, int row, String color) {
        JLabel panelPressed = getPanel(column, row);
        switch (color) {
            case "BROWN" -> {
                panelPressed.setIcon(iconBrown);
                ((Cuadrado) squares[buscarColumna(column)][row]).setSquareColor(ColorCuadrado.Brown);//Cambia el color del cuadrado del tablero de la lógica
                if (!empezando && turno == 0) {
                    textoBu3.setText("2.Tira los dados.");
                }

            }
            case "GRAY" -> {
                panelPressed.setIcon(iconGray);
                ((Cuadrado) squares[buscarColumna(column)][row]).setSquareColor(ColorCuadrado.Gray);
                if (!empezando && turno == 0) {
                    textoBu3.setText("2.Tira los dados.");
                }
            }
            default -> {
                panelPressed.setIcon(iconWhite);
                ((Cuadrado) squares[buscarColumna(column)][row]).setSquareColor(ColorCuadrado.White);//Cambia el color del cuadrado del tablero de la lógica
            }
        }
    }
    /**
     * Según una casilla, esta función retorna un JPanel, que es un cuadro en formato de UI
     *
     * @param row    que refiere a la letra
     * @param column que refiere al numero
     * @return y retorna el JLabel
     */
    static public JLabel getPanel(String column, int row) {
        //String col = Character.toString(column);
        JLabel panelPressed = null;
        panelPressed = label[buscarColumna(column)][row];
        return panelPressed;
    }

    /**
     * Segun la casilla ingresada como parametro, retorna el color de esa casilla. Hace referencia unicamente a la parte logica.
     *
     * @param column La letra de la columna en la que se encuentra la casilla eje
     * @param row    El renglon de la casilla eje
     * @return Retorna el objeto color convertido en String.
     */
    static public String getColorCasilla(String column, int row) {
        int noColumna = buscarColumna(column);
        if (noColumna >= 0 && noColumna <= 19) {
            if (row >= 0 && row <= 19) {
                return ((Cuadrado) squares[noColumna][row]).getSquareColor().toString();
            } else
                return "No existe";
        } else
            return "No existe";
    }

    /**
     * Retorna el valor numerico de las letras contempladas en el tablero.
     *
     * @param letra Ingresa la letra
     * @return Retorna int de la letra en el abecedario
     */
    public static int buscarColumna(String letra) {
        String[] array = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
                "S", "T"};
        int numLetra = -1;
        for (int j = 0; j < 20; j++) {
            if (array[j].equals(letra)) {
                numLetra = j;
            }
        }
        return numLetra;
    }

    /**
     * Funcion para incializar los cuadros donde van a empezar ambos jugadores,
     * Es necesario para que la validacion del perimetro permita colocar la figura.
     * Se ejecuta al iniciar el juego (linea 60)
     */
    public void inicializarCuadros() {
        pintarCuadrado("B", 0, "BROWN");
        pintarCuadrado("S", 19, "GRAY");
    }

    /**
     * Funcion para obtener un objeto cuadrado, segun su ubicacion
     * @param column Ingresa la columna en forma de letra
     * @param row Ingresa el renglon en forma de int
     * @return Retorna el cuadrado en esa ubicacion
     */
    static public Cuadrado getCuadrado(String column, int row){
        return ((Cuadrado) squares[buscarColumna(column)][row]);
    }

    /**
     * Get y sets para establecer en esta clase la prefa y la orientacion seleccionadas y enviarselas al gestorPrefas
     *
     * @return Debe actualizar las variables estaticas definidas arriba
     */
    public static String getPrefaSeleccionada() {
        return prefaSeleccionada;
    }
    public static void setPrefaSeleccionada(String prefaSeleccionada) {
        JuegoTablero.prefaSeleccionada = prefaSeleccionada;
    }

    public static int getFormaSeleccionada() {
        return formaSeleccionada;
    }
    public static void setFormaSeleccionada(int formaSeleccionada) {
        JuegoTablero.formaSeleccionada = formaSeleccionada;
    }

    public static void inicializarMementoDados() {
            JuegoDados.gMemento1= new Gestor_Memento1(0,0,0,0,0,0,0,0,0,0,0);
            JuegoDados.gMemento2= new Gestor_Memento2(0,0,0,0,0,0,0,0,0,0,0);
    }

    public static void cambioPersonaje(String p){
        personajeAgregar=p;
    }

    public int atacar(String columnaAtaque, int renglonAtaque, String columnaVictima, int renglonVictima, int rango, int puntosAtaque, int vidaVictima){
        if (enRango(columnaAtaque, renglonAtaque, columnaVictima, renglonVictima, rango)){
            return vidaVictima - puntosAtaque;
        } else {
            new PopUp("La victima no está dentro del rango de ataque");
            return -99999;
        }
    }
    public boolean enRango(String columnaAtaque, int renglonAtaque, String columnaVictima, int renglonVictima, int rango){
        if (JuegoTablero.buscarColumna(columnaAtaque) - JuegoTablero.buscarColumna(columnaVictima) <= rango   &&   JuegoTablero.buscarColumna(columnaAtaque) - JuegoTablero.buscarColumna(columnaVictima) >= (rango * -1)){
            if (renglonAtaque - renglonVictima <= rango  &&  renglonAtaque - renglonVictima >= (rango * -1)){
                return true;
            } else
                return false;
        } else {
            return false;
        }
    }

    public static void gameOver(String ganador){
        new PopUp("Juego terminado. ¡Felicidades "+ganador+" por ganar!");

    }

    public static void colocarPersonaje(String columna, int renglon){
        if (jugador == 1) {
                if (!getCuadrado(columna, renglon).getOcupado()) {
                    pintarPrefaJugador(columna, renglon);//Esta funcion debe estar en el proxy
                } else {
                    new PopUp("No se puede, primero debe de mover el personaje que tiene en el punto de salida.");
                }

        } else {
                if (!getCuadrado(columna, renglon).getOcupado()) {
                    pintarPrefaJugador(columna, renglon);//Esta funcion debe estar en el proxy
                } else {
                    new PopUp("No se puede, primero debe de mover el personaje que tiene en el punto de salida.");
                }
        }
    }
    public static void moverPersonaje(int mov, String columna, int renglon){
        if (jugador == 1) {
            if (!getCuadrado(columna, renglon).getOcupado()) {
                pintarPrefaJugador(columna, renglon);//Esta funcion debe estar en el proxy
            } else {
                new PopUp("No se puede, primero debe de mover el personaje que tiene en el punto de salida.");
            }

        } else {
            if (!getCuadrado(columna, renglon).getOcupado()) {
                pintarPrefaJugador(columna, renglon);//Esta funcion debe estar en el proxy
            } else {
                new PopUp("No se puede, primero debe de mover el personaje que tiene en el punto de salida.");
            }
        }
    }
    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        empezando = false;
        if (e.getSource() == btnPrefas) {
            fachada.llamarUI();
        }
        if (e.getSource() == botonDados) {
            try {
                new JuegoDados();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if (e.getSource() == btnCofre1) {
            try {
                new JuegoCofre1();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if (e.getSource() == btnCofre2) {
            try {
                new JuegoCofre2();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if (e.getSource() == btnTurno) {
            if(jugador==1){
                jugador=2;
                m[0][17].setBackground(new Color(77, 191, 99));
                l[0][1].setBackground(new Color(229, 77, 65));
                turno = 0;
                textoBu3.setText("1.Escoje una prefa.");
            }else{
                jugador=1;
                l[0][1].setBackground(new Color(77, 191, 99));
                m[0][17].setBackground(new Color(229, 77, 65));
                turno = 0;
                textoBu3.setText("1.Escoje una prefa.");
            }
        }
    }

}