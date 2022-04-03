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

import java.util.List;

@Repository
public class Dao_DemoPageController implements IDaoDemoPageController
{


    @Autowired
    @Qualifier(value = "shopJdbcTemplate")
    JdbcTemplate jtm2;

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


}

