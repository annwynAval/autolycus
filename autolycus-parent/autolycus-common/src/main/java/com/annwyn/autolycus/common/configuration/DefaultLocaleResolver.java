package com.annwyn.autolycus.common.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class DefaultLocaleResolver implements LocaleResolver {

    private final Logger logger = LoggerFactory.getLogger(DefaultLocaleResolver.class);

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getHeader(HttpHeaders.ACCEPT_LANGUAGE);
        if(!StringUtils.isEmpty(language) && language.contains("-")) {
            return this.resolveLocale(language);
        }
        return Locale.getDefault();
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }

    private Locale resolveLocale(String language) {
        try {
            String[] templates = language.split("-");
            return new Locale(templates[0], templates[1]);
        } catch(Exception e) {
            return Locale.getDefault();
        }
    }
}
