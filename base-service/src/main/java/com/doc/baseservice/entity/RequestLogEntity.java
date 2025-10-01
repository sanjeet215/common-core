package com.doc.baseservice.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Map;


@Entity
@Table(name = "request_logs")
public class RequestLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;        // When request was received
    private String httpMethod;              // GET, POST, PUT, DELETE etc.
    private String requestUri;              // Full request URI with path and query string
//    private Map<String, String> headers;   // Request headers
//    private Map<String, String> parameters; // Query parameters or form parameters
    private String remoteIpAddress;        // Client IP address
    private String userAgent;              // User-Agent header
    private String contentType;            // Request Content-Type
    private long contentLength;            // Request content length in bytes
    private String requestBody;            // Request body content (optional, maybe truncated or sanitized)
    private String sessionId;              // HTTP session ID if applicable
    private String authenticatedUser;     // Authenticated username or JWT subject if available
    private long processingTimeMs;         // Time taken to process the request

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getRemoteIpAddress() {
        return remoteIpAddress;
    }

    public void setRemoteIpAddress(String remoteIpAddress) {
        this.remoteIpAddress = remoteIpAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getAuthenticatedUser() {
        return authenticatedUser;
    }

    public void setAuthenticatedUser(String authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }

    public long getProcessingTimeMs() {
        return processingTimeMs;
    }

    public void setProcessingTimeMs(long processingTimeMs) {
        this.processingTimeMs = processingTimeMs;
    }
}
