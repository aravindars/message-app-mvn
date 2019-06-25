package com.abc.message.services;

import com.abc.message.dto.PostCreateDTO;
import com.abc.message.dto.PostQueryDTO;
import com.abc.message.dto.PostUpdateDTO;
import com.abc.message.entities.Post;
import com.abc.message.entities.Topic;
import com.abc.message.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;

/**
 * @author aravind
 */


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public BigInteger createPost(Long topicId, PostCreateDTO postCreateDTO) {
        Post newPost = new Post();
        Topic topic = new Topic();
        topic.setId(topicId);
        newPost.setTopic(topic);
        newPost.setPost(postCreateDTO.getPost());
        return postRepository.save(newPost).getId();
    }

    @Override
    public List<PostQueryDTO> listAllPosts() {
        List<PostQueryDTO> postList = new ArrayList<>();
        postRepository.findAll().forEach(post -> {
            postList.add(new PostQueryDTO(post.getId(),post.getPost(),post.getComments()));
        });

        if (postList.size() > 0){
            return postList;
        }else{
            throw new EntityNotFoundException("No post Found in the Database");
        }
    }


    @Override
    public List<PostQueryDTO> listPostbyPostId(Long topicId,BigInteger postId) {
        List<PostQueryDTO> postList = new ArrayList<>();
        if ( postRepository.findByTopicId(topicId).size()>0 && postRepository.findById(postId).isPresent()){
            Post fetchedPost = postRepository.findById(postId).get();
            postList.add(new PostQueryDTO(fetchedPost.getId(), fetchedPost.getPost(),fetchedPost.getComments()));
            return  postList;
        }else{
            throw new EntityNotFoundException("Post Id " + postId.toString() + " not found in the database");
        }
    }

    @Override
    public List<PostQueryDTO> listAllPostsByTopicId(Long topicId) {
        List<PostQueryDTO> postList = new ArrayList<>();
        if(postRepository.findByTopicId(topicId).size()>0)
        {
        postRepository.findByTopicId(topicId).forEach(post -> {
            postList.add(new PostQueryDTO(post.getId(), post.getPost(),post.getComments()));
        });
            return postList;
        }else{
            throw new EntityNotFoundException("No Post Found in the Database");
        }
    }

    @Override
    public Post getPost( BigInteger id) {
        if (postRepository.findById(id).isPresent()){
            Post fetchedPost = postRepository.findById(id).get();
            return  fetchedPost;
        }else{
            throw new EntityNotFoundException("Vehicle Id " + id.toString() + " not found in the database");
        }
    }

    @Override
    public PostQueryDTO updatePost(Long topicId, BigInteger postId, PostUpdateDTO postUpdateDTO) {

        if ( postRepository.findByTopicId(topicId).size()>0 && postRepository.findById(postId).isPresent()){
            Post existingPost = postRepository.findById(postId).get();
            existingPost.setPost(postUpdateDTO.getPost());


            Post updatedPost = postRepository.save(existingPost);
            return new PostQueryDTO(updatedPost.getId(), updatedPost.getPost(),updatedPost.getComments());
        }else{
            throw new EntityNotFoundException("Post " + postId.toString() + " not found in the database");
        }
    }

    @Override
    public BigInteger deletePost(Long topicId, BigInteger postId) {

        if (postRepository.findByTopicId(topicId).size()>0 && postRepository.findById(postId).isPresent()){
            Post existingPost = postRepository.findById(postId).get();
            postRepository.delete(existingPost);
            return BigInteger.valueOf(0);
        }else{
            throw new EntityNotFoundException("Post " + postId.toString() + " not found in the database");
        }
    }

    @Override
    public Post getPostByName(String name) {
        return postRepository.findByPost(name);
    }




}
