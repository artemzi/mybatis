package ru.innopolis.stc12.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.hibernate.dao.MobilePhoneDao;
import ru.innopolis.stc12.hibernate.dao.entities.Certificate;
import ru.innopolis.stc12.hibernate.dao.entities.Deal;
import ru.innopolis.stc12.hibernate.dao.entities.Manufacturer;
import ru.innopolis.stc12.hibernate.dao.entities.MobilePhone;

@Service("iFillPhonesService")
public class FillPhonesService implements iFillPhonesService {
    @Autowired
    private MobilePhoneDao mobilePhoneDao;

    @Override
    public void fillPhones() {
        Deal deal = new Deal("Иван Петрович Федоров");
        Deal deal2 = new Deal("Семенов Евгений Викторович");

        Manufacturer manufacturer = new Manufacturer("Siemens AG", "Germany");
        MobilePhone phone = new MobilePhone("Siemens c35", 15000, "Старый добрый Сименс");
        phone.setCertificate(new Certificate("1325515", phone));
        phone.setManufacturer(manufacturer);
        mobilePhoneDao.addPhone(phone);

        phone = new MobilePhone("Siemens M50", 18000, "Сименс поновее и покрасивее");
        phone.setCertificate(new Certificate("56467835", phone));
        phone.setManufacturer(manufacturer);
        mobilePhoneDao.addPhone(phone);

        MobilePhone phone3 = new MobilePhone("Siemens C70", 22000, "Не помню, был ли такой телефон");
        phone.setCertificate(new Certificate("74545386", phone));
        phone.setManufacturer(manufacturer);
        phone.addDeal(deal);
        phone.addDeal(deal2);
        mobilePhoneDao.addPhone(phone);

        manufacturer = new Manufacturer("Apple inc", "USA");
        phone = new MobilePhone("Iphone 7", 30000, "Привет Стиву");
        phone.setCertificate(new Certificate("984565487", phone));
        phone.setManufacturer(manufacturer);
        phone.addDeal(deal2);
        mobilePhoneDao.addPhone(phone);

        phone = new MobilePhone("Iphone X", 60000, "Новое не всегда лучше старого");
        phone.setCertificate(new Certificate("9845484", phone));
        phone.setManufacturer(manufacturer);
        mobilePhoneDao.addPhone(phone);

        manufacturer = new Manufacturer("Samsung inc", "Korea");
        phone = new MobilePhone("Galaxy 6", 35000, "С нашими аккумуляторами можно не покупать пиротехнику!");
        phone.setCertificate(new Certificate("984565487", phone));
        phone.setManufacturer(manufacturer);
        phone.addDeal(deal);
        mobilePhoneDao.addPhone(phone);

        phone = new MobilePhone("Galaxy 7", 45000, "Аккумулятор тоже так себе");
        phone.setCertificate(new Certificate("9845484", phone));
        phone.setManufacturer(manufacturer);
        phone.addDeal(deal2);
        phone.addDeal(deal);
        mobilePhoneDao.addPhone(phone);
    }
}
