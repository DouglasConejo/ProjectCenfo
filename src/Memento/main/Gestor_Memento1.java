package Memento.main;

import Memento.memento.Caretaker;
import Memento.memento.Originator;

public class Gestor_Memento1 {
    private Originator Creador;
    private Caretaker Vigilante;

    public Gestor_Memento1(int dadoInfanteria, int dadoArtillero, int dadoTanque, int dadoMovimiento1, int dadoMovimiento2, int dadoMovimiento3, int dadoMovimiento4, int dadoMovimiento5, int dadoMovimiento6, int dadoAtaque, int ataqueEspecial) {
        Creador = new Originator(dadoInfanteria, dadoArtillero,dadoTanque,dadoMovimiento1,dadoMovimiento2,dadoMovimiento3,dadoMovimiento4,dadoMovimiento5,dadoMovimiento6,dadoAtaque,ataqueEspecial);
        Vigilante = new Caretaker();
        Actualizar_Personaje();
    }
    public void Actualizar_Personaje() {
        Vigilante.setMemento( Creador.createMemento() );
    }
    //Artilleros


    public int Obtener_Artillero() {
        return Creador.getDadoArtillero();
    }

    public void Cambiar_PerArtilleros(int pdadosArtillero) {
        Creador.setDadoArtillero(pdadosArtillero);
    }

    //________________________________________________________


    public int Obtener_Infanteria() {
        return Creador.getDadoInfanteria();
    }
    public void Cambiar_PerInfanteria(int pdadosInfanteria) {
        Creador.setDadoInfanteria(pdadosInfanteria);
    }

    //________________________________________________________

    public int Obtener_Tanque() {
        return Creador.getDadoTanque();
    }
    public void Cambiar_PerTanque(int pdadosTanque) {
        Creador.setDadoTanque(pdadosTanque);
    }
    //________________________________________________________

    public int Obtener_ataque() {
        return Creador.getDadoAtaque();
    }
    public void Cambiar_PerAtaque(int pdadosAtaque) {
        Creador.setDadoAtaque(pdadosAtaque);
    }
    //________________________________________________________

    public int Obtener_ataqueEspecial() {
        return Creador.getAtaqueEspecial();
    }
    public void Cambiar_PerAtaqueEspecial(int pdadosAtaqueEspecial) {
        Creador.setAtaqueEspecial(pdadosAtaqueEspecial);
    }
    //________________________________________________________


    public int Obtener_Movimiento1() {
        return Creador.getDadoMovimiento1();
    }
    public void Cambiar_PerMovimiento1(int pdadosMovimientos) {
        Creador.setDadoMovimiento1(pdadosMovimientos);
    }
    //________________________________________________________



    public int Obtener_Movimiento2() {
        return Creador.getDadoMovimiento2();
    }
    public void Cambiar_PerMovimiento2(int pdadosMovimientos) {
        Creador.setDadoMovimiento2(pdadosMovimientos);
    }
    //________________________________________________________



    public int Obtener_Movimiento3() {
        return Creador.getDadoMovimiento3();
    }
    public void Cambiar_PerMovimiento3(int pdadosMovimientos) {
        Creador.setDadoMovimiento3(pdadosMovimientos);
    }
    //________________________________________________________
    //________________________________________________________



    public int Obtener_Movimiento4() {
        return Creador.getDadoMovimiento4();
    }
    public void Cambiar_PerMovimiento4(int pdadosMovimientos) {
        Creador.setDadoMovimiento4(pdadosMovimientos);
    }
    //________________________________________________________
    //________________________________________________________


    public int Obtener_Movimiento5() {
        return Creador.getDadoMovimiento5();
    }
    public void Cambiar_PerMovimiento5(int pdadosMovimientos) {
        Creador.setDadoMovimiento5(pdadosMovimientos);
    }
    //________________________________________________________
    //________________________________________________________



    public int Obtener_Movimiento6() {
        return Creador.getDadoMovimiento6();
    }
    public void Cambiar_PerMovimiento6(int pdadosMovimientos) {
        Creador.setDadoMovimiento6(pdadosMovimientos);
    }
    //________________________________________________________
}

