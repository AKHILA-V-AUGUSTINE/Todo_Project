package com.luminar.onlinebookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luminar.onlinebookstore.entity.TodoEntity;

@Repository
public interface ToDoRepo extends JpaRepository<TodoEntity, Long> {

}
