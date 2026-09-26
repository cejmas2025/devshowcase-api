package com.devshowcase.devshowcase_api.dto;

import jakarta.validation.constraints.NotBlank;

public class FeedbackDTO {

    @NotBlank
    private String author;

    @NotBlank
    private String comment;

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
}