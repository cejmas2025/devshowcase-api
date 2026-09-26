package com.devshowcase.devshowcase_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ProjectDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @Pattern(
    regexp = "^(https?://).+",
    message = "A URL deve começar com http:// ou https://"
)
private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}