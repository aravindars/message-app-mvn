package com.abc.message.repositories;

import com.abc.message.entities.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author aravind
 */

@RepositoryRestResource(collectionResourceRel = "topics", path = "topics")
public interface TopicRepository extends CrudRepository<Topic, Long> {
        List<Topic> findByHeadingId(Long headingId);
}
