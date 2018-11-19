package ru.innopolis.stc12.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.hibernate.dao.MobileMapper;
import ru.innopolis.stc12.hibernate.dao.dto.Mobile;

import java.util.List;

@Service(value = "mobileService")
public class MobileServiceImpll implements MobileService {
    @Autowired
    private MobileMapper mobileMapper;

    public MobileServiceImpll() {
    }

    @Override
    public Mobile getMobile(Integer mobileId) {
        return mobileMapper.getMobile(mobileId);
    }

    @Override
    public void insertMobile(Mobile mobile) {
        mobileMapper.insertMobile(mobile);
    }

    @Override
    public List<Mobile> getAllMobiles() {
        return mobileMapper.getAllMobiles();
    }

    @Override
    public void updateMobile(Mobile mobile) {
        mobileMapper.updateMobile(mobile);
    }

    @Override
    public void deleteMobile(Integer mobileId) {
        mobileMapper.deleteMobile(mobileId);
    }
}
