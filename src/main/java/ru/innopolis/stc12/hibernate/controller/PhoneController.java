package ru.innopolis.stc12.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.innopolis.stc12.hibernate.dao.dto.Mobile;
import ru.innopolis.stc12.hibernate.dao.dto.Owner;
import ru.innopolis.stc12.hibernate.service.MobileService;
import ru.innopolis.stc12.hibernate.service.OwnerService;

@Controller
public class PhoneController {
    private MobileService mobileService;
    private OwnerService ownerService;

    @Autowired
    public PhoneController(MobileService mobileService, OwnerService ownerService) {
        this.mobileService = mobileService;
        this.ownerService = ownerService;
    }

    @RequestMapping(value = "/getByID", method = RequestMethod.GET)
    public String getPhoneById(Model model) {
        model.addAttribute("mobile", mobileService.getMobile(300));
        model.addAttribute("owner", ownerService.getOwner(123));
        return "data";
    }

    @RequestMapping(value = "/getOwnerByID", method = RequestMethod.GET)
    public String getOwnerById(Model model) {
        model.addAttribute("owner", ownerService.getOwner(123));
        return "data";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("mobileList", mobileService.getAllMobiles());
        return "data";
    }

    @RequestMapping(value = "/getAllOwners", method = RequestMethod.GET)
    public String getAllOwners(Model model) {
        model.addAttribute("ownerList", ownerService.getAllOwners());
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

    @RequestMapping(value = "/addOwner", method = RequestMethod.GET)
    public String insertOwner(Model model) {
        Owner owner = new Owner();
        owner.setAge(12);
        owner.setOwner_id(123L);
        owner.setName("Uasya");
        ownerService.insertOwner(owner);
        return getAll(model);
    }

    @RequestMapping(value = "/updatePhone", method = RequestMethod.GET)
    public String updateMobile(Model model) {
        Mobile mobile = mobileService.getMobile(300);
        mobile.setDeveloper("Chinaphone");
        mobileService.updateMobile(mobile);
        return getPhoneById(model);
    }

    @RequestMapping(value = "/updateOwner", method = RequestMethod.GET)
    public String updateOwner(Model model) {
        Owner owner = ownerService.getOwner(123);
        owner.setName("Pypkin");
        ownerService.updateOwner(owner);
        return getOwnerById(model);
    }

    @RequestMapping(value = "/deletePhone", method = RequestMethod.GET)
    public String deleteMobile(Model model) {
        mobileService.deleteMobile(300);
        return getPhoneById(model);
    }

    @RequestMapping(value = "/deleteOwner", method = RequestMethod.GET)
    public String deleteOwner(Model model) {
        ownerService.deleteOwner(123);
        return getOwnerById(model);
    }
}
