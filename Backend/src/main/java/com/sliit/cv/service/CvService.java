package com.sliit.cv.service;

import com.sliit.cv.entity.Cv;
import com.sliit.cv.entity.Skill;

import java.util.List;

public interface CvService {

    public List<Skill> getMatchingSkillList(Cv testCv, List<Cv> cvs);

}
