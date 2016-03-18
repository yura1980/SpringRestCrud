package com.beingjavaguys.model;

/**
 * Created by yuri on 18.03.16.
 */
public class Change {

    private boolean fio;
    private boolean oplata;
    private boolean pasp;
    private boolean rabota;
    private boolean adres;
    private boolean obshee;
    private boolean profvr;

    public Change() {
    }

    public boolean isFio() {
        return fio;
    }

    public void setFio(boolean fio) {
        this.fio = fio;
    }

    public boolean isOplata() {
        return oplata;
    }

    public void setOplata(boolean oplata) {
        this.oplata = oplata;
    }

    public boolean isPasp() {
        return pasp;
    }

    public void setPasp(boolean pasp) {
        this.pasp = pasp;
    }

    public boolean isRabota() {
        return rabota;
    }

    public void setRabota(boolean rabota) {
        this.rabota = rabota;
    }

    public boolean isAdres() {
        return adres;
    }

    public void setAdres(boolean adres) {
        this.adres = adres;
    }

    public boolean isObshee() {
        return obshee;
    }

    public void setObshee(boolean obshee) {
        this.obshee = obshee;
    }

    public boolean isProfvr() {
        return profvr;
    }

    public void setProfvr(boolean profvr) {
        this.profvr = profvr;
    }
}
