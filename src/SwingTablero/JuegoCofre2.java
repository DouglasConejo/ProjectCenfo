package SwingTablero;

import FabricaAbstracta.gestor.Fabrica_de_Dados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;


public class JuegoCofre2 extends JFrame implements MouseListener, ActionListener {
	JLabel b1;
	Fabrica_de_Dados gDados=new Fabrica_de_Dados();
	ImageIcon dice1=new ImageIcon(this.getClass().getResource("../resources/dados/dice1.png"));
	ImageIcon dice2=new ImageIcon(this.getClass().getResource("../resources/dados/dice2.png"));
	ImageIcon dice3=new ImageIcon(this.getClass().getResource("../resources/dados/dice3.png"));
	ImageIcon dice4=new ImageIcon(this.getClass().getResource("../resources/dados/dice4.png"));
	ImageIcon dice5=new ImageIcon(this.getClass().getResource("../resources/dados/dice5.png"));
	ImageIcon dice6=new ImageIcon(this.getClass().getResource("../resources/dados/dice6.png"));
	ImageIcon infanteria=new ImageIcon(this.getClass().getResource("../resources/dados/infanteria.png"));
	ImageIcon artillero=new ImageIcon(this.getClass().getResource("../resources/dados/artillero.png"));
	ImageIcon tanque=new ImageIcon(this.getClass().getResource("../resources/dados/tanque.png"));
	ImageIcon ataque=new ImageIcon(this.getClass().getResource("../resources/dados/ataque.png"));
	ImageIcon ataqueEspecial=new ImageIcon(this.getClass().getResource("../resources/dados/ataqueEspecial.png"));
	JLabel labelTanque;
	JLabel labelArtillero;
	JLabel labelInfanteria;
	JLabel labelAtaque;
	JLabel labelAtaqueEspecial;
	JLabel labelDice1;
	JLabel labelDice2;
	JLabel labelDice3;
	JLabel labelDice4;
	JLabel labelDice5;
	JLabel labelDice6;
	JLabel labelTanqueT;
	JLabel labelArtilleroT;
	JLabel labelInfanteriaT;
	JLabel labelAtaqueT;
	JLabel labelAtaqueEspecialT;
	JLabel labelDice1T;
	JLabel labelDice2T;
	JLabel labelDice3T;
	JLabel labelDice4T;
	JLabel labelDice5T;
	JLabel labelDice6T;
	JLabel labe;
	JButton bTanque;
	JButton bArtillero;
	JButton bInfanteria;
	JButton bAtaque;
	JButton bAtaqueEspecial;
	JButton bDice1;
	JButton bDice2;
	JButton bDice3;
	JButton bDice4;
	JButton bDice5;
	JButton bDice6;

	public JuegoCofre2() throws IOException
	{
		JuegoTablero.textoBu3.setText("4. Escoje tu jugada.");
		setSize(1100,800);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());
		setBackground(Color.gray);
		b1=new JLabel("Cofre");
		b1.setPreferredSize(new Dimension(500, 40));
		b1.setFont(new Font("Arial",Font.BOLD,22));
		b1.setLayout(null);
		b1.setBounds(500,30,240,40);
		add(b1);

		labelInfanteriaT= new JLabel("Disponibles:"+JuegoDados.gMemento2.Obtener_Infanteria());
		labelInfanteriaT.setLayout(null);
		labelInfanteriaT.setBounds(250,8,170,170);
		add(labelInfanteriaT);
		labelInfanteria= new JLabel(infanteria);
		labelInfanteria.setBounds(250,100,170,170);
		add(labelInfanteria);
		bInfanteria= new JButton("Usar");
		bInfanteria.setBounds(250,275,70,27);
		bInfanteria.addActionListener(this);
		add(bInfanteria);

		labelArtilleroT= new JLabel("Disponibles:"+JuegoDados.gMemento2.Obtener_Artillero());
		labelArtilleroT.setLayout(null);
		labelArtilleroT.setBounds(460,8,170,170);
		add(labelArtilleroT);
		labelArtillero= new JLabel(artillero);
		labelArtillero.setBounds(460,100,170,170);
		add(labelArtillero);
		bArtillero= new JButton("Usar");
		bArtillero.setBounds(460,275,70,27);
		bArtillero.addActionListener(this);
		add(bArtillero);

		labelTanqueT= new JLabel("Disponibles:"+JuegoDados.gMemento2.Obtener_Tanque());
		labelTanqueT.setLayout(null);
		labelTanqueT.setBounds(670,8,170,170);
		add(labelTanqueT);
		labelTanque= new JLabel(tanque);
		labelTanque.setLayout(null);
		labelTanque.setBounds(670,100,170,170);
		add(labelTanque);
		bTanque= new JButton("Usar");
		bTanque.setBounds(670,275,70,27);
		bTanque.addActionListener(this);
		add(bTanque);

		labelAtaqueT= new JLabel("Disponibles:"+JuegoDados.gMemento2.Obtener_ataque());
		labelAtaqueT.setLayout(null);
		labelAtaqueT.setBounds(390,238,170,170);
		add(labelAtaqueT);
		labelAtaque= new JLabel(ataque);
		labelAtaque.setLayout(null);
		labelAtaque.setBounds(390,330,170,170);
		add(labelAtaque);
		bAtaque= new JButton("Usar");
		bAtaque.setLayout(null);
		bAtaque.setBounds(390,505,70,27);
		bAtaque.addActionListener(this);
		add(bAtaque);

		labelAtaqueEspecialT= new JLabel("Disponibles:"+JuegoDados.gMemento2.Obtener_ataqueEspecial());
		labelAtaqueEspecialT.setLayout(null);
		labelAtaqueEspecialT.setBounds(600,238,170,170);
		add(labelAtaqueEspecialT);
		labelAtaqueEspecial= new JLabel(ataqueEspecial);
		labelAtaqueEspecial.setLayout(null);
		labelAtaqueEspecial.setBounds(600,330,170,170);
		add(labelAtaqueEspecial);
		bAtaqueEspecial= new JButton("Usar");
		bAtaqueEspecial.setLayout(null);
		bAtaqueEspecial.setBounds(600,505,70,27);
		bAtaqueEspecial.addActionListener(this);
		add(bAtaqueEspecial);

		labelDice1T= new JLabel("Disponibles:"+JuegoDados.gMemento2.Obtener_Movimiento1());
		labelDice1T.setLayout(null);
		labelDice1T.setBounds(10,460,170,170);
		add(labelDice1T);
		labelDice1= new JLabel(dice1);
		labelDice1.setLayout(null);
		labelDice1.setBounds(10,555,170,170);
		add(labelDice1);
		bDice1= new JButton("Usar");
		bDice1.setLayout(null);
		bDice1.setBounds(10,730,70,27);
		bDice1.addActionListener(this);
		add(bDice1);

		labelDice2T= new JLabel("Disponibles:"+JuegoDados.gMemento2.Obtener_Movimiento2());
		labelDice2T.setLayout(null);
		labelDice2T.setBounds(190,460,170,170);
		add(labelDice2T);
		labelDice2= new JLabel(dice2);
		labelDice2.setLayout(null);
		labelDice2.setBounds(190,555,170,170);
		add(labelDice2);
		bDice2= new JButton("Usar");
		bDice2.setLayout(null);
		bDice2.setBounds(190,730,70,27);
		bDice2.addActionListener(this);
		add(bDice2);

		labelDice3T= new JLabel("Disponibles:"+JuegoDados.gMemento2.Obtener_Movimiento3());
		labelDice3T.setLayout(null);
		labelDice3T.setBounds(370,460,170,170);
		add(labelDice3T);
		labelDice3= new JLabel(dice3);
		labelDice3.setLayout(null);
		labelDice3.setBounds(370,555,170,170);
		add(labelDice3);
		bDice3= new JButton("Usar");
		bDice3.setLayout(null);
		bDice3.setBounds(370,730,70,27);
		bDice3.addActionListener(this);
		add(bDice3);

		labelDice4T= new JLabel("Disponibles:"+JuegoDados.gMemento2.Obtener_Movimiento4());
		labelDice4T.setLayout(null);
		labelDice4T.setBounds(550,460,170,170);
		add(labelDice4T);
		labelDice4= new JLabel(dice4);
		labelDice4.setLayout(null);
		labelDice4.setBounds(550,555,170,170);
		add(labelDice4);
		bDice4= new JButton("Usar");
		bDice4.setLayout(null);
		bDice4.setBounds(550,730,70,27);
		bDice4.addActionListener(this);
		add(bDice4);

		labelDice5T= new JLabel("Disponibles:"+JuegoDados.gMemento2.Obtener_Movimiento5());
		labelDice5T.setLayout(null);
		labelDice5T.setBounds(730,460,170,170);
		add(labelDice5T);
		labelDice5= new JLabel(dice5);
		labelDice5.setLayout(null);
		labelDice5.setBounds(730,555,170,170);
		add(labelDice5);
		bDice5= new JButton("Usar");
		bDice5.setLayout(null);
		bDice5.setBounds(730,730,70,27);
		bDice5.addActionListener(this);
		add(bDice5);

		labelDice6T= new JLabel("Disponibles:"+JuegoDados.gMemento2.Obtener_Movimiento6());
		labelDice6T.setLayout(null);
		labelDice6T.setBounds(910,460,170,170);
		add(labelDice6T);
		labelDice6= new JLabel(dice6);
		labelDice6.setLayout(null);
		labelDice6.setBounds(910,555,170,170);
		add(labelDice6);
		bDice6= new JButton("Usar");
		bDice6.setLayout(null);
		bDice6.setBounds(910,730,70,27);
		bDice6.addActionListener(this);
		add(bDice6);


		labe= new JLabel();
		labe.setLayout(null);
		labe.setBounds(420,120,170,170);
		add(labe);

		// Just for refresh :) Not optional!
		setSize(1100,800);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bInfanteria) {
			int nInfanteria=JuegoDados.gMemento2.Obtener_Infanteria();
			if(nInfanteria>=2){
				JuegoDados.gMemento2.Cambiar_PerInfanteria(nInfanteria-2);
				JuegoTablero.cambioPersonaje("INFANTERIA");
				JuegoTablero.colocarPersonaje("S",19);
				this.setVisible(false);
			}else{
				new PopUp("No posee suficientes dados.");
			}
		}
		if (e.getSource() == bArtillero) {
			int n=JuegoDados.gMemento2.Obtener_Artillero();
			if(n>=3){
				JuegoDados.gMemento2.Cambiar_PerArtilleros(n-3);
				JuegoTablero.cambioPersonaje("ARTILLERO");
				JuegoTablero.colocarPersonaje("S",19);
				this.setVisible(false);
			}else{
				new PopUp("No posee suficientes dados.");
			}
		}
		if (e.getSource() == bTanque) {
			int n=JuegoDados.gMemento2.Obtener_Tanque();
			if(n>=4){
				JuegoDados.gMemento2.Cambiar_PerTanque(n-4);
				JuegoTablero.cambioPersonaje("TANQUE");
				JuegoTablero.colocarPersonaje("S",19);
				this.setVisible(false);
			}else{
				new PopUp("No posee suficientes dados.");
			}
		}
		if (e.getSource() == bAtaque) {
			int n=JuegoDados.gMemento2.Obtener_ataque();
			if(n>=1){
				JuegoDados.gMemento2.Cambiar_PerAtaque(n-1);
				this.setVisible(false);
				JuegoTablero.turno = 3;
			}else{
				new PopUp("No posee suficientes dados.");
			}
		}
		if (e.getSource() == bAtaqueEspecial) {
			int n=JuegoDados.gMemento2.Obtener_ataqueEspecial();
			if(n>=1){
				JuegoDados.gMemento2.Cambiar_PerAtaqueEspecial(n-1);
				this.setVisible(false);
			}else{
				new PopUp("No posee suficientes dados.");
			}
		}
		if (e.getSource() == bDice1) {
			int n=JuegoDados.gMemento2.Obtener_Movimiento1();
			if(n>=1){
				JuegoDados.gMemento2.Cambiar_PerMovimiento1(n-1);
				this.setVisible(false);
				JuegoTablero.movADar=1;
				JuegoTablero.turno=1;
				JuegoTablero.movDado=0;
				new PopUp("Escoje el personaje y empieza a moverlo.");
			}else{
				new PopUp("No posee suficientes dados.");
			}
		}
		if (e.getSource() == bDice2) {
			int n=JuegoDados.gMemento2.Obtener_Movimiento2();
			if(n>=1){
				JuegoDados.gMemento2.Cambiar_PerMovimiento2(n-1);
				this.setVisible(false);
				JuegoTablero.movADar=2;
				JuegoTablero.turno=1;
				JuegoTablero.movDado=0;
				new PopUp("Escoje el personaje y empieza a moverlo.");
			}else{
				new PopUp("No posee suficientes dados.");
			}
		}
		if (e.getSource() == bDice3) {
			int n=JuegoDados.gMemento2.Obtener_Movimiento3();
			if(n>=1){
				JuegoDados.gMemento2.Cambiar_PerMovimiento3(n-1);
				this.setVisible(false);
				JuegoTablero.movADar=3;
				JuegoTablero.turno=1;
				JuegoTablero.movDado=0;
				new PopUp("Escoje el personaje y empieza a moverlo.");
			}else{
				new PopUp("No posee suficientes dados.");
			}
		}
		if (e.getSource() == bDice4) {
			int n=JuegoDados.gMemento2.Obtener_Movimiento4();
			if(n>=1){
				JuegoDados.gMemento2.Cambiar_PerMovimiento4(n-1);
				this.setVisible(false);
				JuegoTablero.movADar=4;
				JuegoTablero.turno=1;
				JuegoTablero.movDado=0;
				new PopUp("Escoje el personaje y empieza a moverlo.");
			}else{
				new PopUp("No posee suficientes dados.");
			}
		}
		if (e.getSource() == bDice5) {
			int n=JuegoDados.gMemento2.Obtener_Movimiento5();
			if(n>=1){
				JuegoDados.gMemento2.Cambiar_PerMovimiento5(n-1);
				this.setVisible(false);
				JuegoTablero.movADar=5;
				JuegoTablero.turno=1;
				JuegoTablero.movDado=0;
				new PopUp("Escoje el personaje y empieza a moverlo.");
			}else{
				new PopUp("No posee suficientes dados.");
			}
		}
		if (e.getSource() == bDice6) {
			int n=JuegoDados.gMemento2.Obtener_Movimiento6();
			if(n>=1){
				JuegoDados.gMemento2.Cambiar_PerMovimiento6(n-1);
				this.setVisible(false);
				JuegoTablero.movADar=6;
				JuegoTablero.turno=1;
				JuegoTablero.movDado=0;
				new PopUp("Escoje el personaje y empieza a moverlo.");
			}else{
				new PopUp("No posee suficientes dados.");
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
