package com.joseluisestevez.i18n.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.joseluisestevez.i18n.models.entity.Resource;

public interface ResourceDao extends CrudRepository<Resource, Resource.ResourceId> {
    Resource findByLanguageAndReference(String language, String reference);

    List<Resource> findByReference(String reference);
}
