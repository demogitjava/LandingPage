package de.jgsoftware.landingpage.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.jgsoftware.landingpage.dao.Dao_DemoPageController;

@Service
public class IndexService
{

    @Autowired
    Dao_DemoPageController dcontroller;


    public Dao_DemoPageController getDcontroller() {
        return dcontroller;
    }

    public void setDcontroller(Dao_DemoPageController dcontroller) {
        this.dcontroller = dcontroller;
    }
}
