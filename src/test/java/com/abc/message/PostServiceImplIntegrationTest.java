package com.abc.message;


import com.abc.message.entities.Post;
import com.abc.message.entities.Topic;
import com.abc.message.entities.Heading;
import com.abc.message.repositories.PostRepository;
import com.abc.message.services.*;
import static org.assertj.core.api.Assertions.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author aravind
 */


@RunWith(SpringRunner.class)
public class PostServiceImplIntegrationTest {

    @Autowired
    private PostService postService;
    @MockBean
    private PostRepository postRepository;

    @TestConfiguration
    static class PostServiceImplTestContextConfiguration {

        @Bean
        public PostService postService() {
            return new PostServiceImpl();
        }
    }

    @Before
    public void setUp() {

        Post post = new Post();
        post.setPost("How Game of thrones ended??");
        Mockito.when(postRepository.findByPost("How Game of thrones ended??"))
                .thenReturn(post);
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
           String post = "How Game of thrones ended??";
            Post found= postService.getPostByName(post);

        assertThat(found.getPost())
                .isEqualTo(post);
    }
}