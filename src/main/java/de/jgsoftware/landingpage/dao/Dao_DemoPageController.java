package de.jgsoftware.landingpage.dao;


import de.jgsoftware.landingpage.dao.interfaces.web.IDaoDemoPageController;
import de.jgsoftware.landingpage.model.m_bootstrap_components;
import de.jgsoftware.landingpage.model.m_webtextlayout;
import de.jgsoftware.landingpage.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import de.jgsoftware.landingpage.model.areacodes;

import de.jgsoftware.landingpage.model.useragent;



@Repository
public class Dao_DemoPageController implements IDaoDemoPageController
{

    @Autowired
    @Qualifier(value = "shopJdbcTemplate")
    JdbcTemplate jtm2;


    // demodb
    @Autowired
    @Qualifier(value = "defaultJdbcTemplate")
    JdbcTemplate jtm;


    @Lazy
    @Autowired
    IndexService sdemowebtext;





    // returns all entriys from Table
    public List<m_webtextlayout> getPageLanguageText()
    {
        List<m_webtextlayout> webtextlayouts = jtm2.query("select * from webtextlayout", new BeanPropertyRowMapper(m_webtextlayout.class));
        return webtextlayouts;
    }


    // returns all entriys from stored Bootstrap Compoents
    // with ${ value } for mapping to Theamyleaf
    @Override
    public List<m_bootstrap_components> getBootstrapComponents()
    {

        // query("select * from bootstrap_components", new BeanPropertyRowMapper(m_bootstrap_comonents.class));

        // SqlRowSet rs = select.queryForRowSet(query, new HashMap<String, Object>());
        List<m_bootstrap_components> bootstrap_comonents = jtm2.query("select * from BOOTSTRAP_COMPONENTS", new BeanPropertyRowMapper(m_bootstrap_components.class));
        return bootstrap_comonents;
    }


    // return list from country where in the eu
    @Override
    public List<areacodes> areacodes_eu()
    {
        List<areacodes> areacodes = jtm2.query("SELECT * FROM LEANDERCODES where EU = 1", new BeanPropertyRowMapper(areacodes.class));
        return areacodes;
    }


    @Override
    public useragent saveuseragent(useragent muagent)
    {


        Long countid = jtm.queryForObject("SELECT COUNT (*) FROM useragent", Long.class);

        if(countid == 0)
        {
            countid = Long.valueOf(1);
            muagent.setId(countid);
        }
        else if(countid > 0)
        {
            long l = countid + 1;
            muagent.setId(l);
        }


        jtm.update("insert into useragent " +
                        "(id, ipaddress, stbrowser, stbrowserversion, stsystem, stlanguage, datum, timestamp) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?)",
                muagent.getId(),
                muagent.getIpAddress(),
                muagent.getStbrowser(),
                muagent.getStbrowserversion(),
                muagent.getStsystem(),
                muagent.getStlanguage(),
                muagent.getDate(),
                muagent.getDate());


        return muagent;
    }
}

