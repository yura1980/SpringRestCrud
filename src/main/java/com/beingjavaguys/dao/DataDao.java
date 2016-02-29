package com.beingjavaguys.dao;

import java.util.List;

import com.beingjavaguys.model.*;
import org.springframework.web.bind.annotation.PathVariable;

public interface DataDao {
    public boolean addEntity(Table1 ms) throws Exception;

    public SprAvtors addEntityAut(SprAvtors au) throws Exception;

    public Table1 getEntityById(long id) throws Exception;

    public List<Table1> getEntityList() throws Exception;

    public List<SprAvtors> getEntityListAu() throws Exception;

    public boolean deleteEntity(long id) throws Exception;

    List<MkbDiagnos> getMkbList() throws Exception;

    List<MyPassword> getPasswList() throws Exception;

    List<Jurnal> getJurnalList() throws Exception;

    List<Poseshenie> getPoseshenieList() throws Exception;

    List<Spr> getSprFamList(String val) throws Exception;

    Adres getAdresById(long id) throws Exception;

    Obshhee getObshheeById(long id) throws Exception;

    long addEntitySpr(Spr ms) throws Exception;
}
