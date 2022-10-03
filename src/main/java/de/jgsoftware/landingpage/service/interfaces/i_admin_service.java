package de.jgsoftware.landingpage.service.interfaces;

import de.jgsoftware.landingpage.dao.Dao_admin;
import de.jgsoftware.landingpage.dao.interfaces.i_jpa_useragent;

import javax.script.ScriptEngineManager;
import java.util.List;

public interface i_admin_service
{

    Dao_admin getIdao_admin();
    void setIdao_admin(Dao_admin idao_admin);

    int getcurrentMonth();
    int getcurrentYear();



    /*
        interface dao
        i_jpa_useragent
     */
    i_jpa_useragent getiJpaUseragent();
    void setiJpaUseragent(i_jpa_useragent iJpaUseragent);



    /*
        get user
        if loggedin
     */
    String getloggedinuser();

    ScriptEngineManager startjavasciptengine();



    /*

        Network Activities Graph title sub-title

        run java query
        for Graph gentelella index dashboard
     */

    List getconnectdatayear();

}
