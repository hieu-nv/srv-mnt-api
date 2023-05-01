package com.sms.api.domain.service.create;

import com.sms.api.service.CreateService;
import com.sms.core.entity.Service;
import com.sms.core.repository.ServiceRepository;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class ServiceCreateService implements CreateService<ServiceCreateRequest, ServiceCreateResponse> {

  private final ServiceRepository serviceRepository;

  @Override
  public ServiceCreateResponse execute(ServiceCreateRequest request) {
    Service service =
        request.toServiceBuilder().createdAt(OffsetDateTime.now()).createdBy("test").build();
    serviceRepository.create(service);
    return ServiceCreateResponse.of(service);
  }
}
