package com.sliit.cv.entity;

import com.sliit.cv.enums.SkillKeywords;

import java.util.List;

public class Skill {
    public String name;
    public String level;
    public List<SkillKeywords> keywords;

    public Skill() {
    }

    public Skill(String name, String level, List<SkillKeywords> keywords) {
        this.name = name;
        this.level = level;
        this.keywords = keywords;
    }
}
