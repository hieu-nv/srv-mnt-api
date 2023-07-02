package com.sms.api.domain.service.create;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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
  @PreAuthorize(value = "hasAuthority('offline_access')")
  public ResponseEntity<ServiceCreateResponse> create(Authentication authentication, @RequestBody ServiceCreateRequest request) {
    return ResponseEntity.ok(serviceCreateService.execute(request));
  }
}
