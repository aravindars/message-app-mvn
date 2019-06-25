package com.abc.message.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author aravind
 */

@ApiModel(description = "Model to Update exisiting Comment")
public class CommentUpdateDTO {

    @NotNull
    @Size(max = 60, message = "Comment cannot have more than 60 characters")
    @ApiModelProperty(notes = "Update the Comment of the post", example = "Awesome!!")
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
        return "CommentUpdateDTO{" +
                ", comment='" + comment + '\'' +
                '}';
    }

}

