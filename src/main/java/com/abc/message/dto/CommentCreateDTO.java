package com.abc.message.dto;


import com.abc.message.entities.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author aravind
 */

@ApiModel(description = "DTO for Create Comment")
public class CommentCreateDTO {

    @NotNull
    @Size(max = 60, message = "Comment cannot have more than 60 characters")
    @ApiModelProperty(notes = "New comment for the Post selected", example = "Awesome!!")
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @NotNull
    @Override
    public String toString() {
        return "CommentCreateDTO{" +
                ", comment='" + comment + '\'' +
                '}';
    }

}

