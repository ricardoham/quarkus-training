package com.training.quarkus;

import com.training.quarkus.model.CallLog;
import com.training.quarkus.model.Caller;
import com.training.quarkus.service.CallLogService;
import com.training.quarkus.service.CallerService;

import java.util.Scanner;

public class QuarkusTraining {

    public static void main(String[] args) {
        CallerService callerService = CallerService.getInstance();
        CallLogService callLogService = CallLogService.getInstance();

        // A valid phone number to try out: +35199999991

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Enter phone Number: ");
            String phone = in.nextLine();

            if (phone == null || phone.length() == 0) {
                System.out.println("Phone number cannot be blank.\n");
                continue;
            }

            Caller caller = callerService.getCallerByPhone(phone);
            CallLog callLog = callLogService.getCallLogByPhone(phone);

            CallLogService.getInstance().printCallInformation(caller, callLog);
        }
    }
}
