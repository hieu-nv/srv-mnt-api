package com.sms.api.domain.service.search;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services")
public class ServiceSearchController {

  private final ServiceSearchService serviceSearchService;

  @GetMapping
//  @PreAuthorize("hasAuthority('xxx')")
  public ResponseEntity<List<ServiceSearchResponse>> search(Authentication authentication) {
    return ResponseEntity.ok(serviceSearchService.execute(ServiceSearchRequest.builder().build()));
  }
}
