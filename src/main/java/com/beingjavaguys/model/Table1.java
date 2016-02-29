package com.beingjavaguys.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "table1")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Table1 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

//    @Column(name = "avtor")
//    private String avtor;

    @Column(name = "text")
    private String text;

    @Column(name = "timez")
    private Date timez;
    
    @JoinColumn(name = "spr_avtors_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SprAvtors sprAvtorsId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public String getAvtor() {
//        return avtor;
//    }
//
//    public void setAvtor(String avtor) {
//        this.avtor = avtor;
//    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTimez() {
        return timez;
    }

    public void setTimez(Date timez) {
        this.timez = timez;
    }
    
    public SprAvtors getSprAvtorsId() {
        return sprAvtorsId;
    }

    public void setSprAvtorsId(SprAvtors sprAvtorsId) {
        this.sprAvtorsId = sprAvtorsId;
    }

}
