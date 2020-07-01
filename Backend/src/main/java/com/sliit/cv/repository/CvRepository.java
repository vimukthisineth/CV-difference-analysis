package com.sliit.cv.repository;

import com.sliit.cv.entity.Cv;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CvRepository extends MongoRepository<Cv, String> {}
