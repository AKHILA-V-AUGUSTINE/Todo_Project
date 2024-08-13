# Todo_Project

## Overview
This project contain two module one is Admin and other is User.Each users enter into this application based on their 
role it checked at the time of login.Admin can view list of project,view particular project in detail,add new project 
detail,mark it status,delete if needed.User can view,add,edit,delete each project and also update the status.Created 
and Updated date are the fields while viewing whiching is automatically updated at the time of creation and updated.

## Objectives
- Implement Role-Based Access Control: Design a login system that assigns users to specific roles (e.g., Admin, User).
- Develop To-Do Item Management Features: Enable users to add, edit, view, and delete To-Do items with relevant details,
  incorporating role-based restrictions for specific actions.

## Features
- User Authentication and Role Management: Implement a secure role-based login system where Admins have full access to 
  all features, including user management, while regular users have restricted access based on their roles.
- Add New To-Do Items:Users can create new To-Do items by providing a title, description, and other details, with the
  item automatically assigned a creation date
- Edit Existing To-Do Items: Users can edit existing To-Do items, updating details like title, description, and status,
  with changes tracked and the last updated date automatically recorded.
- View To-Do Items: Users can view a list of To-Do items with basic details and access detailed information, including
  full descriptions and history, by clicking on individual items.
- Mark Items as Complete: Users can easily mark To-Do items as complete, updating the status and visually distinguishing
  them from pending items in the list view.
- Delete To-Do Items: To-Do item deletion is restricted by user roles, ensuring only authorized users can delete items.
- Role-Based Access Control: The application enforces role-based access, allowing only authorized actions, with Admins
  managing and assigning user roles. 

## Technologies Used
- Java: For the server-side logic and backend implementation.
- Spring Boot: To simplify configuration and deployment of the Spring application.
- JSP (JavaServer Pages): For rendering dynamic web pages and the user interface.
- JavaScript: JavaScript handles user interactions, displays notifications.
- MySQL: For storing To-Do items and user data.
- HTML/CSS: For structuring and styling web pages. 

