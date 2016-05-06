package com.beingjavaguys.model;

import java.util.List;

/**
 * Created by yuri on 04.05.16.
 */
public class RezMO {
    private RezultatMo rezultatMo;
    private List<RezMoVlozh> rezMoVlozh;

    public RezMO() {
    }

    public RezMO(RezultatMo rezultatMo, List<RezMoVlozh> rezMoVlozh) {
        this.rezultatMo = rezultatMo;
        this.rezMoVlozh = rezMoVlozh;
    }

    public RezultatMo getRezultatMo() {
        return rezultatMo;
    }

    public void setRezultatMo(RezultatMo rezultatMo) {
        this.rezultatMo = rezultatMo;
    }

    public List<RezMoVlozh> getRezMoVlozh() {
        return rezMoVlozh;
    }

    public void setRezMoVlozh(List<RezMoVlozh> rezMoVlozh) {
        this.rezMoVlozh = rezMoVlozh;
    }
}
