package com.abc.message.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author aravind
 */

@ApiModel(description = "DTO to update an existing Vehicle")
public class PostUpdateDTO {

    @NotNull
    @Size(max = 60, message = "Post cannot have more than 60 characters")
    @ApiModelProperty(notes = "Post under topic selected", example = "Man from Earth!")
    private String post;


    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @NotNull
    @Override
    public String toString() {
        return "PostUpdateDTO{" +
                "post='" + post + '\'' +
                '}';
    }
}
