package com.sms.api.domain.service.search;

import com.sms.core.entity.Service;
import com.sms.core.repository.ServiceRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services")
public class ServiceSearchController {

  private final ServiceRepository serviceRepository;

  @GetMapping
  public ResponseEntity<List<ServiceSearchResponse>> search() {
    List<Service> serviceList = serviceRepository.findAll();
    return ResponseEntity.ok(
        serviceList.stream().map(ServiceSearchResponse::of).collect(Collectors.toList()));
  }
}
