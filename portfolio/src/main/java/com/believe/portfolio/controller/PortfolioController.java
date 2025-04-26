package com.believe.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.believe.portfolio.model.Project;
import com.believe.portfolio.repository.ProjectRepository;

@RestController
public class PortfolioController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/api/projects")
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/api/profile")
    public String getProfile() {
        return "Welcome to my portfolio!";
    }
}