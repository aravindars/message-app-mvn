package com.abc.message.repositories;

import com.abc.message.entities.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;


/**
 * @author aravind
 */

@Repository
public interface CommentRepository extends JpaRepository<Comment, BigInteger> { ;
     List<Comment> findByPostId(BigInteger postId);
}