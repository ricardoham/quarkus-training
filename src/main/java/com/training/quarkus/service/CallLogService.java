package com.training.quarkus.service;

import com.training.quarkus.model.CallLog;
import com.training.quarkus.model.Caller;
import com.training.quarkus.repository.CallLogRepository;

public class CallLogService {

    private static CallLogService instance = null;

    public CallLog getCallLogByPhone(final String phone) {
        return CallLogRepository.getInstance().getCallLogByPhone(phone);
    }

    public void printCallInformation(final Caller caller, final CallLog callLog) {
        if (caller == null && callLog == null) {
            System.out.println("Error: Call Information not found.\n");
        } else {
            System.out.println("Call Log Information:");
            System.out.println("Caller: " + caller);
            System.out.println("Call Log: " + callLog + "\n");
        }
    }

    public static CallLogService getInstance() {
        if (instance == null) {
            instance = new CallLogService();
        }
        return instance;
    }
}
