package com.abc.message;


import static org.assertj.core.api.Assertions.*;

import java.math.BigInteger;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


import com.abc.message.entities.Post;
import com.abc.message.entities.Topic;
import com.abc.message.entities.Heading;
import com.abc.message.repositories.PostRepository;

/**
 * @author aravind
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {
 
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private PostRepository postRepository;
 
    @Test
    public void whenFindById_thenReturnPost() {
        // given

        Heading heading = new Heading();

        heading.setHeadingName("Entertainment");

        entityManager.persist(heading);

        Topic topic = new Topic();
        topic.setHeading(heading);
        topic.setTopicName("Books");
        topic.setDescription("Book related messages under books topic");

        entityManager.persist(topic);

        Post post = new Post();

        post.setTopic(topic);
        post.setPost("How Game of thrones ended??");
        entityManager.persist(post);
        entityManager.flush();
     
        // when
        Optional<Post> found = postRepository.findById(new BigInteger("1")) ;
     
        assertThat(found.get().getPost())
          .isEqualTo(post.getPost());
    }


 
}
