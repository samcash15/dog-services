package com.cashion.dog.dogservices.security.service;

import com.cashion.dog.dogservices.security.ApiKeyAuthentication;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Value("${security.api-key-header-name}")
    private String apiHeaderName;
    @Value("${security.api.key}")
    private String apiKey;

    public Authentication getAuthentication(HttpServletRequest request) {
        String key = request.getHeader(apiHeaderName);
        if (key == null || !key.equals(apiKey)) {
            throw new BadCredentialsException("Invalid API Key");
        }

        return new ApiKeyAuthentication(key, AuthorityUtils.NO_AUTHORITIES);
    }
}
