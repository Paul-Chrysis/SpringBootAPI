package com.example.demo.logger;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
@Component
public class LoggingFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ContentCachingRequestWrapper contentCachingRequestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper contentCachingResponseWrapper = new ContentCachingResponseWrapper(response);
        filterChain.doFilter(contentCachingRequestWrapper,contentCachingResponseWrapper);
        String requestBody = getStringValue(contentCachingRequestWrapper.getContentAsByteArray(),request.getCharacterEncoding());
        String responseBody = getStringValue(contentCachingResponseWrapper.getContentAsByteArray(),response.getCharacterEncoding());
//        LOGGER.info("PREHANDLE METHOD = {}, REQUEST URI = {}, REQUEST BODY = {}, RESPONSE CODE = {}, RESPONSE BODY = {}",request.getMethod(),request.getRequestURI(),requestBody,response.getStatus(),responseBody);
        if (requestBody.isBlank()) {
            LOGGER.info("Request: {} - {}\nResponse Body: {} - {}", request.getMethod(), request.getRequestURI(), responseBody, response.getStatus());
        }else {
            LOGGER.info("Request: {} - {} | RequestBody {}\nResponse Body: {} - {}", request.getMethod(), request.getRequestURI(), requestBody, responseBody, response.getStatus());
        }
        contentCachingResponseWrapper.copyBodyToResponse();
    }
    private String getStringValue(byte[] contentAsByteArray, String characterEncoding) throws UnsupportedEncodingException {
        try {
            return new String(contentAsByteArray,0, contentAsByteArray.length, characterEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
