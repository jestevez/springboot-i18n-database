package com.joseluisestevez.i18n.service;

import java.util.List;

import com.joseluisestevez.i18n.models.entity.Language;

public interface LanguageService {

    List<Language> findAll();

    Language findById(String id);

    Language save(Language language);

    void deleteById(String id);

    Language findByIsDefault(Boolean isDefault);
}
