package Memento.memento;

public class Memento {
     private int dadoInfanteria;
    private int dadoArtillero;
    private int dadoTanque;

    private int dadoMovimiento1;
    private int dadoMovimiento2;
    private int dadoMovimiento3;
    private int dadoMovimiento4;
    private int dadoMovimiento5;
    private int dadoMovimiento6;
    private int dadoAtaque;
    private int ataqueEspecial;

    public Memento(int dadoInfanteria, int dadoArtillero, int dadoTanque, int dadoMovimiento1, int dadoMovimiento2, int dadoMovimiento3, int dadoMovimiento4, int dadoMovimiento5, int dadoMovimiento6, int dadoAtaque, int ataqueEspecial) {
        this.dadoInfanteria = dadoInfanteria;
        this.dadoArtillero = dadoArtillero;
        this.dadoTanque = dadoTanque;
        this.dadoMovimiento1 = dadoMovimiento1;
        this.dadoMovimiento2 = dadoMovimiento2;
        this.dadoMovimiento3 = dadoMovimiento3;
        this.dadoMovimiento4 = dadoMovimiento4;
        this.dadoMovimiento5 = dadoMovimiento5;
        this.dadoMovimiento6 = dadoMovimiento6;
        this.dadoAtaque=dadoAtaque;
        this.ataqueEspecial=ataqueEspecial;
    }

    public int getDadoInfanteria() {
        return dadoInfanteria;
    }

    public void setDadoInfanteria(int dadoInfanteria) {
        this.dadoInfanteria = dadoInfanteria;
    }

    public int getDadoArtillero() {
        return dadoArtillero;
    }

    public void setDadoArtillero(int dadoArtillero) {
        this.dadoArtillero = dadoArtillero;
    }

    public int getDadoTanque() {
        return dadoTanque;
    }

    public void setDadoTanque(int dadoTanque) {
        this.dadoTanque = dadoTanque;
    }

    public int getDadoMovimiento1() {
        return dadoMovimiento1;
    }

    public void setDadoMovimiento1(int dadoMovimiento1) {
        this.dadoMovimiento1 = dadoMovimiento1;
    }

    public int getDadoMovimiento2() {
        return dadoMovimiento2;
    }

    public void setDadoMovimiento2(int dadoMovimiento2) {
        this.dadoMovimiento2 = dadoMovimiento2;
    }

    public int getDadoMovimiento3() {
        return dadoMovimiento3;
    }

    public void setDadoMovimiento3(int dadoMovimiento3) {
        this.dadoMovimiento3 = dadoMovimiento3;
    }

    public int getDadoMovimiento4() {
        return dadoMovimiento4;
    }

    public void setDadoMovimiento4(int dadoMovimiento4) {
        this.dadoMovimiento4 = dadoMovimiento4;
    }

    public int getDadoMovimiento5() {
        return dadoMovimiento5;
    }

    public void setDadoMovimiento5(int dadoMovimiento5) {
        this.dadoMovimiento5 = dadoMovimiento5;
    }

    public int getDadoMovimiento6() {
        return dadoMovimiento6;
    }

    public void setDadoMovimiento6(int dadoMovimiento6) {
        this.dadoMovimiento6 = dadoMovimiento6;
    }

    public int getDadoAtaque() {
        return dadoAtaque;
    }

    public void setDadoAtaque(int dadoAtaque) {
        this.dadoAtaque = dadoAtaque;
    }
    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }
}

