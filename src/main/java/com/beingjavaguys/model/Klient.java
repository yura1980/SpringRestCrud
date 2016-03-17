package com.beingjavaguys.model;

/**
 * Created by yura on 12.03.2016.
 */
public class Klient {
    private Poseshenie poseshenie;
    private Adres adres;
    private Obshhee obshhee;
    private Integer prvr[];

    public Klient() {
    }

    public Obshhee getObshhee() {
        return obshhee;
    }

    public void setObshhee(Obshhee obshhee) {
        this.obshhee = obshhee;
    }

    public Poseshenie getPoseshenie() {
        return poseshenie;
    }

    public void setPoseshenie(Poseshenie poseshenie) {
        this.poseshenie = poseshenie;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Integer[] getPrvr() {
        return prvr;
    }

    public void setPrvr(Integer[] prvr) {
        this.prvr = prvr;
    }
}
