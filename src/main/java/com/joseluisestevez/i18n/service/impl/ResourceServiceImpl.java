package com.joseluisestevez.i18n.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseluisestevez.i18n.models.dao.ResourceDao;
import com.joseluisestevez.i18n.models.entity.Resource;
import com.joseluisestevez.i18n.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public List<Resource> findAll() {
	return (List<Resource>) resourceDao.findAll();
    }

    @Override
    public Resource findById(Resource.ResourceId resourceId) {
	return resourceDao.findById(resourceId).orElse(null);
    }

    @Override
    public Resource save(Resource resource) {
	return resourceDao.save(resource);
    }

    @Override
    public void deleteById(Resource.ResourceId resourceId) {
	resourceDao.deleteById(resourceId);
    }

    @Override
    public Resource findByLanguageAndReference(String language, String reference) {
	return resourceDao.findByLanguageAndReference(language, reference);
    }

    @Override
    public List<Resource> findByReference(String reference) {
	return resourceDao.findByReference(reference);
    }

}
