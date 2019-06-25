package com.abc.message.controllers;

import com.abc.message.dto.CommentCreateDTO;
import com.abc.message.dto.CommentQueryDTO;
import com.abc.message.dto.CommentUpdateDTO;
import com.abc.message.services.CommentService;
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
@RequestMapping(value = "/api/posts/{postId}/comments")
@Api(tags = "Comments", value = "Comments", description = "Controller for Comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "List all Comments by PostId")
    public ResponseEntity<List<CommentQueryDTO>> listAllCommentsByPostId(@PathVariable(value = "postId") BigInteger postId) {
        return new ResponseEntity<>(commentService.listAllCommentsByPostId(postId), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a new Comment for the Post")
    public ResponseEntity<BigInteger> createComment(@PathVariable(value = "postId") BigInteger postId,
                                                    @Valid @RequestBody CommentCreateDTO commentCreateDTO) {
        return new ResponseEntity<>(commentService.createComment(postId, commentCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{commentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update an existing Comment of the post")
    public ResponseEntity<CommentQueryDTO> updateComment(@PathVariable(value = "commentId") BigInteger commentId,
                                                         @RequestBody CommentUpdateDTO commentUpdateDTO) {
        return new ResponseEntity<>(commentService.updateComment(commentId, commentUpdateDTO), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{commentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete the Comment")
    public ResponseEntity<BigInteger> deleteComment(@PathVariable(value = "commentId") BigInteger postId) {
        return new ResponseEntity<>(commentService.deleteComment(postId), HttpStatus.OK);
    }

}
