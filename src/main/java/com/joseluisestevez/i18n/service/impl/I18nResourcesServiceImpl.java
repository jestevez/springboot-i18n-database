package com.joseluisestevez.i18n.service.impl;

import java.util.List;
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

    @Override
    public String getMessage(String value, String defaultValue, String language) {
	// TODO This method
	LOGGER.info("language [{}]", language);
	Resource resource = resourceService.findByLanguageAndReference(language, value);
	if (resource == null) {

	    Language languageObj = languageService.findById(language);
	    if (languageObj != null) {
		resource = resourceService.findByLanguageAndReference(languageObj.getLanguage(), value);
	    }

	    if (resource == null) {
		List<Resource> list = resourceService.findByReference(value);
		for (Resource r : list) {
		    return r.getValue();
		}

		return defaultValue;
	    }

	}
	return resource.getValue();
    }

    @Override
    public void clearCache() {
	// TODO Auto-generated method stub

    }

}
