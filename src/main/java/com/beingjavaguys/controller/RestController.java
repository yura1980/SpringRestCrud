package com.beingjavaguys.controller;

import com.beingjavaguys.model.*;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.beingjavaguys.services.DataServices;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/mess")
public class RestController {

    @Autowired
    DataServices dataServices;

    static final Logger logger = Logger.getLogger(RestController.class);

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    Status addEmployee(@RequestBody Table1 ms) {
        try {
            if (ms.getSprAvtorsId().getId() < 0) {
                SprAvtors au = new SprAvtors();
                au.setAvtor(ms.getSprAvtorsId().getAvtor());
                au = dataServices.addEntityAut(au);
                ms.setSprAvtorsId(au);
            }
            dataServices.addEntity(ms);
            return new Status(1, "Messege added Successfully !");
        } catch (Exception e) {
            // e.printStackTrace();
            return new Status(0, e.toString());
        }

    }

    /////////////////
    @RequestMapping(value = "/createKl", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    long addSpisokLpmo(@RequestBody SpisokLpmo ms) {
        try {
            return dataServices.addSpisokLpmo(ms);//            return new Status(1, "Messege added Successfully !");
        } catch (Exception e) {            // e.printStackTrace();
            return -1;//new Status(0, e.toString());
        }
    }

    @RequestMapping(value = "/createPasp", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    long addPasporta(@RequestBody Pasporta ms) {
        try {
            return dataServices.addPasporta(ms);
        } catch (Exception e) {
            return -1;
        }
    }

    @RequestMapping(value = "/createAdr", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    long addAdres(@RequestBody Adres ms) {
        try {
            return dataServices.addAdres(ms);
        } catch (Exception e) {
            return -1;
        }
    }

    @RequestMapping(value = "/createRab", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    long addRabota(@RequestBody Rabota ms) {
        try {
            return dataServices.addRabota(ms);
        } catch (Exception e) {
            return -1;
        }
    }

    @RequestMapping(value = "/createObsh", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    long addObshhee(@RequestBody Obshhee ms) {
        try {
            return dataServices.addObshhee(ms);
        } catch (Exception e) {
            return -1;
        }
    }

    @RequestMapping(value = "/createPos", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    long addPoseshenie(@RequestBody Poseshenie ms) {
        try {
            return dataServices.addPoseshenie(ms);
        } catch (Exception e) {
            return -1;
        }
    }
    /////////////////

    @RequestMapping(value = "/createJurn", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    long addJurnal(@RequestBody Jurnal ms) {
        try {
            return dataServices.addJurnal(ms);
        } catch (Exception e) {
            return -1;
        }
    }

    @RequestMapping(value = "/crspr", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    long addEntitySpr(@RequestBody String ms) {
        try {
            String[] par = ms.split("=");
            if (par[0].equals("fam")) {
                return dataServices.addEntitySpr(new SprFam(par[1]));
            } else if (par[0].equals("name")) {
                return dataServices.addEntitySpr(new SprName(par[1]));
            } else if (par[0].equals("otch")) {
                return dataServices.addEntitySpr(new SprOtch(par[1]));
            } else if (par[0].equals("nameOrg")) {
                return dataServices.addEntitySpr(new SprOrg(par[1]));
            } else if (par[0].equals("poliklinika")) {
                return dataServices.addEntitySpr(new SprPolikliniki(par[1]));
            } else if (par[0].equals("nazvPodrazdelenija")) {
                return dataServices.addEntitySpr(new SprMestoRaboty(par[1]));
            } else if (par[0].equals("professija")) {
                return dataServices.addEntitySpr(new SprProfesija(par[1]));
            } else if (par[0].equals("gragd")) {
                return dataServices.addEntitySpr(new SprGragdanstvo(par[1]));
            } else if (par[0].equals("kemVydan")) {
                return dataServices.addEntitySpr(new SprPaspKemVydan(par[1]));
            } else if (par[0].equals("oblast")) {
                return dataServices.addEntitySpr(new SprOblast(par[1]));
            } else if (par[0].equals("gorod")) {
                return dataServices.addEntitySpr(new SprGorod(par[1]));
            } else if (par[0].equals("raion")) {
                return dataServices.addEntitySpr(new SprRaion(par[1]));
            } else if (par[0].equals("naselPunkt")) {
                return dataServices.addEntitySpr(new SprNaselPunkt(par[1]));
            } else if (par[0].equals("ulici")) {
                return dataServices.addEntitySpr(new SprUlici(par[1]));
            } else {
                return -1;
            }
        } catch (Exception e) { // e.printStackTrace();
            return -1;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Table1 getEmployee(@PathVariable("id") long id) {
        Table1 ms = null;
        try {
            ms = dataServices.getEntityById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ms;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Table1> getEmployee() {

        List<Table1> msList = null;
        try {
            msList = dataServices.getEntityList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return msList;
    }

    @RequestMapping(value = "/listAu", method = RequestMethod.GET)
    public
    @ResponseBody
    List<SprAvtors> getEmployeeAu() {

        List<SprAvtors> msList = null;
        try {
            msList = dataServices.getEntityListAu();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return msList;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Status deleteEmployee(@PathVariable("id") long id) {

        try {
            dataServices.deleteEntity(id);
            return new Status(1, "Messege deleted Successfully !");
        } catch (Exception e) {
            return new Status(0, e.toString());
        }
    }

    @RequestMapping(value = "/listMkb", method = RequestMethod.GET)
    public
    @ResponseBody
    List<MkbDiagnos> getMkbList() {

        List<MkbDiagnos> msList = null;
        try {
            msList = dataServices.getMkbList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return msList;
    }

    @RequestMapping(value = "/listPass", method = RequestMethod.GET)
    public
    @ResponseBody
    List<MyPassword> getPassList() {
        List<MyPassword> msList = null;
        try {
            msList = dataServices.getPassList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msList;
    }

    @RequestMapping(value = "/login/{val}", method = RequestMethod.GET)
    public
    @ResponseBody
    char[] getLogin(@PathVariable("val") String val) {
        List<MyPassword> msList = null;
        try {
            msList = dataServices.getPassList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "home".toCharArray();
    }

    @RequestMapping(value = "/listJurnal", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Jurnal> getJurnalList() {
        List<Jurnal> jurnalList = null;
        try {
            jurnalList = dataServices.getJurnalList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jurnalList;
    }

    @RequestMapping(value = "/listPoseshenie", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Poseshenie> getPoseshenieList() {
        List<Poseshenie> posesheniesList = null;
        try {
            posesheniesList = dataServices.getPoseshenieList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posesheniesList;
    }

    @RequestMapping(value = "/listSpisokLpmo", method = RequestMethod.GET)
    public
    @ResponseBody
    List<SpisokLpmo> getSpisokLpmoList() {
        List<SpisokLpmo> spisokLpmoList = null;
        try {
            spisokLpmoList = dataServices.getSpisokLpmoList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spisokLpmoList;
    }

    //все справочники
    @RequestMapping(value = "fam/{val}", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Spr> getSprFamList(@PathVariable("val") String val) {
        List<Spr> fs = null;
        try {
            fs = dataServices.getSprFamList(val);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fs;
    }

    //поиск
    @RequestMapping(value = "find", method = RequestMethod.GET)
    public
    @ResponseBody
    List<SpisokLpmo> getSpisokLpmoFindList(
            @RequestParam(value = "spisokLpmoKl", required = false) String kl,
            @RequestParam(value = "obshhee", required = false) String obshhee) {
//            @RequestParam(value = "sprFamId", required = false) String fam,
//            @RequestParam(value = "sprNameId", required = false) String name,
//            @RequestParam(value = "sprOtchId", required = false) String otch,
//            @RequestParam(value="datasRozhd", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dr) {
//            @RequestParam(value="datasRozhd", required=false) String dr) {
        List<SpisokLpmo> fs = null;
        try {
            SpisokLpmo sp = new SpisokLpmo();
            Obshhee obsh = null;
            ObjectMapper mapper = new ObjectMapper();
            try {
                sp= mapper.readValue(kl, SpisokLpmo.class);
                if (obshhee != null && !obshhee.isEmpty()) {
                    obsh = new Obshhee();
                    obsh = mapper.readValue(obshhee, Obshhee.class);
                }
//                sp.setSprFamId(mapper.readValue(fam, SprFam.class));
//                if (name != null && !name.isEmpty()) sp.setSprNameId(mapper.readValue(name, SprName.class));
//                if (otch != null && !otch.isEmpty()) sp.setSprOtchId(mapper.readValue(name, SprOtch.class));
//                if (dr != null) {
////                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////                    dateFormat.parse(dr);
////                    dateFormat.setLenient(false);
////                    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//                    sp.setDatasRozhd(dr);//dateFormat.parse(dr));
//                }
//                return someService.call(userPreferences);
            } catch (IOException e) {
                e.printStackTrace();
            }

            fs = dataServices.getSpisokLpmoFindList(sp, obsh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fs;
    }

    @RequestMapping(value = "adr/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Adres getAdres(@PathVariable("id") long id) {
        Adres ms = null;
        try {
            ms = dataServices.getAdresById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ms;
    }

    @RequestMapping(value = "obsh/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Obshhee getObshhee(@PathVariable("id") long id) {
        Obshhee ms = null;
        try {
            ms = dataServices.getObshheeById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ms;
    }

}
