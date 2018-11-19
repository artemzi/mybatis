package ru.innopolis.stc12.hibernate.service;

import ru.innopolis.stc12.hibernate.dao.dto.Mobile;

import java.util.List;

public interface MobileService {
    Mobile getMobile(Integer mobileId);

    void insertMobile(Mobile mobile);

    List<Mobile> getAllMobiles();

    void updateMobile(Mobile mobile);

    void deleteMobile(Integer mobileId);
}
