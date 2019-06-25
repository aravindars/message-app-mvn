package com.abc.message.services;

import com.abc.message.dto.CommentCreateDTO;
import com.abc.message.dto.CommentQueryDTO;
import com.abc.message.dto.CommentUpdateDTO;
import com.abc.message.entities.Comment;
import com.abc.message.entities.Post;
import com.abc.message.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;

/**
 * @author aravind
 */

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public BigInteger createComment(BigInteger postId, CommentCreateDTO commentCreateDTO) {

        if (commentRepository.findByPostId(postId).size()>0){
        Post post= new Post();
        post.setId(postId);
        Comment newComment = new Comment();
        newComment.setPost(post);
        newComment.setComment(commentCreateDTO.getComment());
        return commentRepository.save(newComment).getId();
        }else{
            throw new EntityNotFoundException("Post ID " + postId.toString() + " not found, Cannot create new comment in the database");
        }

    }

    @Override
    public List<CommentQueryDTO> listAllCommentsByPostId(BigInteger postId) {
        List<CommentQueryDTO> commentList = new ArrayList<>();

        commentRepository.findByPostId(postId).forEach(comment -> {
            commentList.add(new CommentQueryDTO(comment.getId(), comment.getComment()));
        });

        if (commentList.size() > 0){
            return commentList;
        }else{
            throw new EntityNotFoundException("No Comment Found in the Database");
        }
    }

    @Override
    public CommentQueryDTO updateComment(BigInteger id, CommentUpdateDTO commentUpdateDTO) {

        if (commentRepository.findById(id).isPresent()){
            Comment existingComment = commentRepository.findById(id).get();
            existingComment.setComment(commentUpdateDTO.getComment());

            Comment updatedComment= commentRepository.save(existingComment);
            return new CommentQueryDTO(updatedComment.getId(),updatedComment.getComment());
        }else{
            throw new EntityNotFoundException("Comment " + id.toString() + " not found in the database");
        }
    }

    @Override
    public BigInteger deleteComment(BigInteger id) {

        if (commentRepository.findById(id).isPresent()){
            Comment existingComment = commentRepository.findById(id).get();
            commentRepository.delete(existingComment);
            return BigInteger.valueOf(0);
        }else{
            throw new EntityNotFoundException("Comment " + id.toString() + " not found in the database");
        }
    }

}
