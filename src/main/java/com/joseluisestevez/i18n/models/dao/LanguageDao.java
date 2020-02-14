package com.joseluisestevez.i18n.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.joseluisestevez.i18n.models.entity.Language;

public interface LanguageDao extends CrudRepository<Language, String> {

}
