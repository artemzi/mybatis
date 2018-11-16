package ru.innopolis.stc12.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.stc12.hibernate.service.iFillPhonesService;

@Controller
public class FillPhonesController {
    @Autowired
    iFillPhonesService fillPhonesService;

    @RequestMapping(value = "/fillPhones", method = RequestMethod.GET)
    public ModelAndView fillPhones() {
        fillPhonesService.fillPhones();

        ModelAndView modelAndView = new ModelAndView("allPhones");
        return modelAndView;
    }
}
