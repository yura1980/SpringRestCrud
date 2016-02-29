package com.beingjavaguys.dao;

import java.util.List;

import com.beingjavaguys.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.FlushMode;

public class DataDaoImpl implements DataDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean addEntity(Table1 ms) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(ms);
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public SprAvtors addEntityAut(SprAvtors au) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.setFlushMode(FlushMode.COMMIT);
        session.save(au);
        tx.commit();
        session.close();
        return au;
    }

    @Override
    public Table1 getEntityById(long id) throws Exception {
        session = sessionFactory.openSession();
        Table1 employee = (Table1) session.load(Table1.class, new Long(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return employee;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Table1> getEntityList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Table1> employeeList = session.createCriteria(Table1.class).list();
        tx.commit();
        session.close();
        return employeeList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SprAvtors> getEntityListAu() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<SprAvtors> employeeList = session.createCriteria(SprAvtors.class).list();
        tx.commit();
        session.close();
        return employeeList;
    }

    @Override
    public boolean deleteEntity(long id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Table1.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

    //
    @SuppressWarnings("unchecked")
    @Override
    public List<MkbDiagnos> getMkbList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<MkbDiagnos> mkbList = session.createCriteria(MkbDiagnos.class).list();
        tx.commit();
        session.close();
        return mkbList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MyPassword> getPasswList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<MyPassword> passList = session.createCriteria(MyPassword.class).list();
        tx.commit();
        session.close();
        return passList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Jurnal> getJurnalList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Jurnal> jurnalList = session.createCriteria(Jurnal.class).list();
        tx.commit();
        session.close();
        return jurnalList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Poseshenie> getPoseshenieList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Poseshenie> posesheniesList = session.createCriteria(Poseshenie.class).list();
        tx.commit();
        session.close();
        return posesheniesList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Spr> getSprFamList(String val) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        //--
        List<Spr> sprFamList = null;
        String[] par = val.split("=");
        Class cl = null;
        if (par[0].equals("fam")) {
            cl = SprFam.class;
        } else if (par[0].equals("name")) {
            cl = SprName.class;
        } else if (par[0].equals("otch")) {
            cl = SprOtch.class;
        } else if (par[0].equals("nameOrg")) {
            cl = SprOrg.class;
        } else if (par[0].equals("poliklinika")) {
            cl = SprPolikliniki.class;
        } else if (par[0].equals("nazvPodrazdelenija")) {
            cl = SprMestoRaboty.class;
        } else if (par[0].equals("professija")) {
            cl = SprProfesija.class;
        }else if (par[0].equals("gragd")) {
            cl = SprGragdanstvo.class;
        }else if (par[0].equals("kemVydan")) {
            cl = SprPaspKemVydan.class;
        }else if (par[0].equals("oblast")) {
            cl = SprOblast.class;
        }else if (par[0].equals("gorod")) {
            cl = SprGorod.class;
        }else if (par[0].equals("raion")) {
            cl = SprRaion.class;
        }else if (par[0].equals("naselPunkt")) {
            cl = SprNaselPunkt.class;
        }else if (par[0].equals("ulici")) {
            cl = SprUlici.class;
        }
        sprFamList = session.createCriteria(cl).add(Restrictions.like(par[0], par[1] + "%")).list();
        //
        tx.commit();
        session.close();
        return sprFamList;
    }

    @Override
    public long addEntitySpr(Spr ms) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(ms);
        tx.commit();
        session.close();
        return ms.getId();
    }

    @Override
    public Adres getAdresById(long id) throws Exception {
        session = sessionFactory.openSession();
        Adres adres = (Adres) session.get(Adres.class, id);
        tx = session.getTransaction();
        session.beginTransaction();

        tx.commit();
        return adres;
    }

    @Override
    public Obshhee getObshheeById(long id) throws Exception {
        session = sessionFactory.openSession();
        Obshhee adres = (Obshhee) session.get(Obshhee.class, id);
        tx = session.getTransaction();
        session.beginTransaction();

        tx.commit();
        return adres;
    }
}
