package com.abc.message.repositories;

import com.abc.message.entities.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.math.BigInteger;
import java.util.List;

/**
 * @author aravind
 */

@RepositoryRestResource(collectionResourceRel = "posts", path = "posts")
public interface PostRepository extends CrudRepository<Post, BigInteger> {
    List<Post> findByTopicId(Long topicId);
    Post findByPost(String post);
}
