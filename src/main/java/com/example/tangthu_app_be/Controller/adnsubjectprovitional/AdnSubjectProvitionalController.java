package com.example.tangthu_app_be.Controller.adnsubjectprovitional;

import com.example.tangthu_app_be.domain.entities.AdnSubjectProvisional;
import com.example.tangthu_app_be.service.abs.adnsubjectprovitional.AdnSubjectProvitionalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdnSubjectProvitionalController {

    private final AdnSubjectProvitionalService adnSubjectProvitionalService;

    public AdnSubjectProvitionalController(AdnSubjectProvitionalService adnSubjectProvitionalService) {
        this.adnSubjectProvitionalService = adnSubjectProvitionalService;
    }

    @GetMapping("/adn-subject-provitional")
    public String getAll(Model model){
        List<AdnSubjectProvisional> list = adnSubjectProvitionalService.getAll();

        model.addAttribute("adnSubjectProvitional", list);

        return "adnsubjectprovitional/AdnSubjectProvitional";
    }
}
