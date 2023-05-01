package com.sms.core.repository;

import com.sms.core.entity.Service;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ServiceRepository {
  Long create(Service service);

  List<Service> findAll();
}
