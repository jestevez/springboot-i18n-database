package com.joseluisestevez.i18n.service;

public interface I18nResourcesService {

    String getMessage(String value, String defaultValue);

    String getMessage(String value, String defaultValue, String language);

    void clearCache();
}
