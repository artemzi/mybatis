package ru.innopolis.stc12.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.innopolis.stc12.hibernate.dao.dto.Mobile;
import ru.innopolis.stc12.hibernate.service.MobileService;

@Controller
public class PhoneController {
    private MobileService mobileService;

    @Autowired
    public PhoneController(MobileService mobileService) {
        this.mobileService = mobileService;
    }

    @RequestMapping(value = "/getByID", method = RequestMethod.GET)
    public String getPhoneById(Model model) {
        model.addAttribute("mobile", mobileService.getMobile(300));
        return "data";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("mobileList", mobileService.getAllMobiles());
        return "data";
    }

    @RequestMapping(value = "/addPhone", method = RequestMethod.GET)
    public String insertMobile(Model model) {
        Mobile mobile = new Mobile();
        mobile.setCost(14299);
        mobile.setDeveloper("Yotaphone");
        mobile.setModel("Ooopanki");
        mobile.setMobile_id(300L);
        mobileService.insertMobile(mobile);
        return getAll(model);
    }

    @RequestMapping(value = "/updatePhone", method = RequestMethod.GET)
    public String updateMobile(Model model) {
        Mobile mobile = mobileService.getMobile(300);
        mobile.setDeveloper("Chinaphone");
        mobileService.updateMobile(mobile);
        return getPhoneById(model);
    }

    @RequestMapping(value = "/deletePhone", method = RequestMethod.GET)
    public String deleteMobile(Model model) {
        mobileService.deleteMobile(300);
        return getPhoneById(model);
    }
}
