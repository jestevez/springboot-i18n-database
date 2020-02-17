package com.joseluisestevez.i18n.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.joseluisestevez.i18n.models.dao.LanguageDao;
import com.joseluisestevez.i18n.models.entity.Language;
import com.joseluisestevez.i18n.service.LanguageService;

@Service
@CacheConfig(cacheNames = { "languages-cache" })
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageDao languageDao;

    @Cacheable
    @Override
    public List<Language> findAll() {
	return (List<Language>) languageDao.findAll();
    }

    @Cacheable
    @Override
    public Language findById(String id) {
	return languageDao.findById(id).orElse(null);
    }

    @Override
    public Language save(Language language) {
	return languageDao.save(language);
    }

    @Override
    public void deleteById(String id) {
	languageDao.deleteById(id);
    }

    @Override
    public Language findByIsDefault(Boolean isDefault) {
	return languageDao.findByIsDefault(isDefault);
    }

}
