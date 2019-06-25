package com.abc.message.dto;

import com.abc.message.entities.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashSet;
import java.util.Set;

/**
 * @author aravind
 */

@ApiModel(description = "DTO to read Topic information")
public class TopicQueryDTO {

    @ApiModelProperty(notes = "Unique Id of the Topic")
    private Long id;

    @ApiModelProperty(notes = "Topic name", example = "Society")
    private String topicName;

    @ApiModelProperty(notes = "Description about topic", example = "About Society")
    private String description;

    private Set<Post> posts = new HashSet<>();

    public TopicQueryDTO(Long id, String topicName, String description, Set<Post> posts) {
        this.id = id;
        this.topicName = topicName;
        this.description = description;
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "TopicQueryDTO{" +
                "id=" + id +
                ", topicName='" + topicName + '\'' +
                ", description='" + description + '\'' +
                ", posts=" + posts +
                '}';
    }
}
