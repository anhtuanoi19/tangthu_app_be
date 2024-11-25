package com.example.tangthu_app_be.repo.mongorepo.uploadfile;

import com.example.tangthu_app_be.domain.entities.UploadedFile;
import com.example.tangthu_app_be.repo.dao.uploadfile.UploadFileCustomerRepo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadFileRepo extends MongoRepository<UploadedFile, String>, UploadFileCustomerRepo {
}
