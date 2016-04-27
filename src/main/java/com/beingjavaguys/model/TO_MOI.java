package com.beingjavaguys.model;

/**
 * Created by yuri on 27.04.16.
 */
public class TO_MOI {
    private MoI moI;
    private Diagnoz diagnozs[];

    public TO_MOI() {
    }

    public MoI getMoI() {
        return moI;
    }

    public void setMoI(MoI moI) {
        this.moI = moI;
    }

    public Diagnoz[] getDiagnozs() {
        return diagnozs;
    }

    public void setDiagnozs(Diagnoz[] diagnozs) {
        this.diagnozs = diagnozs;
    }
}
