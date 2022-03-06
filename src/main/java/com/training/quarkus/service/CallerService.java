package com.training.quarkus.service;

import com.training.quarkus.model.Caller;
import com.training.quarkus.repository.CallerRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CallerService {

    private CallerRepository callerRepository;

    public CallerService(CallerRepository callerRepository) {
        this.callerRepository = callerRepository;
    }

    public Caller getCallerByPhone(final String phone) {
        return callerRepository.getCallerByPhone(phone);
    }
}
