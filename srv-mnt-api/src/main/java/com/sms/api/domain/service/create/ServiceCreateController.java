package com.sms.api.domain.service.create;

import static com.sms.api.domain.service.create.ServiceCreateResponse.of;

import com.sms.core.entity.Service;
import com.sms.core.repository.ServiceRepository;
import java.time.OffsetDateTime;
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

  private final ServiceRepository serviceRepository;

  @PostMapping
  public ResponseEntity<ServiceCreateResponse> create(@RequestBody ServiceCreateRequest request) {
    Service service = request.toServiceBuilder().createdBy("test").createdAt(OffsetDateTime.now()).build();
    serviceRepository.create(service);
    return ResponseEntity.ok(of(service));
  }
}
