package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> findWhiskiesWithYear(int year){
        List<Whisky> result = null;

        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Distillery.class);
            cr.createAlias("whiskies", "whiskyAlias");
            cr.add(Restrictions.eq("whiskyAlias.year", year));
            result = cr.list();
        }

        catch(HibernateException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Transactional
    public List<Whisky> findWhiskiesWithAge(int age, Long id){
        List<Whisky> results = null;

        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "distilleryAlias");
            cr.add(Restrictions.eq("distilleryAlias.id", id));
            cr.add(Restrictions.eq("age", age));
            results = cr.list();
        }

        catch(HibernateException ex) {
            ex.printStackTrace();
        }

        return results;
    }
}
