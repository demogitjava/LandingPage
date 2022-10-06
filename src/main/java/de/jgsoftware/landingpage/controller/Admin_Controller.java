package de.jgsoftware.landingpage.controller;


import de.jgsoftware.landingpage.controller.interfaces.iAdminController;
import de.jgsoftware.landingpage.model.m_webtextlayout;
import de.jgsoftware.landingpage.service.interfaces.i_admin_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Admin_Controller implements iAdminController
{


    java.util.Locale locale;
    ModelAndView mv;


    String language;
    String component;


    @Autowired
    HttpServletRequest request;

    Principal principal;

    @Autowired
    i_admin_service admin_service;




    @Override
    public ModelAndView admin()
    {

        mv = new ModelAndView("admin");


        Integer usercount = admin_service.getIdao_admin().getusercount();
        mv.addObject("usersdb", usercount);

          /*
            get current month and year
            form sercie layer
         */


        int month = admin_service.getcurrentMonth();
        int year = admin_service.getcurrentYear();
        mv.addObject("currentmonth", month);
        mv.addObject("currentyear", year);



        /*
            current connect

            dao interface
            -> i_jpa_useragent

            all connects by month
            -> sql current_date
         */
        mv.addObject("currentconnects", admin_service.getiJpaUseragent().allconnectsbymonth());


        /*
            connects monat
            for navbar

         */

        mv.addObject("connectsnavar", admin_service.getiJpaUseragent().connectsmonthnavbar(month, year));


        /*
            connect year
            for navbar

         */
        mv.addObject("connectsnavaryear", admin_service.getiJpaUseragent().connectsnavbaryear(admin_service.getcurrentYear()));




        /*
            return the user is
            loggedin
         */
        mv.addObject("loggedinuser", admin_service.getloggedinuser());



        /*

            load javascript engine
            over the service layer

         */
        mv.addObject("javascriptengine", admin_service.startjavasciptengine());




        return mv;
    }

    @Override
    public String submitForm(m_webtextlayout webtextlayout) {




        admin_service.getIdao_admin().saveFormModalData(webtextlayout);

        //iServiceIndex.getDcontroller().g
        //idexservice.getDcontroller().saveFormModalData(webtextlayout);
        return "redirect:/";
    }

    @Override
    public List getcondatayear() {
        List connectsyear = null;

         /*
                is user loggedin
         */
        principal = request.getUserPrincipal();

        /*
                user login
         */
        List graflist = null;
        if (principal == null) {
            System.out.print("not login");
            returntologin();
        } else {
            connectsyear = admin_service.getconnectdatayear();

            //    year month day value
            //[gd(2012, 1,   1), 17],

            // integer size list
            int indexlist = connectsyear.size();

            graflist = new ArrayList();

            for (int i = 0; i < indexlist; i++) {


                Object obcount = ((Object[]) connectsyear.get(i))[0]; // count
                Object obname = ((Object[]) connectsyear.get(i))[1]; // browser name
                Object obmonth = ((Object[]) connectsyear.get(i))[2]; // month
                Object obyear = ((Object[]) connectsyear.get(i))[3]; // year

                String stforlist = "[gd(" + obyear + ", " + obmonth + ", " + "1, " + obcount + "]";
                //[gd(2012, 1,   1), 17],
                graflist.add(stforlist);


                //connectsyear.get(0).equals("integer");
                // graflist.add(connectsyear.get(i).);
                System.out.print(graflist);
            }


        }


        return graflist;
    }


    @Override
    public String returntologin()
    {
        return "redirect:/login/";
    }

}
