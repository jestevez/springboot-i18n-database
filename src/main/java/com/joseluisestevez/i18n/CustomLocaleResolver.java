package com.joseluisestevez.i18n;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
public class CustomLocaleResolver extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {
    private static final List<Locale> LOCALES = Arrays.asList(new Locale("es"), new Locale("en"), new Locale("fr"));
    private static final Locale DEFAULT_LOCALE = new Locale("es");

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
	if (StringUtils.isEmpty(request.getHeader("Accept-Language"))) {
	    return DEFAULT_LOCALE;
	}
	String headerLang = request.getHeader("Accept-Language");
	Locale headerLocale = new Locale(headerLang);
	if (!LOCALES.contains(headerLocale)) {
	    return DEFAULT_LOCALE;
	}
	return Locale.lookup(Locale.LanguageRange.parse(headerLang), LOCALES);
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
	ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
	rs.setBasename("messages");
	rs.setDefaultEncoding("UTF-8");
	rs.setUseCodeAsDefaultMessage(true);
	return rs;
    }

}