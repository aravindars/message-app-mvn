package com.abc.message.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigInteger;

/**
 * @author aravind
 */

@ApiModel(description = "DTO for read Comment information")
public class CommentQueryDTO {

    @ApiModelProperty(notes = "Unique Id of the Comment")
    private BigInteger id;

    @ApiModelProperty(notes = "Comment for the post", example = "Awesomee!!")
    private String comment;


    public CommentQueryDTO(BigInteger id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "CommentQueryDTO{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
