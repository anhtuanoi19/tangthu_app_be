package com.example.tangthu_app_be.service.impl.adnsubjectprovitional;

import com.example.tangthu_app_be.domain.entities.AdnSubjectProvisional;
import com.example.tangthu_app_be.repo.mongorepo.adnsubjectprovitional.AdnSubjectProvitionalRepo;
import com.example.tangthu_app_be.service.abs.adnsubjectprovitional.AdnSubjectProvitionalService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdnSubjectProvitionalServiceImpl implements AdnSubjectProvitionalService {

    private final AdnSubjectProvitionalRepo adnSubjectProvitionalRepo;

    public AdnSubjectProvitionalServiceImpl(AdnSubjectProvitionalRepo adnSubjectProvitionalRepo) {
        this.adnSubjectProvitionalRepo = adnSubjectProvitionalRepo;
    }


    @Override
    public List<AdnSubjectProvisional> getAll() {
        return adnSubjectProvitionalRepo.findAll();
    }
}
