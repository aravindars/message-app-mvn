package com.abc.message.services;

import com.abc.message.dto.HeadingQueryDTO;
import java.util.List;

/**
 * @author aravind
 */

public interface HeadingService {
    List<HeadingQueryDTO> listAllByHeadingId(Long headingId);

}
