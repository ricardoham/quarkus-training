package com.training.quarkus;

import com.training.quarkus.model.CallLog;
import com.training.quarkus.model.Caller;
import com.training.quarkus.service.CallLogService;
import com.training.quarkus.service.CallerService;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Scanner;


@QuarkusMain
public class QuarkusTraining {

    public static void main(String... args) {
        Quarkus.run(QuarkusApp.class, args);
    }

    @ApplicationScoped
    public static class QuarkusApp implements QuarkusApplication {

        private final CallLogService callLogService;
        private final CallerService callerService;

        @Inject
        public QuarkusApp(final CallLogService callLogService, final CallerService callerService) {
            this.callLogService = callLogService;
            this.callerService = callerService;
        }

        @Override
        public int run(String... args) {

            Scanner in = new Scanner(System.in);

            // A valid phone number to try out: +35199999991

            while (true) {
                System.out.print("Enter phone Number: ");
                String phone = in.nextLine();

                if (phone == null || phone.length() == 0) {
                    System.out.println("Phone number cannot be blank.\n");
                    continue;
                }

                Caller caller = callerService.getCallerByPhone(phone);
                CallLog callLog = callLogService.getCallLogByPhone(phone);

                callLogService.printCallInformation(caller, callLog);

                System.out.println();
            }
        }
    }
}