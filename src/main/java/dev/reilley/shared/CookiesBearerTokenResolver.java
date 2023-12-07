package dev.reilley.shared;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.oauth2.server.resource.web.BearerTokenResolver;

import java.util.Arrays;

public class CookiesBearerTokenResolver implements BearerTokenResolver {
    @Override
    public String resolve(final HttpServletRequest request) {
        return resolveFromAccessTokenCookie(request);
    }

    public String resolveFromAccessTokenCookie(HttpServletRequest request) {
        if (request.getCookies() == null) return null;
        return Arrays.stream(request.getCookies()).filter(cookie -> cookie.getName().equals("AccessToken")).findFirst().map(Cookie::getValue).orElse(null);
    }
}
