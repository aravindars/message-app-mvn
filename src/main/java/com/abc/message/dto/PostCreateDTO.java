package com.abc.message.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author aravind
 */

@ApiModel(description = "DTO to create a new Post")
public class PostCreateDTO {

    @NotNull
    @Size(max = 60, message = "Post cannot have more than 60 characters")
    @ApiModelProperty(notes = "New Post under topic selected", example = "Marvels End Game")
    private String post;

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public PostCreateDTO(String post) {
        this.post = post;
    }

    @NotNull
    @Override
    public String toString() {
        return "PostCreateDTO{" +
                ", post='" + post + '\'' +
                '}';
    }

}

