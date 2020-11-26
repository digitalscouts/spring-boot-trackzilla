package com.pluralsight.fundamentals.services;

import com.pluralsight.fundamentals.entity.Application;
import com.pluralsight.fundamentals.exception.ApplicationNotFoundException;
import com.pluralsight.fundamentals.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public List<Application> listApplications() {
        return (List<Application>) applicationRepository.findAll();
    }

    @Override
    public Application findApplication(long id) {
        Optional<Application> optionalApplication = applicationRepository.findById(id);
        if(optionalApplication.isPresent())
            return optionalApplication.get(); //get() is used to fetch the value of an optional instance. If no value is present will throw NullPointerException
        else
            throw new ApplicationNotFoundException("Application not found");
    }
}
