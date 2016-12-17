package cz.cvut.fit.tjv.dolister.web.controller;

import cz.cvut.fit.tjv.dolister.model.Doing;
import cz.cvut.fit.tjv.dolister.service.DoingService;
import cz.cvut.fit.tjv.dolister.service.PersonService;
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
public class DoingController {
    @Autowired
    private DoingService doingService;
    @Autowired
    private PersonService personService;


    // Index of all doings
    @RequestMapping("/doings")
    public String listDoings(Model model) {
        List<Doing> doings = doingService.findAll();

        model.addAttribute("doings", doings);
        return "doing/index";
    }

    // Detail of task
    @RequestMapping("/doings/{doingId}")
    public String doingDetails(@PathVariable Long doingId, Model model) {
        Doing doing = doingService.findById(doingId);

        model.addAttribute("doing", doing);
        return "doing/details";
    }

    // Form for adding a new Doing task
    @RequestMapping("/uploaddoing")
    public String formNewDoingTask(Model model) {
        if (!model.containsAttribute("doing")) {
            model.addAttribute("doing", new Doing());
        }
        model.addAttribute("colors", Color.values());
        model.addAttribute("categories", Category.values());
        model.addAttribute("people", personService.findAll());
        model.addAttribute("projects", Project.values());
        model.addAttribute("action", "/doings");
        model.addAttribute("submit", "Submit");

        return "doing/form";
    }

    // Form for updating a Doing task
    @RequestMapping("/doings/{doingId}/edit")
    public String formUpdateDoingTask(@PathVariable Long doingId, Model model) {
        if (!model.containsAttribute("doing")) {
            model.addAttribute("doing", doingService.findById(doingId));
        }
        model.addAttribute("colors", Color.values());
        model.addAttribute("categories", Category.values());
        model.addAttribute("people", personService.findAll());
        model.addAttribute("projects", Project.values());
        model.addAttribute("action", String.format("/doings/%s", doingId));
        model.addAttribute("submit", "Update");

        return "doing/form";
    }

    // Add a new Doing task
    @RequestMapping(value = "/doings", method = RequestMethod.POST)
    public String addDoing(Doing doing) {
        doingService.save(doing);

        return "redirect:/doings";
    }

    // Update the task
    @RequestMapping(value = "/doings/{doingId}", method = RequestMethod.POST)
    public String updateDoing(Doing doing) {
        doingService.save(doing);

        return "redirect:/doings";
    }

    // ............
}
