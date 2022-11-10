package SwingTablero;

import java.awt.*;
import javax.swing.*;

import FabricaAbstracta.gestor.Fabrica_de_Dados;
import Memento.main.Gestor_Memento1;
import Memento.main.Gestor_Memento2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class JuegoDados extends JFrame {
	JButton b1;
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
	ImageIcon movimiento=new ImageIcon(this.getClass().getResource("../resources/dados/movimiento.png"));
	ImageIcon dadoAccion=new ImageIcon(this.getClass().getResource("../resources/dados/dadoAccion.png"));
	ImageIcon dadoInvocacion=new ImageIcon(this.getClass().getResource("../resources/dados/dadoInvocacion.png"));
	ImageIcon dadoMovimiento=new ImageIcon(this.getClass().getResource("../resources/dados/dadoMovimiento.png"));
	JLabel labe;
	JLabel label;
	JLabel accionLabel;
	static Gestor_Memento1 gMemento1;
	static Gestor_Memento2 gMemento2;
	static int dadosTirados;

	public JuegoDados() throws IOException
	{
		dadosTirados=1;
		setSize(1000,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("../resources/dados/FondoDados.jpeg"))));
		b1=new JButton("Tirar los dados");
		b1.setPreferredSize(new Dimension(155, 40));
		b1.setFont(new Font("Arial",Font.BOLD,17));
		b1.setLayout(null);
		b1.setBounds(220,40,155,40);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dadosTirados<=3) {
					String accion = gDados.procesarFuncion(1);
					if (accion == "Movimiento") {
						accionLabel.setIcon(movimiento);
					} else if (accion == "Ataque") {
						accionLabel.setIcon(ataque);
						if(JuegoTablero.jugador==1) {
							gMemento1.Cambiar_PerAtaque(gMemento1.Obtener_ataque()+1);
						}else{
							gMemento2.Cambiar_PerAtaque(gMemento2.Obtener_ataque()+1);
						}
					} else if (accion == "AtaqueEspecial") {
						accionLabel.setIcon(ataqueEspecial);
						if(JuegoTablero.jugador==1) {
							gMemento1.Cambiar_PerAtaqueEspecial(gMemento1.Obtener_ataqueEspecial()+1);
						}else{
							gMemento2.Cambiar_PerAtaqueEspecial(gMemento2.Obtener_ataqueEspecial()+1);
						}
					}
					String invocacion = gDados.procesarFuncion(2);
					if (invocacion == "Infanteria") {
						label.setIcon(infanteria);
						if(JuegoTablero.jugador==1) {
							gMemento1.Cambiar_PerInfanteria(gMemento1.Obtener_Infanteria()+1);
						}else{
							gMemento2.Cambiar_PerInfanteria(gMemento2.Obtener_Infanteria()+1);
						}
					} else if (invocacion == "Artilleros") {
						label.setIcon(artillero);
						if(JuegoTablero.jugador==1) {
							gMemento1.Cambiar_PerArtilleros(gMemento1.Obtener_Artillero()+1);
						}else{
							gMemento2.Cambiar_PerArtilleros(gMemento2.Obtener_Artillero()+1);
						}
					} else if (invocacion == "Tanque") {
						label.setIcon(tanque);
						if(JuegoTablero.jugador==1) {
							gMemento1.Cambiar_PerTanque(gMemento1.Obtener_Tanque()+1);
						}else{
							gMemento2.Cambiar_PerTanque(gMemento2.Obtener_Tanque()+1);
						}
					}
					if (accion == "Movimiento") {
						String movimiento = gDados.procesarFuncion(3);
						if (movimiento == "1") {
							labe.setIcon(dice1);
							if(JuegoTablero.jugador==1) {
								gMemento1.Cambiar_PerMovimiento1(gMemento1.Obtener_Movimiento1()+1);
							}else{
								gMemento2.Cambiar_PerMovimiento1(gMemento2.Obtener_Movimiento1()+1);
							}
						} else if (movimiento == "2") {
							labe.setIcon(dice2);
							if(JuegoTablero.jugador==1) {
								gMemento1.Cambiar_PerMovimiento2(gMemento1.Obtener_Movimiento2()+1);
							}else{
								gMemento2.Cambiar_PerMovimiento2(gMemento2.Obtener_Movimiento2()+1);
							}
						} else if (movimiento == "3") {
							labe.setIcon(dice3);
							if(JuegoTablero.jugador==1) {
								gMemento1.Cambiar_PerMovimiento3(gMemento1.Obtener_Movimiento3()+1);
							}else{
								gMemento2.Cambiar_PerMovimiento3(gMemento2.Obtener_Movimiento3()+1);
							}
						} else if (movimiento == "4") {
							labe.setIcon(dice4);
							if(JuegoTablero.jugador==1) {
								gMemento1.Cambiar_PerMovimiento4(gMemento1.Obtener_Movimiento4()+1);
							}else{
								gMemento2.Cambiar_PerMovimiento4(gMemento2.Obtener_Movimiento4()+1);
							}
						} else if (movimiento == "5") {
							labe.setIcon(dice5);
							if(JuegoTablero.jugador==1) {
								gMemento1.Cambiar_PerMovimiento5(gMemento1.Obtener_Movimiento5()+1);
							}else{
								gMemento2.Cambiar_PerMovimiento5(gMemento2.Obtener_Movimiento5()+1);
							}
						} else if (movimiento == "6") {
							labe.setIcon(dice6);
							if(JuegoTablero.jugador==1) {
								gMemento1.Cambiar_PerMovimiento6(gMemento1.Obtener_Movimiento6()+1);
							}else{
								gMemento2.Cambiar_PerMovimiento6(gMemento2.Obtener_Movimiento6()+1);
							}
						}
					}
					dadosTirados++;
					JuegoTablero.textoBu3.setText("Dados guardados. 3. Revisa el cofre.");
				}
			}
		});
		add(b1);
		label= new JLabel(dadoInvocacion);
		label.setBounds(20,120,170,170);
		add(label);
		accionLabel= new JLabel(dadoAccion);
		accionLabel.setBounds(220,120,170,170);
		add(accionLabel);
		labe= new JLabel(dadoMovimiento);
		labe.setBounds(420,120,170,170);
		add(labe);
		// Just for refresh :) Not optional!
		setSize(630,400);

	}
}
