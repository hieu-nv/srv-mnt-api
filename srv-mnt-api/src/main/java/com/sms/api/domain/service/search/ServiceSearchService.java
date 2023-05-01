package com.sms.api.domain.service.search;

import com.sms.api.service.SearchService;
import com.sms.core.entity.Service;
import com.sms.core.repository.ServiceRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class ServiceSearchService
    implements SearchService<ServiceSearchRequest, ServiceSearchResponse> {

  private final ServiceRepository serviceRepository;

  @Override
  public List<ServiceSearchResponse> execute(ServiceSearchRequest request) {
    List<Service> serviceList = serviceRepository.findAll();
    return serviceList.stream().map(ServiceSearchResponse::of).collect(Collectors.toList());
  }
}
