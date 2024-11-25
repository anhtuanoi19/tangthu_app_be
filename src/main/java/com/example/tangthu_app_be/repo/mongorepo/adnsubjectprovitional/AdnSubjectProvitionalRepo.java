package com.example.tangthu_app_be.repo.mongorepo.adnsubjectprovitional;

import com.example.tangthu_app_be.domain.entities.AdnSubjectProvisional;
import com.example.tangthu_app_be.repo.dao.adnsubjectprovitional.AdnSubjectProvisionalCustomRepo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdnSubjectProvitionalRepo extends MongoRepository<AdnSubjectProvisional, String>, AdnSubjectProvisionalCustomRepo {
}
