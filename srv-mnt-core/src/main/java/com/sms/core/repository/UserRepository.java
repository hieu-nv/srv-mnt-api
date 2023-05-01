package com.sms.core.repository;

import com.sms.core.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
  User findById(Long id);
}
