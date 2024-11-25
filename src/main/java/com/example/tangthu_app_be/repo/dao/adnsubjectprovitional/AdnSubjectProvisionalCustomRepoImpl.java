package com.example.tangthu_app_be.repo.dao.adnsubjectprovitional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class AdnSubjectProvisionalCustomRepoImpl implements AdnSubjectProvisionalCustomRepo {
    protected final Logger LOG = LogManager.getLogger(this.getClass());
    @PersistenceContext
    private EntityManager em;

}
