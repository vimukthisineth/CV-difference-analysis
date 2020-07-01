package com.sliit.cv.service;

import com.sliit.cv.entity.Cv;
import com.sliit.cv.entity.Skill;
import com.sliit.cv.enums.SkillKeywords;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("cvService")
public class CvServiceImpl implements CvService {
    @Override
    public List<Skill> getMatchingSkillList(Cv testCv, List<Cv> cvs) {
        List<Skill> matchingSkills = new ArrayList<>();
        for (Cv cv : cvs){
            List<Skill> skills = cv.skills;
            for (Skill requiredSkill : skills){
                for (SkillKeywords requiredSkillKeyword : requiredSkill.keywords){
                    for (Skill testSkill : testCv.skills){
                        for (SkillKeywords testSkillKeyword : testSkill.keywords){
                            if (requiredSkillKeyword == testSkillKeyword){
                                matchingSkills.add(testSkill);
                            }
                        }
                    }
                }
            }
        }
        return matchingSkills;
    }
}
