package com.kovbel.agency.entity;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccessDenied implements AccessDeniedHandler {

    private String erorPage;

    public AccessDenied(){
    }

    public AccessDenied(String erorPage){
        this.erorPage = erorPage;
    }

    public String getErorPage(){
        return erorPage;
    }

    public void setErorPage(String erorPage){
        this.erorPage = erorPage;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.sendRedirect(erorPage);

    }
}
