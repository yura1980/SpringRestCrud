package com.beingjavaguys.services;

import java.util.List;

import com.beingjavaguys.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.beingjavaguys.dao.DataDao;
import org.springframework.web.bind.annotation.RequestBody;

public class DataServicesImpl implements DataServices {

    @Autowired
    DataDao dataDao;

    @Override
    public boolean addEntity(Table1 ms) throws Exception {
        return dataDao.addEntity(ms);
    }

    @Override
    public SprAvtors addEntityAut(SprAvtors au) throws Exception {
        return dataDao.addEntityAut(au);
    }

    @Override
    public Table1 getEntityById(long id) throws Exception {
        return dataDao.getEntityById(id);
    }

    @Override
    public List<Table1> getEntityList() throws Exception {
        return dataDao.getEntityList();
    }

    @Override
    public List<SprAvtors> getEntityListAu() throws Exception {
        return dataDao.getEntityListAu();
    }

    @Override
    public boolean deleteEntity(long id) throws Exception {
        return dataDao.deleteEntity(id);
    }

    @Override
    public List<MkbDiagnos> getMkbList() throws Exception {
        return dataDao.getMkbList();
    }

    @Override
    public List<MyPassword> getPassList() throws Exception {
        return dataDao.getPasswList();
    }

    @Override
    public List<Jurnal> getJurnalList() throws Exception {
        return dataDao.getJurnalList();
    }

    @Override
    public List<Poseshenie> getPoseshenieList() throws Exception {
        return dataDao.getPoseshenieList();
    }

    @Override
    public List<Spr> getSprFamList(String val) throws Exception {
        return dataDao.getSprFamList(val);
    }

    @Override
    public Adres getAdresById(long id) throws Exception {
        return dataDao.getAdresById(id);
    }

    @Override
    public Obshhee getObshheeById(long id) throws Exception {
        return dataDao.getObshheeById(id);
    }

    @Override
    public long addEntitySpr(Spr ms) throws Exception {
        return dataDao.addEntitySpr(ms);
    }

    @Override
    public long addSpisokLpmo(SpisokLpmo ms) throws Exception {
        return dataDao.addSpisokLpmo(ms);
    }

    @Override
    public long addPasporta(Pasporta ms) throws Exception {
        return dataDao.addPasporta(ms);
    }

    @Override
    public long addAdres(Adres ms) throws Exception {
        return dataDao.addAdres(ms);
    }

    @Override
    public long addRabota(Rabota ms) throws Exception {
        return dataDao.addRabota(ms);
    }

    @Override
    public long addObshhee(Obshhee ms) throws Exception {
        return dataDao.addObshhee(ms);
    }

    @Override
    public long[] addPoseshenie(Klient ms) throws Exception {
        return dataDao.addPoseshenie(ms);
    }

    @Override
    public long addJurnal(Jurnal ms) throws Exception {
        return dataDao.addJurnal(ms);
    }

    @Override
    public long addOplata(Oplata ms) throws Exception {
        return dataDao.addOplata(ms);
    }

    @Override
    public long addMOI(TO_MOI ms) throws Exception {
        return dataDao.addMOI(ms);
    }

    @Override
    public List<SpisokLpmo> getSpisokLpmoList() throws Exception {
        return dataDao.getSpisokLpmoList();
    }

    @Override
    public List<SpisokLpmo> getSpisokLpmoFindList(SpisokLpmo sp, Obshhee obshhee) throws Exception {
        return dataDao.getSpisokLpmoFindList(sp, obshhee);
    }

    @Override
    public List<ProfVrednosti> getProfVrednostiList(long id) throws Exception{
        return dataDao.getProfVrednostiList(id);
    }

    @Override
    public List<Diagnoz> getDiagnozList(long id) throws Exception{
        return dataDao.getDiagnozList(id);
    }

    @Override
    public List<MoI> getMoIList(long id) throws Exception{
        return dataDao.getMoIList(id);
    }
}
