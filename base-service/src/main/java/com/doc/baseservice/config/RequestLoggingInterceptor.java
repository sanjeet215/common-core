package com.doc.baseservice.config;

import com.doc.baseservice.entity.RequestLogEntity;
import com.doc.baseservice.repository.RequestLogRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class RequestLoggingInterceptor implements HandlerInterceptor {

    private static final String START_TIME = "startTime";

    private final RequestLogRepository repository;

    public RequestLoggingInterceptor(RequestLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute(START_TIME, Instant.now());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        Instant start = (Instant) request.getAttribute(START_TIME);
        LocalDateTime startDateTime = LocalDateTime.ofInstant(start, ZoneId.systemDefault());
        long durationMs = Instant.now().toEpochMilli() - start.toEpochMilli();

        RequestLogEntity logDto = new RequestLogEntity();
        logDto.setTimestamp(startDateTime);
        logDto.setHttpMethod(request.getMethod());
        logDto.setRequestUri(request.getRequestURI());
        logDto.setRemoteIpAddress(request.getRemoteAddr());
        logDto.setUserAgent(request.getHeader("User-Agent"));
        logDto.setContentType(request.getContentType());

        // Add headers or parameters as needed
        // Example: logDto.setHeaders(copyHeaders(request));

        logDto.setProcessingTimeMs(durationMs);
        repository.save(logDto);
    }
}
