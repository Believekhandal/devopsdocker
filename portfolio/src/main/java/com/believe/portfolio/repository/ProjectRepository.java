package com.believe.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.believe.portfolio.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}