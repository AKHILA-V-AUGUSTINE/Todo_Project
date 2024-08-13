package com.luminar.onlinebookstore.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.luminar.onlinebookstore.entity.TodoEntity;
import com.luminar.onlinebookstore.service.ToDoServices;

@Controller
public class ToDoController {

	@Autowired
	private ToDoServices service;

	@GetMapping({ "/AdminViewToDoList" })
	public String adminViewAllToDoItems(Model model, @ModelAttribute("message") String message) {
		model.addAttribute("list", service.getAllToDoItems());
		model.addAttribute("message", message);

		return "User/AdminViewToDoList";
	}

	
	@GetMapping("/detailedViewToDoList/{id}")
	public String detailedToDoItem(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
		TodoEntity todo = service.getToDoItemById(id);
		if (todo == null) {
			redirectAttributes.addFlashAttribute("message", "ToDo Item not found");
			return "redirect:/AdminViewToDoList";
		}
		model.addAttribute("todo", todo);
		return "User/DetailedViewToDoList";
	}

	@GetMapping({ "/ViewToDoList" })
	public String viewAllToDoItems(Model model, @ModelAttribute("message") String message) {
		model.addAttribute("list", service.getAllToDoItems());
		model.addAttribute("message", message);

		return "User/ViewToDoList";
	}
	@GetMapping("/updateToDoStatus/{id}")
	public String updateToDoStatus(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if (service.updateStatus(id)) {
			redirectAttributes.addFlashAttribute("message", "Update Success");
		} else {
			redirectAttributes.addFlashAttribute("message", "Update Failure");
		}
		return "redirect:/ViewToDoList";
	}
	
	@GetMapping("/detupdateToDoStatus/{id}")
	public String detupdateToDoStatus(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if (service.updateStatus(id)) {
			redirectAttributes.addFlashAttribute("message", "Update Success");
		} else {
			redirectAttributes.addFlashAttribute("message", "Update Failure");
		}
		return "redirect:/AdminViewToDoList";
	}

	@GetMapping("/addToDoItem")
	public String addToDoItem(Model model) {
		model.addAttribute("todo", new TodoEntity());
		return "User/AddToDoItem";
	}

	@PostMapping("/saveToDoItem")
	public String saveToDoItem(@ModelAttribute TodoEntity todo, RedirectAttributes redirectAttributes) {
		if (service.saveOrUpdateToDoItem(todo)) {
			redirectAttributes.addFlashAttribute("message", "Save Success");
		} else {
			redirectAttributes.addFlashAttribute("message", "Save Failure");
		}
		return "redirect:/ViewToDoList";
	}
	
	@PostMapping("/detsaveToDoItem")
	public String detsaveToDoItem(@ModelAttribute TodoEntity todo, RedirectAttributes redirectAttributes) {
		if (service.saveOrUpdateToDoItem(todo)) {
			redirectAttributes.addFlashAttribute("message", "Save Success");
		} else {
			redirectAttributes.addFlashAttribute("message", "Save Failure");
		}
		return "redirect:/AdminViewToDoList";
	}

	@GetMapping("/editToDoItem/{id}")
	public String editToDoItem(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
		TodoEntity todo = service.getToDoItemById(id);
		if (todo == null) {
			redirectAttributes.addFlashAttribute("message", "ToDo Item not found");
			return "redirect:/ViewToDoList";
		}
		model.addAttribute("todo", todo);
		return "User/EditToDoItem";
	}

	@PostMapping("/editSaveToDoItem")
	public String editSaveToDoItem(@ModelAttribute TodoEntity todo, RedirectAttributes redirectAttributes) {
		if (service.saveOrUpdateToDoItem(todo)) {
			redirectAttributes.addFlashAttribute("message", "Edit Success");
			return "redirect:/ViewToDoList";
		} else {
			redirectAttributes.addFlashAttribute("message", "Edit Failure");
			return "redirect:/editToDoItem/" + todo.getId(); // Redirect to the edit page with the id
		}
	}

	@GetMapping("/deleteToDoItem/{id}")
	public String deleteToDoItem(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if (service.deleteToDoItem(id)) {
			redirectAttributes.addFlashAttribute("message", "Delete Success");
		} else {
			redirectAttributes.addFlashAttribute("message", "Delete Failure");
		}
		return "redirect:/ViewToDoList";
	}
	@GetMapping("/detdeleteToDoItem/{id}")
	public String detdeleteToDoItem(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if (service.deleteToDoItem(id)) {
			redirectAttributes.addFlashAttribute("message", "Delete Success");
		} else {
			redirectAttributes.addFlashAttribute("message", "Delete Failure");
		}
		return "redirect:/AdminViewToDoList";
	}
}
