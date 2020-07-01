package com.sliit.cv.controller;

import com.sliit.cv.entity.Cv;
import com.sliit.cv.entity.Skill;
import com.sliit.cv.repository.CvRepository;
import com.sliit.cv.service.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CvController {

    @Autowired
    CvRepository cvRepository;

    @Autowired
    CvService cvService;

    @PostMapping("/newCv")
    public Cv createCv(@RequestBody Cv cv){
        return cvRepository.save(cv);
    }

    @PostMapping("/testMatchingSkills")
    public List<Skill> testMatchingSkills(@RequestBody Cv cv){
        return cvService.getMatchingSkillList(cv, cvRepository.findAll());
    }

}
