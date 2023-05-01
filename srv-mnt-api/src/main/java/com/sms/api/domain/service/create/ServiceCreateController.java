package com.sms.api.domain.service.create;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services")
public class ServiceCreateController {

  private final ServiceCreateService serviceCreateService;

  @PostMapping
  public ResponseEntity<ServiceCreateResponse> create(@RequestBody ServiceCreateRequest request) {
    return ResponseEntity.ok(serviceCreateService.execute(request));
  }
}
