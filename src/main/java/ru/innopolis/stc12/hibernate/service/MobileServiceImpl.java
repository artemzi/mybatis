package ru.innopolis.stc12.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc12.hibernate.dao.MobilePhoneDao;
import ru.innopolis.stc12.hibernate.dao.entities.Certificate;
import ru.innopolis.stc12.hibernate.dao.entities.Manufacturer;
import ru.innopolis.stc12.hibernate.dao.entities.MobilePhone;

import java.util.List;

@Service
@Transactional
public class MobileServiceImpl implements MobileService {
    private MobilePhoneDao mobilePhoneDao;

    @Autowired
    public void setMobilePhoneDao(MobilePhoneDao mobilePhoneDao) {
        this.mobilePhoneDao = mobilePhoneDao;
    }

    @Override
    public MobilePhone getMobilePhone(Long id) {
        return mobilePhoneDao.getPhoneById(id);
    }

    @Override
    public List<MobilePhone> getMobileList() {
        List<MobilePhone> mobilePhones = mobilePhoneDao.getPhonesList();
        return mobilePhones;
    }

    @Override
    public void addPhone(Long id, String model, Integer cost) {
        MobilePhone mobilePhone = new MobilePhone(id, model, cost, "",
                new Manufacturer("Russia", "Yotaphone"),
                new Certificate("12121212", null));
        mobilePhone.getCertificate().setPhone(mobilePhone);
        mobilePhoneDao.addPhone(mobilePhone);
    }

    @Override
    public List<Manufacturer> getManufacturers() {
        List<Manufacturer> manufacturers = mobilePhoneDao.getManufacturers();
        for (Manufacturer manufacturer : manufacturers) {
            Integer count = 0;
            for (MobilePhone phone : manufacturer.getPhones()) {
                count++;
            }
            manufacturer.setModelCount(count);
        }
        return manufacturers;
    }
}
