package com.sms.api.domain.service.search;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sms.core.entity.Service;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceSearchResponse {
  private Long id;

  private String name;

  @JsonFormat(
      shape = JsonFormat.Shape.STRING,
      pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]XXX",
      timezone = "UTC")
  private OffsetDateTime createdAt;

  private String createdBy;

  @JsonFormat(
      shape = JsonFormat.Shape.STRING,
      pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]XXX",
      timezone = "UTC")
  private OffsetDateTime updatedAt;

  private String updatedBy;

  @JsonFormat(
      shape = JsonFormat.Shape.STRING,
      pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]XXX",
      timezone = "UTC")
  private OffsetDateTime deletedAt;

  private String deletedBy;

  public static ServiceSearchResponse of(Service service) {
    return ServiceSearchResponse.builder()
        .id(service.getId())
        .name(service.getName())
        .createdAt(service.getCreatedAt())
        .createdBy(service.getCreatedBy())
        .updatedAt(service.getUpdatedAt())
        .updatedBy(service.getUpdatedBy())
        .deletedAt(service.getDeletedAt())
        .deletedBy(service.getDeletedBy())
        .build();
  }
}
