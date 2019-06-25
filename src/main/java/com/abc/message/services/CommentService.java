package com.abc.message.services;


import com.abc.message.dto.CommentCreateDTO;
import com.abc.message.dto.CommentQueryDTO;
import com.abc.message.dto.CommentUpdateDTO;
import com.abc.message.dto.PostCreateDTO;
import com.abc.message.entities.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.math.BigInteger;
import java.util.List;

/**
 * @author aravind
 */

public interface CommentService {
    BigInteger createComment(BigInteger id, CommentCreateDTO commentCreateDTO);
    List<CommentQueryDTO> listAllCommentsByPostId(BigInteger postId);
    CommentQueryDTO updateComment(BigInteger id, CommentUpdateDTO commentUpdateDTO);
    BigInteger deleteComment(BigInteger id);

}
