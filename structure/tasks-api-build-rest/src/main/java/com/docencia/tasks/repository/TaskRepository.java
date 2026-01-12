package com.docencia.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docencia.tasks.entities.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {}
