package com.abc.message.controllers;

import com.abc.message.dto.PostCreateDTO;
import com.abc.message.dto.PostQueryDTO;
import com.abc.message.dto.PostUpdateDTO;
import com.abc.message.services.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

/**
 * @author aravind
 */

@RestController
@RequestMapping(value = "/api/topics/{topicId}/posts")
@Api(tags = "Posts", value = "Posts", description = "Controller for Posts")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all Posts by Topic Id")
    public ResponseEntity<List<PostQueryDTO>> listAllPostsByTopicId(@PathVariable(value = "topicId") Long topicId) {
        return new ResponseEntity<>(postService.listAllPostsByTopicId(topicId), HttpStatus.OK);
    }

    @GetMapping(value = "/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get post by post Id")
    public ResponseEntity<List<PostQueryDTO>> listPostbyPostId(@PathVariable(value = "topicId") Long topicId, @PathVariable(value = "postId") BigInteger postId) {
        return new ResponseEntity<>(postService.listPostbyPostId(topicId, postId), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a new Post")
    public ResponseEntity<BigInteger> createPost(@PathVariable(value = "topicId") Long topicId,
                                                 @Valid @RequestBody PostCreateDTO postCreateDTO) {
        return new ResponseEntity<>(postService.createPost(topicId, postCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update an existing Post")
    public ResponseEntity<PostQueryDTO> updatePost(@PathVariable(value = "topicId") Long topicId, @PathVariable(value = "postId") BigInteger postId,
                                                   @RequestBody PostUpdateDTO postUpdateDTO) {
        return new ResponseEntity<>(postService.updatePost(topicId, postId, postUpdateDTO), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Create a delete Post")
    public ResponseEntity<BigInteger> deletePost(@PathVariable(value = "topicId") Long topicId, @PathVariable(value = "postId") BigInteger postId) {
        return new ResponseEntity<>(postService.deletePost(topicId, postId), HttpStatus.OK);
    }

}