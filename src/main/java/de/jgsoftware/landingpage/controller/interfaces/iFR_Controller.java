package de.jgsoftware.landingpage.controller.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public interface iFR_Controller
{
    @GetMapping({"fr", "/"})
    public ModelAndView fr();
}
