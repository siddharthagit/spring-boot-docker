package com.bootng;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * A simple Spring Boot Controller
 */
@Controller
public class LinkController {

  private static final Logger log = LoggerFactory.getLogger(SpringBootLinkApplication.class);

  @Autowired
  BlogLinkService blogService;

  @RequestMapping(value = {"/"}, method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Object getHome() {
    log.info("inside getHome ");

    return "GoTo \\links to see all the links \n";
  }

  @RequestMapping(value = {"/links"}, method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)

  public @ResponseBody Object getHeadLines() {
    log.info("inside blog GET getHeadLines method");

    String sourceLink = "http://www.bootng.com";

    List<String> links = blogService.getAllLinks(sourceLink);

    StringBuilder result = new StringBuilder();

    for (String link : links) {
      result.append(link).append("\n");
    }

    return "Links scanned from bootng.com \n" + result;
  }

  public @ResponseBody Object getHeadLines(@RequestParam String sourceLink) {
    log.info("inside blog GET getHeadLines method");

    List<String> links = blogService.getAllLinks(sourceLink);

    StringBuilder result = new StringBuilder();

    for (String link : links) {
      result.append(link).append("\n");
    }

    return "Links scanned from specified url \n" + result;
  }



  @RequestMapping(value = {"/test"}, method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Object isSerivceUp() {
    log.info("inside blog GET method");
    return "Service is Running Fine";
  }
}
