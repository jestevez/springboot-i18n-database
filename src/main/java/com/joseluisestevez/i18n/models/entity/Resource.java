package com.joseluisestevez.i18n.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "resources")
@IdClass(Resource.ResourceId.class)
public class Resource implements Serializable {

    private static final long serialVersionUID = 8246104361834031811L;

    @Id
    @Column(name = "language")
    private String language;
    @Id
    @Column(name = "reference")
    private String reference;
    @Column(name = "value")
    private String value;

    public String getLanguage() {
	return language;
    }

    public void setLanguage(String language) {
	this.language = language;
    }

    public String getReference() {
	return reference;
    }

    public void setReference(String reference) {
	this.reference = reference;
    }

    public String getValue() {
	return value;
    }

    public void setValue(String value) {
	this.value = value;
    }

    public static class ResourceId implements Serializable {

	private static final long serialVersionUID = -8252151790881827124L;

	private String language;

	private String reference;

	public ResourceId() {
	}

	public ResourceId(String language, String reference) {
	    this.language = language;
	    setReference(reference);
	}

	public String getLanguage() {
	    return language;
	}

	public void setLanguage(String language) {
	    this.language = language;
	}

	public String getReference() {
	    return this.reference;
	}

	public void setReference(String reference) {
	    this.reference = reference;
	}

    }
}
