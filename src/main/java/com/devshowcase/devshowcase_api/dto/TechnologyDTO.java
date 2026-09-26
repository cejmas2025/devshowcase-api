package com.devshowcase.devshowcase_api.dto;

import jakarta.validation.constraints.NotBlank;

public class TechnologyDTO {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}