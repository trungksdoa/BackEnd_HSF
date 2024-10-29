package com.koisystem.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Around("execution(* com.koisystem.repositories.*.*(..)) || " +
            "execution(* com.koisystem.services.*.*(..))")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        String packageName = signature.getDeclaringType().getPackageName();
        
        // Get parameter names and values
        String[] parameterNames = signature.getParameterNames();
        Object[] parameterValues = joinPoint.getArgs();
        String parameters = formatParameters(parameterNames, parameterValues);
        
        // Get return type
        String returnType = signature.getReturnType().getSimpleName();
        
        // Log method entry
        log.info("\n=== Method Execution Start ===\n" +
                "Timestamp: {}\n" +
                "Package: {}\n" +
                "Class: {}\n" +
                "Method: {}\n" +
                "Return Type: {}\n" +
                "Parameters: {}\n" +
                "==========================",
                LocalDateTime.now().format(formatter),
                packageName,
                className,
                methodName,
                returnType,
                parameters);

        long startTime = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
            
            // Log successful execution
            log.info("\n=== Method Execution Success ===\n" +
                    "Timestamp: {}\n" +
                    "Package: {}\n" +
                    "Class: {}\n" +
                    "Method: {}\n" +
                    "Execution Time: {}ms\n" +
                    "Return Value: {}\n" +
                    "=============================",
                    LocalDateTime.now().format(formatter),
                    packageName,
                    className,
                    methodName,
                    System.currentTimeMillis() - startTime,
                    formatReturnValue(result));
            
            return result;
        } catch (Exception e) {
            // Log error
            log.error("\n=== Method Execution Error ===\n" +
                    "Timestamp: {}\n" +
                    "Package: {}\n" +
                    "Class: {}\n" +
                    "Method: {}\n" +
                    "Execution Time: {}ms\n" +
                    "Error Type: {}\n" +
                    "Error Message: {}\n" +
                    "Stack Trace: {}\n" +
                    "===========================",
                    LocalDateTime.now().format(formatter),
                    packageName,
                    className,
                    methodName,
                    System.currentTimeMillis() - startTime,
                    e.getClass().getSimpleName(),
                    e.getMessage(),
                    formatStackTrace(e));
            throw e;
        }
    }

    private String formatParameters(String[] parameterNames, Object[] parameterValues) {
        if (parameterNames == null || parameterValues == null || parameterNames.length == 0) {
            return "No parameters";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parameterNames.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(parameterNames[i])
              .append("=")
              .append(formatValue(parameterValues[i]));
        }
        return sb.toString();
    }

    private String formatReturnValue(Object result) {
        if (result == null) {
            return "null";
        }
        if (result instanceof Iterable) {
            return "Collection[size=" + ((Iterable<?>) result).spliterator().getExactSizeIfKnown() + "]";
        }
        return result.toString();
    }

    private String formatValue(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof String) {
            return "\"" + value + "\"";
        }
        if (value instanceof Iterable) {
            return "Collection[size=" + ((Iterable<?>) value).spliterator().getExactSizeIfKnown() + "]";
        }
        return value.toString();
    }

    private String formatStackTrace(Exception e) {
        return Arrays.stream(e.getStackTrace())
                .limit(5) // Chỉ lấy 5 dòng đầu tiên của stack trace
                .map(StackTraceElement::toString)
                .collect(Collectors.joining("\n"));
    }
}
