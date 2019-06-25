package com.abc.message.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author aravind
 */

@ApiModel(description = "DTO to create a new Topic")
public class TopicCreateDTO {


    @NotNull
    @Size(max = 30, message = "TopicName cannot have more than 30 characters")
    @ApiModelProperty(notes = "Name of the topic", example = "Books")
    private String topicName;

    @NotNull
    @Size(max = 60, message = "Description cannot have more than 60 characters")
    @ApiModelProperty(notes = "Description of the topic", example = "About the topic in 30 words")
    private String description;


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

    @NotNull
    @Override
    public String toString() {
        return "TopicCreateDTO{" +
                ", topicName='" + topicName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}

