package com.sms.api.domain.user.create;

import com.sms.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserCreateController {

  private final UserRepository userRepository;

  @GetMapping("/create")
  public ResponseEntity<Object> create() {
    userRepository.findById(1L);
    return ResponseEntity.ok(null);
  }
}
