package com.invo.matchela.authorization.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Rujan Maharjan on  6/12/2021
 **/
@Component
@Slf4j
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        Exception exception = (Exception) request.getAttribute("exception");

        String message;
        Map<String, Object> map = new HashMap<>();
        map.put("code", 401);


        if (exception != null) {
            map.put("message", exception.getMessage());
            byte[] body = new ObjectMapper().writeValueAsBytes(map);
            log.error("JWT Exceptions:::: {}", exception.getMessage());
            response.getOutputStream().write(body);

        } else {

            if (authException.getCause() != null) {
                message = authException.getCause().toString() + " " + authException.getMessage();
            } else {
                message = authException.getMessage();
            }

            map.put("message", message);
            byte[] body = new ObjectMapper().writeValueAsBytes(map);
            log.error("Auth Exceptions:::: {}", message);

            response.getOutputStream().write(body);
        }
    }

}
