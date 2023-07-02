package com.sms.api.domain.home;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  @GetMapping("/api/test")
  public String index(Authentication authentication) {
    return "Home";
  }
}
