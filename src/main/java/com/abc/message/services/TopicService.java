package com.abc.message.services;

import com.abc.message.dto.TopicCreateDTO;
import com.abc.message.dto.TopicQueryDTO;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

/**
 * @author aravind
 */

public interface TopicService {
    Long createTopic(Long headingId,TopicCreateDTO topicCreateDTO);
    List<TopicQueryDTO> listAllTopicsByHeadingId(Long HeadingId);
    List<TopicQueryDTO> listTopicByTopicId(Long headingId,Long topicId);
}
