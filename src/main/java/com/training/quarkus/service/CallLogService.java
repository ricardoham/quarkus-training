package com.training.quarkus.service;

import com.training.quarkus.model.CallLog;
import com.training.quarkus.model.Caller;
import com.training.quarkus.repository.CallLogRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CallLogService {

    private CallLogRepository callLogRepository;

    public CallLogService(CallLogRepository callLogRepository) {
        this.callLogRepository = callLogRepository;
    }

    public CallLog getCallLogByPhone(final String phone) {
        return callLogRepository.getCallLogByPhone(phone);
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
}
