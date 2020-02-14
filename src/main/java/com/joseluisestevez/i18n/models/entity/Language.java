package com.joseluisestevez.i18n.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "languages")
public class Language implements Serializable {

    private static final long serialVersionUID = -2266530805372184897L;

    @Id
    @Column(name = "language")
    private String language;

    @Column(name = "parent")
    private String parent;

    @Column(name = "description")
    private String description;

    @Column(name = "is_default")
    private Boolean isDefault;

    public String getParent() {
	return parent;
    }

    public void setParent(String parent) {
	this.parent = parent;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getLanguage() {
	return language;
    }

    public void setLanguage(String language) {
	this.language = language;
    }

    public Boolean getIsDefault() {
	return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
	this.isDefault = isDefault;
    }

}
