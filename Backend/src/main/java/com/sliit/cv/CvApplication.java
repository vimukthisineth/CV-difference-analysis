package com.sliit.cv;

import com.sliit.cv.entity.*;
import com.sliit.cv.enums.SkillKeywords;
import com.sliit.cv.repository.CvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CvApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CvApplication.class, args);
	}

	@Autowired
	private CvRepository repository;

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();

		PersonalInfo personalInfo = new PersonalInfo("Manoj Niranthaka", "manojniranthaka@gmail.com", "0766703899");

		List<WorkingExperiance> workingExperiances = new ArrayList<>();
		workingExperiances.add(new WorkingExperiance("TechwireLanka", "Traineer software engineer", "6 months"));

		List<Education> educations = new ArrayList<>();
		List<String> courses = new ArrayList<>();
		courses.add("AWS course");
		courses.add("java course");
		educations.add(new Education("SlIIT", "Software Development", "3.0", courses));

		List<Skill> skills = new ArrayList<>();
		List<SkillKeywords> skillKeywords = new ArrayList<>();
		skillKeywords.add(SkillKeywords.HTML);
		skillKeywords.add(SkillKeywords.CSS);
		skillKeywords.add(SkillKeywords.JAVASCRIPT);
		skills.add(new Skill("Web Development", "Master", skillKeywords));

		repository.save(new Cv(personalInfo, workingExperiances, educations, skills));

	}
}
