package com.abc.message.services;

import com.abc.message.dto.TopicCreateDTO;
import com.abc.message.dto.TopicQueryDTO;
import com.abc.message.entities.Heading;
import com.abc.message.entities.Topic;
import com.abc.message.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

/**
 * @author aravind
 */

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository  topicRepository;

    @Override
    public Long createTopic(Long headingId,TopicCreateDTO topicCreateDTO) {
        Topic newTopic = new Topic();
        Heading heading = new Heading();
        heading.setId(headingId);
        newTopic.setHeading(heading);
        newTopic.setTopicName(topicCreateDTO.getTopicName());
        newTopic.setDescription(topicCreateDTO.getDescription());

        return topicRepository.save(newTopic).getId();
    }

    @Override
    public List<TopicQueryDTO> listTopicByTopicId(Long headingId,Long topicId) {
        List<TopicQueryDTO> topicList = new ArrayList<>();
        if (topicRepository.findByHeadingId(headingId).size()>0 && topicRepository.findById(topicId).isPresent()){
            Topic fetchedTopic = topicRepository.findById(topicId).get();
            topicList.add(new TopicQueryDTO(fetchedTopic.getId(), fetchedTopic.getTopicName(),fetchedTopic.getDescription(),fetchedTopic.getPosts()));
            return  topicList;
        }else{
            throw new EntityNotFoundException("Post Id " + topicId.toString() + " not found in the database");
        }
    }

    @Override
    public List<TopicQueryDTO> listAllTopicsByHeadingId(Long headingId) {
        List<TopicQueryDTO> topicList = new ArrayList<>();

        topicRepository.findByHeadingId(headingId).forEach(topic -> {
            topicList.add(new TopicQueryDTO(topic.getId(), topic.getTopicName(),topic.getDescription(),topic.getPosts()));
        });

        if (topicList.size() > 0){
            return topicList;
        }else{
            throw new EntityNotFoundException("No Post Found in the Database");
        }
    }
}
