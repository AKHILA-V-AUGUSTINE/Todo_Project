package com.luminar.onlinebookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luminar.onlinebookstore.entity.TodoEntity;
import com.luminar.onlinebookstore.repository.ToDoRepo;

@Service
public class ToDoServices {
	 @Autowired
	    private ToDoRepo repo;

	    // Retrieve all ToDo items
	    public List<TodoEntity> getAllToDoItems() {
	        return (List<TodoEntity>) repo.findAll();
	    }
	    
	 


	    // Retrieve a single ToDo item by ID
	    public TodoEntity getToDoItemById(Long id) {
	        Optional<TodoEntity> todoOptional = repo.findById(id);
	        return todoOptional.orElse(null);
	    }

	    // Update the status of a ToDo item to "Completed"
	    public boolean updateStatus(Long id) {
	        TodoEntity todo = getToDoItemById(id);
	        if (todo != null) {
	            todo.setStatus("Completed");
	            return saveOrUpdateToDoItem(todo);
	        }
	        return false;
	    }

	    // Save or update a ToDo item
	    public boolean saveOrUpdateToDoItem(TodoEntity todo) {
	        TodoEntity savedTodo = repo.save(todo);
	        return savedTodo != null && savedTodo.getId() != null;
	    }

	    // Delete a ToDo item by ID
	    public boolean deleteToDoItem(Long id) {
	        if (repo.existsById(id)) {
	            repo.deleteById(id);
	            return !repo.existsById(id);
	        }
	        return false;
	    }

}
