package com.abc.message.dto;

import com.abc.message.entities.Post;
import com.abc.message.entities.Topic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.*;
import java.math.BigInteger;

/**
 * @author aravind
 */

@ApiModel(description = "DTO to read Heading information")
public class HeadingQueryDTO {

    @ApiModelProperty(notes = "Unique Id of the Heading")
    private Long id;

    @ApiModelProperty(notes = "Heading Name", example = "Life!!")
    private String headingName;

    private Set<Topic> topics = new HashSet<>();

    public HeadingQueryDTO(Long id, String headingName, Set<Topic> topics) {
        this.id = id;
        this.headingName = headingName;
        this.topics = topics;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeadingName() {
        return headingName;
    }

    public void setHeadingName(String headingName) {
        this.headingName = headingName;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "HeadingQueryDTO{" +
                "id=" + id +
                ", headingName='" + headingName + '\'' +
                '}';
    }
}
