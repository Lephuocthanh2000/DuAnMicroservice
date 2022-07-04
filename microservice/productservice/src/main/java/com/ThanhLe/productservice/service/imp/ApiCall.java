package com.ThanhLe.productservice.service.imp;

import com.ThanhLe.productservice.model.Categories;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class ApiCall {
    private static final Logger logger = LoggerFactory.getLogger(ApiCall.class);
    @Autowired
    RestTemplate restTemplate;

    private static final String courseMisroserviceBaseURL =
            "lb://categories-service";

    @CircuitBreaker(name = "example", fallbackMethod="fallback")
    public Categories getCourseDetails(int categoryId) {
        logger.info("calling course microservice API using RestTemplate");

        Categories categories = restTemplate.getForObject(
                courseMisroserviceBaseURL + "/categories/id?id={categoryId}",
                Categories.class, categoryId);
        return categories;
    }

    public Categories fallback(Exception ex) {
        logger.info("calling fallback and returning default course data");
        Categories categories = new Categories();
//        course.setId(1);
//        course.setName("common-course");
//        course.setDuration(1);
        return categories;
    }
}
