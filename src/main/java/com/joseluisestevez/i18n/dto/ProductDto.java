package com.joseluisestevez.i18n.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joseluisestevez.i18n.utils.JsonInternationalized;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    @Getter(AccessLevel.PUBLIC)
    private Long id;
    @JsonInternationalized
    @NotNull
    private String name;
    @NotNull
    private Double price;

    private Date createAt;
    @JsonIgnore
    private Integer port;

}