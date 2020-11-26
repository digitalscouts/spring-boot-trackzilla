package com.pluralsight.fundamentals.repository;

import com.pluralsight.fundamentals.entity.Application;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Application, Long> {
}
