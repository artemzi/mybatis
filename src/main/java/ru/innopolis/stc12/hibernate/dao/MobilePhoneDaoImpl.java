package ru.innopolis.stc12.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc12.hibernate.dao.entities.Manufacturer;
import ru.innopolis.stc12.hibernate.dao.entities.MobilePhone;

import java.util.List;

@Repository
public class MobilePhoneDaoImpl implements MobilePhoneDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public MobilePhone getPhoneById(Long id) {
        return sessionFactory.getCurrentSession().get(MobilePhone.class, id);
    }

    @Override
    public List<MobilePhone> getPhonesList() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(MobilePhone.class);
        NativeQuery query = session.createNativeQuery("fff");
        List<MobilePhone> phones = criteria.list();
        return phones;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addPhone(MobilePhone phone) {
        Session session = sessionFactory.getCurrentSession();
        session.save(phone);
        phone.setCost(20000);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public List<Manufacturer> getManufacturers() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Manufacturer.class);
        List<Manufacturer> manufacturers = criteria.list();
        return manufacturers;
    }
}
