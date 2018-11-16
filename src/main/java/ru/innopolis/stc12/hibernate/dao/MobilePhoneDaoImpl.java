package ru.innopolis.stc12.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public MobilePhone getPhoneById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (MobilePhone) session.get(MobilePhone.class, id);
    }

    @Override
    @Transactional    
    public List<MobilePhone> getPhonesList() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(MobilePhone.class);
        List<MobilePhone> phones = criteria.list();
        return phones;
    }

    @Override
    @Transactional    
    public void addPhone(MobilePhone phone) {
        Session session = sessionFactory.getCurrentSession();
        session.save(phone);
        phone.setCost(20000);
    }
}
