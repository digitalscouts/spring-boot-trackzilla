package com.pluralsight.fundamentals.repository;

import com.pluralsight.fundamentals.entity.Release;
import org.springframework.data.repository.CrudRepository;

public interface ReleaseRepository extends CrudRepository<Release, Long> {
}
