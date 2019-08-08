package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.ast.tree.RestrictableStatement;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> findWhiskiesFromParticularDistilleryWithSpecificAge(String name, int age) {
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);

        Criteria criteria = session.createCriteria(Whisky.class);

        criteria.createAlias("distillery", "distilleryAlias");
        criteria.add(Restrictions.eq("distilleryAlias.name", name));

        criteria.add(Restrictions.eq("age", age));

        result = criteria.list();

        return result;
    };

    @Transactional
    public List<Whisky> findWhiskiesByRegion(String region) {
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);

        Criteria criteria = session.createCriteria(Whisky.class);

        criteria.createAlias("distillery", "distilleryAlias");
        criteria.add(Restrictions.eq("distilleryAlias.region", region));

        result = criteria.list();

        return result;

    };


}