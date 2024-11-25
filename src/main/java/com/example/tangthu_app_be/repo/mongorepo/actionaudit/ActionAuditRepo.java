package com.example.tangthu_app_be.repo.mongorepo.actionaudit;

import com.example.tangthu_app_be.domain.entities.ActionAudit;
import com.example.tangthu_app_be.repo.dao.ActionAudit.ActionAuditCustomerRepo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionAuditRepo extends MongoRepository<ActionAudit, String>, ActionAuditCustomerRepo {
}
