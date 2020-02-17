package com.joseluisestevez.i18n.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.joseluisestevez.i18n.models.dao.ResourceDao;
import com.joseluisestevez.i18n.models.entity.Resource;
import com.joseluisestevez.i18n.service.ResourceService;

@Service
@CacheConfig(cacheNames = { "resources-cache" })
public class ResourceServiceImpl implements ResourceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceServiceImpl.class);

    @Autowired
    private ResourceDao resourceDao;

    @Cacheable
    @Override
    public List<Resource> findAll() {
	LOGGER.info("Cacheable all");
	return (List<Resource>) resourceDao.findAll();
    }

    @Cacheable
    @Override
    public Resource findById(Resource.ResourceId resourceId) {
	LOGGER.info("Cacheable resourceId=[{}]", resourceId);
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

    @Cacheable
    @Override
    public Resource findByLanguageAndReference(String language, String reference) {
	LOGGER.info("Cacheable language=[{}], reference=[{}]", language, reference);
	return resourceDao.findByLanguageAndReference(language, reference);
    }

    @Cacheable
    @Override
    public List<Resource> findByReference(String reference) {
	LOGGER.info("Cacheable reference=[{}]", reference);
	return resourceDao.findByReference(reference);
    }

}
