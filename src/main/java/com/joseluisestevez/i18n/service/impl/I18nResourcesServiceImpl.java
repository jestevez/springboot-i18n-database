package com.joseluisestevez.i18n.service.impl;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.joseluisestevez.i18n.models.entity.Language;
import com.joseluisestevez.i18n.models.entity.Resource;
import com.joseluisestevez.i18n.service.I18nResourcesService;
import com.joseluisestevez.i18n.service.LanguageService;
import com.joseluisestevez.i18n.service.ResourceService;

@Service
public class I18nResourcesServiceImpl implements I18nResourcesService {
    private static final Logger LOGGER = LoggerFactory.getLogger(I18nResourcesServiceImpl.class);

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private LanguageService languageService;

    @Override
    public String getMessage(String value, String defaultValue) {
	Locale currentLocale = LocaleContextHolder.getLocale();
	LOGGER.info("currentLocale [{}]", currentLocale);
	return getMessage(value, defaultValue, currentLocale.getLanguage());
    }

    private String getMessageByLanguageAndReference(String language, String reference, String defaultValue) {
	Language languageDB = languageService.findById(language);
	if (languageDB == null || language == null) {
	    Language languageDefault = languageService.findByIsDefault(true);
	    language = languageDefault.getLanguage();
	}
	Resource resource = resourceService.findByLanguageAndReference(language, reference);
	if (resource == null) {
	    Language languageObj = languageService.findById(language);
	    if (languageObj == null || languageObj.getParent() == null) {
		return defaultValue;
	    }
	    return getMessageByLanguageAndReference(languageObj.getParent(), reference, defaultValue);
	} else {
	    return resource.getValue();
	}
    }

    @Override
    public String getMessage(String value, String defaultValue, String language) {
	LOGGER.info("language [{}]", language);
	return getMessageByLanguageAndReference(language, value, defaultValue);
    }

}
