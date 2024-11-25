package com.example.tangthu_app_be.repo.dao.ActionAudit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActionAuditCustomerRepoImpl implements ActionAuditCustomerRepo {
    protected final Logger LOG = LogManager.getLogger(this.getClass());
    @PersistenceContext
    private EntityManager em;
}
