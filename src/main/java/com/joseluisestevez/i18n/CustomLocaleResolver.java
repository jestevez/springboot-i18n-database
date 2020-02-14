package com.joseluisestevez.i18n;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
public class CustomLocaleResolver extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {

    private static final List<Locale> LOCALES = Arrays.asList(new Locale("en"), new Locale("fr"));

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
	String headerLang = request.getHeader("Accept-Language");
	return headerLang == null || headerLang.isEmpty() ? Locale.getDefault()
		: Locale.lookup(Locale.LanguageRange.parse(headerLang), LOCALES);
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