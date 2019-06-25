package com.abc.message;

import com.abc.message.entities.Comment;
import com.abc.message.entities.Heading;
import com.abc.message.entities.Post;
import com.abc.message.entities.Topic;
import com.abc.message.repositories.CommentRepository;
import com.abc.message.repositories.HeadingRepository;
import com.abc.message.repositories.PostRepository;
import com.abc.message.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author aravind
 */

@SpringBootApplication
@EnableJpaAuditing
public class MessageBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageBoardApplication.class, args);
    }

}

@Component
class MessageBoardCommandLineRunner implements CommandLineRunner {


    @Autowired
    private HeadingRepository headingRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public void run(String... args) throws Exception {

        Heading heading = new Heading();

        heading.setHeadingName("Entertainment");

        headingRepository.save(heading);

        Topic topic = new Topic();
        topic.setHeading(heading);
        topic.setTopicName("Books");
        topic.setDescription("Book related messages under books topic");

        topicRepository.save(topic);

        Post post = new Post();

        post.setTopic(topic);
        post.setPost("How Game of thrones ended??");

        postRepository.save(post);

        Comment comment= new Comment();

        comment.setPost(post);
        comment.setComment("Very good explanation! Keep up the good work.!!");

        commentRepository.save(comment);

    }
}

