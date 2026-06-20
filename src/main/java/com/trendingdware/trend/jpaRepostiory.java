package com.trendingdware.trend;

import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface jpaRepostiory  extends JpaRepository<registerPojo, Long>  {
	Optional<registerPojo> findByUsername(String username);
	

}
