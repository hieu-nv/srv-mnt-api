package com.sms.core.entity;

import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Service {
  private Long id;

  private String name;

  /** <code>created_at</code>. */
  private OffsetDateTime createdAt;

  /** <code>created_by</code>. */
  private String createdBy;

  /** <code>updated_at</code>. */
  private OffsetDateTime updatedAt;

  /** <code>updated_by</code>. */
  private String updatedBy;

  /** <code>deleted_at</code>. */
  private OffsetDateTime deletedAt;

  /** <code>deleted_by</code>. */
  private String deletedBy;
}
