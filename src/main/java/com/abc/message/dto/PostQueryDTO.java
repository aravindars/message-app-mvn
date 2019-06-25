package com.abc.message.dto;

import com.abc.message.entities.Comment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * @author aravind
 */

@ApiModel(description = "DTO to read Post information")
public class PostQueryDTO {

    @ApiModelProperty(notes = "Unique Id of the Post")
    private BigInteger id;

    @ApiModelProperty(notes = "Post name", example = "Game of thrones")
    private String post;

    private Set<Comment> comments = new HashSet<>();

    public PostQueryDTO(BigInteger id, String post, Set<Comment> comments) {
        this.id = id;
        this.post = post;
        this.comments = comments;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "PostQueryDTO{" +
                "id=" + id +
                ", post='" + post + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
