package com.devshowcase.devshowcase_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FeedbackDTO {

@NotBlank
private String author;

@NotBlank
private String comment;

@NotNull
private Long projectId;

public String getAuthor() {
    return author;
}

public void setAuthor(String author) {
    this.author = author;
}

public String getComment() {
    return comment;
}

public void setComment(String comment) {
    this.comment = comment;
}

public Long getProjectId() {
    return projectId;
}

public void setProjectId(Long projectId) {
    this.projectId = projectId;
}

}