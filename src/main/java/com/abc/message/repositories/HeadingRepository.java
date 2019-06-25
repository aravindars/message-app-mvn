package com.abc.message.repositories;

import com.abc.message.entities.Heading;
import com.abc.message.entities.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author aravind
 */

@RepositoryRestResource(collectionResourceRel = "headings", path = "headings")
public interface HeadingRepository extends CrudRepository<Heading, Long> {
}
