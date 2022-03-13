package com.training.quarkus.service;

import com.training.quarkus.model.Caller;
import com.training.quarkus.repository.CallerRepository;

public class CallerService {

    private static CallerService instance = null;

    public Caller getCallerByPhone(final String phone) {
        return CallerRepository.getInstance().getCallerByPhone(phone);
    }

    public static CallerService getInstance() {
        if (instance == null) {
            instance = new CallerService();
        }
        return instance;
    }
}
