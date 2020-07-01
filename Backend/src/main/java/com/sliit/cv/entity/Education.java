package com.sliit.cv.entity;

import java.util.List;

public class Education {
    public String institution;
    public String area;
    public String gpa;
    public List<String> courses;

    public Education() {
    }

    public Education(String institution, String area, String gpa, List<String> courses) {
        this.institution = institution;
        this.area = area;
        this.gpa = gpa;
        this.courses = courses;
    }
}
