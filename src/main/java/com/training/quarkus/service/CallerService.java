package com.training.quarkus.service;

import com.training.quarkus.model.Caller;

public class CallerService {

    public static CallerService callerService = null;

    public Caller getCallerByPhone(final String phone) {
        // FIXME Invoke method repository here.
        return null;
    }

    public static CallerService getInstance() {
        //FIXME
        return callerService;
    }
}
