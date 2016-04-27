package com.beingjavaguys.dao;

import com.beingjavaguys.model.*;
import org.hibernate.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public List<ProfVrednosti> getProfVrednostiList(long id) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<ProfVrednosti> spisokLpmoList = session.createCriteria(ProfVrednosti.class)
                .add(Restrictions.eqOrIsNull("poseshenieId", id))
                .addOrder(Order.asc("idpril.id"))
                .list();
        tx.commit();
        session.close();
        return spisokLpmoList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Diagnoz> getDiagnozList(long id) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Diagnoz> diagnozList = session.createCriteria(Diagnoz.class)
                .add(Restrictions.eqOrIsNull("moIId", id))
                //.addOrder(Order.asc("idpril.id"))
                .list();
        tx.commit();
        session.close();
        return diagnozList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MoI> getMoIList(long id) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<MoI> spisokLpmoList = session.createCriteria(MoI.class)
                .add(Restrictions.eqOrIsNull("poseshenieId", id))
                //.addOrder(Order.asc("idpril.id"))
                .list();
        tx.commit();
        session.close();
        return spisokLpmoList;
    }

//    @SuppressWarnings("unchecked")
//    @Override
//    public List<Diagnoz> getDiagnozList(long id) throws Exception {
//        session = sessionFactory.openSession();
//        tx = session.beginTransaction();
//        List<Diagnoz> spisokLpmoList = session.createCriteria(Diagnoz.class)
//                .add(Restrictions.eqOrIsNull("poseshenieId", id))
//                //.addOrder(Order.asc("idpril.id"))
//                .list();
//        tx.commit();
//        session.close();
//        return spisokLpmoList;
//    }

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
        } else if (par[0].equals("nameP")) {
            cl = SprVrachIssl.class;
        } else if (par[0].equals("shabl")) {
            cl = ShablVrIssRek.class;
        } else if (par[0].equals("nomer")) {
            cl = ProfvrednostPrilozh.class;
            Criteria cr = session.createCriteria(cl);
            if (par[1].matches("\\d+(\\.\\d+)?")) {
                cr.add(Restrictions.like(par[0], par[1] + "%"));// Restrictions.ilike(par[0], par[1], MatchMode.ANYWHERE),
            } else {
                cr.add(Restrictions.ilike("naimenovanieFaktorov", par[1], MatchMode.ANYWHERE));
            }
            sprFamList = cr.setMaxResults(15).list();

            tx.commit();
            session.close();
            return sprFamList;
        } else if (par[0].equals("ndiag")) {
            cl = MkbDiagnos.class;
            Criteria cr = session.createCriteria(cl);
            if (par[1].matches("[a-zA-Z]\\d+(\\.\\d+)?") || par[1].length() == 1) {//
                cr.add(Restrictions.ilike(par[0], par[1], MatchMode.ANYWHERE));
//                cr.add(Restrictions.like(par[0], par[1] + "%"));
            } else {
                cr.add(Restrictions.ilike("diag", par[1], MatchMode.ANYWHERE));
            }
            sprFamList = cr.setMaxResults(15).list();

            tx.commit();
            session.close();
            return sprFamList;
        }

        if (par.length == 1) {
            sprFamList = session.createCriteria(cl).list();
        } else {
            sprFamList = session.createCriteria(cl)
                    //.add(Restrictions.sqlRestriction("lower({alias}."+par[0]+") like lower(?)", par[1].toLowerCase() + "%", StringType.INSTANCE))
                    .add(Restrictions.or(
                            Restrictions.like(par[0], Character.toUpperCase(par[1].charAt(0)) + par[1].substring(1) + "%"),
                            Restrictions.ilike(par[0], par[1], MatchMode.ANYWHERE)))//"%"+ par[1] + "%"
                    .setMaxResults(15)
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
        if (ms.getId() != null && ms.getId() > 0) {
            session.update(ms);
        } else {
            session.save(ms);
        }
        tx.commit();
        session.close();
        return ms.getId();
    }

    @Override
    public long addMOI(TO_MOI ms) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        if (ms.getMoI().getDopinfoid().getMoIId()!= null && ms.getMoI().getDopinfoid().getMoIId()  > 0) {
            session.update(ms.getMoI());
            //session.update(ms.getMoI().getDopinfoid());
        } else {
            session.save(ms.getMoI().getDopinfoid());
        }
        tx.commit();
        session.close();
        return ms.getMoI().getDopinfoid().getMoIId();
    }

    @Override
    public long addSpisokLpmo(SpisokLpmo ms) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        if (ms.getKl() > 0) {
            session.update(ms);
        } else {
            Pasporta pasporta = ms.getPasportaId();
            ms.setPasportaId(null);
            session.save(ms);
            session.flush();

            pasporta.setId(ms.getKl());
            session.save(pasporta);

            ms.setPasportaId(pasporta);
            session.update(ms);
        }

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
    public long[] addPoseshenie(Klient ms) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();

        long kl = -1;

        if (ms.getPoseshenie().getSpisokLpmoKl().getKl() > 0) {
            session.update(ms.getPoseshenie().getSpisokLpmoKl());
        } else {
            if (!ms.getChange().isPasp()) {
                session.save(ms.getPoseshenie().getSpisokLpmoKl());
                session.flush();
            } else {
                Pasporta pasporta = ms.getPoseshenie().getSpisokLpmoKl().getPasportaId();
                ms.getPoseshenie().getSpisokLpmoKl().setPasportaId(null);
                session.save(ms.getPoseshenie().getSpisokLpmoKl());
                session.flush();

                pasporta.setId(kl);
                session.save(pasporta);

                ms.getPoseshenie().getSpisokLpmoKl().setPasportaId(pasporta);
                session.update(ms.getPoseshenie().getSpisokLpmoKl());
            }
        }
        kl = ms.getPoseshenie().getSpisokLpmoKl().getKl();

        Oplata oplata = ms.getPoseshenie().getOplata();
        Rabota rabota = ms.getPoseshenie().getRabotaId();
        if (ms.getPoseshenie().getId() < 0) {
            ms.getPoseshenie().setOplata(null);
            ms.getPoseshenie().setRabotaId(null);
            session.save(ms.getPoseshenie());
            session.flush();
        }

        if (ms.getChange().isRabota()) {
            if (rabota.getId() > 0) {
                session.update(rabota);
            } else {
                rabota.setId(kl);
                session.save(rabota);
            }
            ms.getPoseshenie().setRabotaId(rabota);
        }

        if (ms.getChange().isAdres()) {
            if (ms.getAdres().getId() > 0) {
                session.update(ms.getAdres());
            } else {
                ms.getAdres().setId(kl);
                session.save(ms.getAdres());
            }
        }

        if (ms.getChange().isObshee()) {
            if (ms.getObshhee().getId() > 0) {
                session.update(ms.getObshhee());
            } else {
                ms.getObshhee().setId(kl);
                session.save(ms.getObshhee());
            }
        }

        if (ms.getChange().isOplata()) {
            if (oplata.getId() > 0) {
                session.update(oplata);
            } else {
                oplata.setId(ms.getPoseshenie().getId());
                session.save(oplata);
            }
            ms.getPoseshenie().setOplata(oplata);
        }

        if (ms.getChange().isProfvr()) {
            session.delete(new ProfVrednosti(ms.getPoseshenie().getId()));

            if (ms.getPrvr()[0] > 0) {
                for (Integer l : ms.getPrvr()) {
                    ProfvrednostPrilozh p = new ProfvrednostPrilozh();
                    p.setId(l);
                    session.save(new ProfVrednosti(ms.getPoseshenie().getId(), p));
                }
            }
        }

        if (ms.getChange().isOplata() || ms.getChange().isFio() || ms.getChange().isPasp() || ms.getChange().isRabota()) {
            session.update(ms.getPoseshenie());
//            session.flush();
        }

//        Pasporta pasporta = ms.getPoseshenie().getSpisokLpmoKl().getPasportaId();
//
//        if (ms.getPoseshenie().getSpisokLpmoKl().getKl() > 0) {
//            session.update(ms.getPoseshenie().getSpisokLpmoKl());
//        } else {
//            ms.getPoseshenie().getSpisokLpmoKl().setPasportaId(null);
//
//            session.save(ms.getPoseshenie().getSpisokLpmoKl());
//            session.flush();
//        }
//
//        long kl = ms.getPoseshenie().getSpisokLpmoKl().getKl();
//
//        if (pasporta != null && pasporta.getId() < 0) {
//            pasporta.setId(kl);
//            session.save(pasporta);
//
//            ms.getPoseshenie().getSpisokLpmoKl().setPasportaId(pasporta);
//            session.update(ms.getPoseshenie().getSpisokLpmoKl());
//        }
//
//        if (ms.getPoseshenie().getRabotaId() != null && ms.getPoseshenie().getRabotaId().getId() < 0) {
//            ms.getPoseshenie().getRabotaId().setId(kl);
//            session.save(ms.getPoseshenie().getRabotaId());
//        }
//
//        if (ms.getAdres() != null) {
//            ms.getAdres().setId(kl);
//            session.save(ms.getAdres());
//        }
//
//        if (ms.getObshhee() != null) {
//            ms.getObshhee().setId(kl);
//            session.save(ms.getObshhee());
//        }
//
//        Oplata oplata = ms.getPoseshenie().getOplata();
//        ms.getPoseshenie().setOplata(null);
//        session.save(ms.getPoseshenie());
//
//        if (oplata != null && oplata.getId() < 0) {
//            oplata.setId(ms.getPoseshenie().getId());
//            session.save(oplata);
//        }
//
//        ms.getPoseshenie().setOplata(oplata);
//        session.update(ms.getPoseshenie());
//
//        if (ms.getPrvr()[0] > 0) {
//            for (Integer l : ms.getPrvr()) {
//                ProfvrednostPrilozh p = new ProfvrednostPrilozh();
//                p.setId(l);
//                session.save(new ProfVrednosti(ms.getPoseshenie().getId(), p));
//            }
//        }

        tx.commit();
        session.close();
        return new long[]{ms.getPoseshenie().getId(), ms.getPoseshenie().getSpisokLpmoKl().getKl()};
    }

    @Override
    public long addJurnal(Jurnal ms) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        if (ms.getRn() < 0) {
            session.save(ms);
        } else {
            session.update(ms);
        }
        tx.commit();
        session.close();
        return ms.getRn();
    }

    @Override
    public long addOplata(Oplata ms) throws Exception {
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
