package com.abc.message.services;

import com.abc.message.dto.HeadingQueryDTO;
import com.abc.message.entities.Heading;
import com.abc.message.repositories.HeadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import javax.persistence.EntityNotFoundException;

/**
 * @author aravind
 */

@Service
public class HeadingServiceImpl implements HeadingService {

    @Autowired
    private HeadingRepository headingRepository;

    @Override
    public List<HeadingQueryDTO> listAllByHeadingId(Long headingId) {
        List<HeadingQueryDTO> headingList = new ArrayList<>();
        if (headingRepository.findById(headingId).isPresent()) {
            Heading fetchedHeading = headingRepository.findById(headingId).get();
            headingList.add(new HeadingQueryDTO(fetchedHeading.getId(), fetchedHeading.getHeadingName(), fetchedHeading.getTopics()));
            return headingList;
        } else {
            throw new EntityNotFoundException("heading Id " + headingId.toString() + " not found in the database");
        }
    }

}
