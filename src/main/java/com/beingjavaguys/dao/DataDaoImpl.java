package com.beingjavaguys.dao;

import java.util.List;

import com.beingjavaguys.model.*;
import org.hibernate.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

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
    public List<SpisokLpmo> getSpisokLpmoList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<SpisokLpmo> spisokLpmoList = session.createCriteria(SpisokLpmo.class).list();
        tx.commit();
        session.close();
        return spisokLpmoList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SpisokLpmo> getSpisokLpmoFindList(SpisokLpmo sp, Obshhee obshhee) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<SpisokLpmo> spisokLpmoList = null;
        Criteria cr = session.createCriteria(SpisokLpmo.class);
        //.add()
        cr.add(Restrictions.eqOrIsNull("sprFamId", sp.getSprFamId()));
        if (sp.getSprNameId() != null) cr.add(Restrictions.eqOrIsNull("sprNameId", sp.getSprNameId()));
        if (sp.getSprOtchId() != null) cr.add(Restrictions.eqOrIsNull("sprOtchId", sp.getSprOtchId()));
        if (sp.getDatasRozhd() != null) cr.add(Restrictions.eqOrIsNull("datasRozhd", sp.getDatasRozhd()));
        if (sp.getPasportaId() != null) {
            cr.createAlias("pasportaId", "pasp");
            cr.add(Restrictions.like("pasp.pasport", sp.getPasportaId().getPasport() + "%"));
        }

        if (obshhee != null) {
            List<Obshhee> obshheeList = session.createCriteria(Obshhee.class)
                    .add(Restrictions.like("telefon", obshhee.getTelefon() + "%"))
                    .list();
            Long[] ids = new Long[obshheeList.size()];
            int i = 0;
            for (Obshhee obshhee1 : obshheeList) {
                ids[i++] = obshhee1.getId();
            }
            cr.add(Restrictions.in("kl", ids));
        }

        spisokLpmoList = cr.list();
        tx.commit();
        session.close();
        return spisokLpmoList;
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
        } else if (par[0].equals("gragd")) {
            cl = SprGragdanstvo.class;
        } else if (par[0].equals("kemVydan")) {
            cl = SprPaspKemVydan.class;
        } else if (par[0].equals("oblast")) {
            cl = SprOblast.class;
        } else if (par[0].equals("gorod")) {
            cl = SprGorod.class;
        } else if (par[0].equals("raion")) {
            cl = SprRaion.class;
        } else if (par[0].equals("naselPunkt")) {
            cl = SprNaselPunkt.class;
        } else if (par[0].equals("ulici")) {
            cl = SprUlici.class;
        }
        if (par.length == 1) {
            sprFamList = session.createCriteria(cl).list();
        } else {
            sprFamList = session.createCriteria(cl)
                    //.add(Restrictions.sqlRestriction("lower({alias}."+par[0]+") like lower(?)", par[1].toLowerCase() + "%", StringType.INSTANCE))
                    .add(Restrictions.or(
                            Restrictions.like(par[0], Character.toUpperCase(par[1].charAt(0)) + par[1].substring(1) + "%"),
                            Restrictions.ilike(par[0], par[1], MatchMode.ANYWHERE)))//"%"+ par[1] + "%"
                    .setMaxResults(10)
                    .list();
        }
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
    public long addSpisokLpmo(SpisokLpmo ms) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Pasporta pasporta = ms.getPasportaId();
        ms.setPasportaId(null);
        session.save(ms);
        session.flush();

        pasporta.setId(ms.getKl());
        session.save(pasporta);

        ms.setPasportaId(pasporta);
        session.update(ms);

        tx.commit();
        session.close();
        return ms.getKl();
    }

    @Override
    public long addPasporta(Pasporta ms) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(ms);
        tx.commit();
        session.close();
        return ms.getId();
    }

    @Override
    public long addAdres(Adres ms) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(ms);
        tx.commit();
        session.close();
        return ms.getId();
    }

    @Override
    public long addRabota(Rabota ms) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(ms);
        tx.commit();
        session.close();
        return ms.getId();
    }

    @Override
    public long addObshhee(Obshhee ms) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(ms);
        tx.commit();
        session.close();
        return ms.getId();
    }

    @Override
    public long addPoseshenie(Poseshenie ms) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();

        Pasporta pasporta = ms.getSpisokLpmoKl().getPasportaId();
        ms.getSpisokLpmoKl().setPasportaId(null);
        session.save(ms.getSpisokLpmoKl());
        session.flush();

        if (pasporta != null && pasporta.getId() < 0) {
            pasporta.setId(ms.getSpisokLpmoKl().getKl());
            session.save(pasporta);

            ms.getSpisokLpmoKl().setPasportaId(pasporta);
            session.update(ms.getSpisokLpmoKl());
        }

        if (ms.getRabotaId() != null && ms.getRabotaId().getId() < 0) {
            ms.getRabotaId().setId(ms.getSpisokLpmoKl().getKl());
            session.save(ms.getRabotaId());
        }

        if (ms.getOplata() != null && ms.getOplata().getId() < 0) {
            ms.getOplata().setId(ms.getSpisokLpmoKl().getKl());
            session.save(ms.getOplata());
        }

        session.save(ms);
        tx.commit();
        session.close();
        return ms.getId();
    }

    @Override
    public long addJurnal(Jurnal ms) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(ms);
        tx.commit();
        session.close();
        return ms.getRn();
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
