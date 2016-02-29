package com.beingjavaguys.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author progr
 */
@Entity
@Table(name = "spr_avtors")
@XmlRootElement
public class SprAvtors implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "avtor")
    private String avtor;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sprAvtorsId")
//    private Collection<Table1> table1Collection;

    public SprAvtors() {
    }

    public SprAvtors(Integer id) {
        this.id = id;
    }

    public SprAvtors(Integer id, String avtor) {
        this.id = id;
        this.avtor = avtor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvtor() {
        return avtor;
    }

    public void setAvtor(String avtor) {
        this.avtor = avtor;
    }

//    @XmlTransient
//    public Collection<Table1> getTable1Collection() {
//        return table1Collection;
//    }
//
//    public void setTable1Collection(Collection<Table1> table1Collection) {
//        this.table1Collection = table1Collection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SprAvtors)) {
            return false;
        }
        SprAvtors other = (SprAvtors) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id.toString();
    }
    
}
