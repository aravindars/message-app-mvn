package com.abc.message.services;

import com.abc.message.dto.*;
import com.abc.message.entities.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

/**
 * @author aravind
 */

public interface PostService {
    BigInteger createPost(Long postId, PostCreateDTO postCreateDTO);
    List<PostQueryDTO> listAllPostsByTopicId(Long topicId);
    List<PostQueryDTO> listPostbyPostId(Long topicId, BigInteger postId);
    List<PostQueryDTO> listAllPosts();
    PostQueryDTO updatePost(Long topicId, BigInteger postId, PostUpdateDTO postUpdateDTO);
    BigInteger deletePost(Long topicId, BigInteger postId);
    Post getPost(BigInteger id);
    Post getPostByName(String name);
}
