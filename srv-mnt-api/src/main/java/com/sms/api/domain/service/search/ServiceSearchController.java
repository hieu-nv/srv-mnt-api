package com.sms.api.domain.service.search;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services")
public class ServiceSearchController {

  private final ServiceSearchService serviceSearchService;

  @GetMapping
  public ResponseEntity<List<ServiceSearchResponse>> search() {
    return ResponseEntity.ok(serviceSearchService.execute(ServiceSearchRequest.builder().build()));
  }
}
