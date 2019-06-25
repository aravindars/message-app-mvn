package com.abc.message.controllers;

import com.abc.message.dto.TopicCreateDTO;
import com.abc.message.dto.TopicQueryDTO;
import com.abc.message.services.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author aravind
 */


@RestController
@RequestMapping(value = "/api/headings/{headingId}/topics")
@Api(tags = "Topic", value = "Topics", description = "Controller for Topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a new Topic")
    public ResponseEntity<Long> createTopic(@PathVariable(value = "headingId") Long headingId, @Valid @RequestBody TopicCreateDTO topicCreateDTO) {
        return new ResponseEntity<>(topicService.createTopic(headingId, topicCreateDTO), HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all Posts by Topic Id")
    public ResponseEntity<List<TopicQueryDTO>> listAllTopicsByHeadingId(@PathVariable(value = "headingId") Long headingId) {
        return new ResponseEntity<>(topicService.listAllTopicsByHeadingId(headingId), HttpStatus.OK);
    }

    @GetMapping(value = "/{topicId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get post by post Id")
    public ResponseEntity<List<TopicQueryDTO>> listTopicByTopicId(@PathVariable(value = "headingId") Long headingId, @PathVariable(value = "topicId") Long topicId) {
        return new ResponseEntity<>(topicService.listTopicByTopicId(headingId, topicId), HttpStatus.OK);
    }

}
