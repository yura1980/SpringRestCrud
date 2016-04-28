package com.beingjavaguys.model;

/**
 * Created by yuri on 27.04.16.
 */
public class TO_MOI {
    private MoI moI;
    private Integer diagnozs[];
    private Boolean diagnozsvp[];

    public TO_MOI() {
    }

    public MoI getMoI() {
        return moI;
    }

    public void setMoI(MoI moI) {
        this.moI = moI;
    }

    public Integer[] getDiagnozs() {
        return diagnozs;
    }

    public void setDiagnozs(Integer[] diagnozs) {
        this.diagnozs = diagnozs;
    }

    public Boolean[] getDiagnozsvp() {
        return diagnozsvp;
    }

    public void setDiagnozsvp(Boolean[] diagnozsvp) {
        this.diagnozsvp = diagnozsvp;
    }
}
