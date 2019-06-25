package com.abc.message.controllers;

import com.abc.message.dto.HeadingQueryDTO;
import com.abc.message.services.HeadingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author aravind
 */

@RestController
@RequestMapping(value = "/api/headings")
@Api(tags = "Heading", value = "Heading", description = "Controller for Headings")
public class HeadingController {

    @Autowired
    private HeadingService headingService;

    /*The below method build to show the complete information of the application only. So didnt wrote other methods*/

    @GetMapping(value = "/{headingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get information for the heading selected")
    public ResponseEntity<List<HeadingQueryDTO>> listAllByHeadingId(@PathVariable(value = "headingId") Long headingId) {
        return new ResponseEntity<>(headingService.listAllByHeadingId(headingId), HttpStatus.OK);
    }


}
