package ru.jdm.timesheet.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class UserController {
  @Autowired
  UserRepository userRepository;

  @GetMapping("{userId}")
  public User getUser(@PathVariable Long userId) {
    log.info("Get user by " + userId);
    return userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found."));
  }
}