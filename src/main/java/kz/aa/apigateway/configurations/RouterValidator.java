package kz.aa.apigateway.configurations;

import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.List;


public class RouterValidator {

    private RouterValidator() {
    }

    private static final List<String> OPEN_API_ENDPOINTS = List.of(
            "/auth/register",
            "/auth/login"
    );

    public static boolean isSecured(ServerHttpRequest request) {
        return OPEN_API_ENDPOINTS
                .stream()
                .anyMatch(uri -> request.getURI().getPath().contains(uri));
    }

}