package cz.cvut.fit.tjv.dolister.web.controller;

import cz.cvut.fit.tjv.dolister.model.ToDo;
import cz.cvut.fit.tjv.dolister.service.PersonService;
import cz.cvut.fit.tjv.dolister.service.ToDoService;
import cz.cvut.fit.tjv.dolister.web.Category;
import cz.cvut.fit.tjv.dolister.web.Color;
import cz.cvut.fit.tjv.dolister.web.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ToDoController {
    @Autowired
    private ToDoService toDoService;
    @Autowired
    private PersonService personService;

    // Index of all toDos
    @RequestMapping("/")
    public String listToDos(Model model) {
        // Get all todos
        List<ToDo> toDos = toDoService.findAll();

        model.addAttribute("todos", toDos);
        return "todo/index";
    }

    // Form for adding a new ToDoTask
    @RequestMapping("/uploadtodo")
    public String formNewToDoTask(Model model) {
        if (!model.containsAttribute("todo")) {
            model.addAttribute("todo", new ToDo());
        }
        model.addAttribute("colors", Color.values());
        model.addAttribute("categories", Category.values());
        model.addAttribute("people", personService.findAll());
        model.addAttribute("projects", Project.values());
        model.addAttribute("action", "/");
        model.addAttribute("submit", "Submit");

        return "todo/form";
    }

    // Form for editing a task
    @RequestMapping("/{toDoId}/edit")
    public String formEditToDoTask(@PathVariable Long toDoId, Model model) {
        if (!model.containsAttribute("todo")) {
            model.addAttribute("todo", toDoService.findById(toDoId));
        }
        model.addAttribute("colors", Color.values());
        model.addAttribute("categories", Category.values());
        model.addAttribute("people", personService.findAll());
        model.addAttribute("projects", Project.values());
        model.addAttribute("action", String.format("/%s", toDoId));
        model.addAttribute("submit", "Update");

        return "todo/form";
    }

    // Update task
    @RequestMapping(value = "/{toDoId}", method = RequestMethod.POST)
    public String updateToDo(ToDo toDo) {
        toDoService.save(toDo);
        return "redirect:/";
    }

    // Add a new ToDoTask
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addToDo(ToDo toDo) {
        toDoService.save(toDo);

        return "redirect:/";
    }

    // List detail of task
    @RequestMapping("/{toDoId}")
    public String toDoDetails(@PathVariable Long toDoId, Model model) {
        // Get task whose id is toDoId
        ToDo toDo = toDoService.findById(toDoId);

        model.addAttribute("todo", toDo);
        return "todo/details";
    }


    // ..........
}
