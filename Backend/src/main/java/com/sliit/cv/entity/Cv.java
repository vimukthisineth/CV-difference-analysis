package com.sliit.cv.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "cv")
public class Cv {
    public PersonalInfo personalInfo;
    public List<WorkingExperiance> workingExperiences;
    public List<Education> educations;
    public List<Skill> skills;

    public Cv() {
    }

    public Cv(PersonalInfo personalInfo, List<WorkingExperiance> workingExperiences, List<Education> educations, List<Skill> skills) {
        this.personalInfo = personalInfo;
        this.workingExperiences = workingExperiences;
        this.educations = educations;
        this.skills = skills;
    }
}
