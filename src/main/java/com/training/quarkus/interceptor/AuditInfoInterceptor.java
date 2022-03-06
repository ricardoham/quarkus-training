package com.training.quarkus.interceptor;

import com.training.quarkus.annotation.AuditInfo;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.text.MessageFormat;

@AuditInfo
@Interceptor
@Priority(0)
class AuditInfoInterceptor {

    @AroundInvoke
    public Object logAuditInfo(final InvocationContext context) throws Exception {
        long startTime = System.currentTimeMillis();
        try {
            return context.proceed();
        } finally {
            log(context, startTime);
        }
    }

    private void log(final InvocationContext context, final long startTime) {
        final var auditInfo = context.getMethod().getDeclaredAnnotation(AuditInfo.class);

        long totalTime = System.currentTimeMillis() - startTime;
        String className = context.getMethod().getDeclaringClass().getName();
        String method = context.getMethod().getName();
        System.out.println(MessageFormat.format(">> Method [{0}{1}] annotated with ResourceId=[{2}] and OperationId=[{3}] finished in [{4}] milliseconds.",
                className, method, auditInfo.resourceId(), auditInfo.operation(), totalTime));
    }
}
