package com.sarthak.URL.Shortener.repo;

import com.sarthak.URL.Shortener.entity.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface URLRepo extends JpaRepository<URL,String> {
}
