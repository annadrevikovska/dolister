package cz.cvut.fit.tjv.dolister.web.controller;

import cz.cvut.fit.tjv.dolister.model.Done;
import cz.cvut.fit.tjv.dolister.service.DoneService;
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
public class DoneController {
    @Autowired
    private DoneService doneService;
    @Autowired
    private PersonService personService;

    // Index of all dones
    @RequestMapping("/dones")
    public String listDones(Model model) {
        List<Done> dones = doneService.findAll();

        model.addAttribute("dones", dones);
        return "done/index";
    }

    // Form for adding a new Done task
    @RequestMapping("/uploaddone")
    public String formNewDoneTask(Model model) {
        if(!model.containsAttribute("done")) {
            model.addAttribute("done", new Done());
        }
        model.addAttribute("colors", Color.values());
        model.addAttribute("categories", Category.values());
        model.addAttribute("people", personService.findAll());
        model.addAttribute("projects", Project.values());
        model.addAttribute("action", "/dones");
        model.addAttribute("submit", "Submit");

        return "done/form";
    }

    // Form for editing a task
    @RequestMapping("/dones/{doneId}/edit")
    public String formUpdateDoneTask(@PathVariable Long doneId, Model model) {
        if(!model.containsAttribute("done")) {
            model.addAttribute("done", doneService.findById(doneId));
        }
        model.addAttribute("colors", Color.values());
        model.addAttribute("categories", Category.values());
        model.addAttribute("people", personService.findAll());
        model.addAttribute("projects", Project.values());
        model.addAttribute("action", String.format("/dones/%s", doneId));
        model.addAttribute("submit", "Update");

        return "done/form";
    }

    // Add a new Done task
    @RequestMapping(value = "/dones", method = RequestMethod.POST)
    public String addDone(Done done) {
        doneService.save(done);

        return "redirect:/dones";
    }

    // Update the task
    @RequestMapping(value = "/dones/{doneId}", method = RequestMethod.POST)
    public String updateDone(Done done) {
        doneService.save(done);

        return "redirect:/dones";
    }

    // List a detail of task
    @RequestMapping("/dones/{doneId}")
    public String doneDetails(@PathVariable Long doneId, Model model) {
        Done done = doneService.findById(doneId);

        model.addAttribute("done", done);
        return "done/details";
    }

    // ........
}
