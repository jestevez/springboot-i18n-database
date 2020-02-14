package com.joseluisestevez.utils.dto;

public class DtoUtils<D, E> {
    private final Class<D> dtoClass;
    private final Class<E> entityClass;

    public DtoUtils(Class<D> dtoClass, Class<E> entityClass) {
	this.dtoClass = dtoClass;
	this.entityClass = entityClass;
    }

    public D convertToDto(E entity) {
	return ModelMapperWrapper.getModelMapper().map(entity, dtoClass);
    }

    public E convertToEntity(D dto) {
	return ModelMapperWrapper.getModelMapper().map(dto, entityClass);
    }
}
