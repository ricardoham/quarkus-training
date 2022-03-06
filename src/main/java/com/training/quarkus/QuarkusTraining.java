package com.training.quarkus;

import com.training.quarkus.annotation.AuditInfo;
import com.training.quarkus.model.CallLog;
import com.training.quarkus.model.Caller;
import com.training.quarkus.service.CallLogService;
import com.training.quarkus.service.CallerService;

import java.util.Arrays;
import java.util.Scanner;

public class QuarkusTraining {

    public static void main(String[] args) {
        CallerService callerService = CallerService.getInstance();
        CallLogService callLogService = CallLogService.getInstance();


        // About Java Reflections
        // Using Evaluate Expression:

        // Print all annotated methods for the given class. CHECK CONSOLE
        Arrays.stream(callerService.getClass().getMethods()).forEach(method -> System.out.println(Arrays.toString(method.getAnnotations())));

        // Annotation from the method
        final var auditInfo = callerService.getClass().getMethods()[1].getAnnotation(AuditInfo.class);
        System.out.println("Operation: " + auditInfo.operation() + ", ResourceId: " + auditInfo.resourceId());

        // A valid phone number to try out: +35199999991

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Enter phone Number: ");
            String phone = in.nextLine();

            Caller caller = callerService.getCallerByPhone(phone);
            CallLog callLog = callLogService.getCallLogByPhone(phone);

            CallLogService.getInstance().printCallInformation(caller, callLog);
            System.out.println();
        }
    }
}
