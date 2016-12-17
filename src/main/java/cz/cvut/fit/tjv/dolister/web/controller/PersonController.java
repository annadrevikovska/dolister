package cz.cvut.fit.tjv.dolister.web.controller;

import cz.cvut.fit.tjv.dolister.model.Person;
import cz.cvut.fit.tjv.dolister.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    // List people
    @RequestMapping("/people")
    public String listPeople(Model model) {
        List<Person> people = personService.findAll();

        model.addAttribute("people", people);
        return "person/index";
    }

    // List person
    @RequestMapping("/people/{personId}")
    public String listPerson(@PathVariable Long personId, Model model) {
        Person person = personService.findById(personId);

        model.addAttribute("person", person);
        return "person/details";
    }

    // Form for adding a new user
    @RequestMapping("/uploadpeople")
    public String formNewUser(Model model) {
        if(!model.containsAttribute("person")) {
            model.addAttribute("person", new Person());
        }
        model.addAttribute("action", "/people");
        model.addAttribute("submit", "Submit");

        return "person/form";
    }

    // Form for editing a user
    @RequestMapping("/people/{personId}/edit")
    public String formUpdateUser(@PathVariable Long personId, Model model) {
        if(!model.containsAttribute("person")) {
            model.addAttribute("person", personService.findById(personId));
        }
        model.addAttribute("action", String.format("/people/%s", personId));
        model.addAttribute("submit", "Update");

        return "person/form";
    }

    // Add a new user
    @RequestMapping(value = "/people", method = RequestMethod.POST)
    public String addPerson(Person person) {
        personService.save(person);

        return "redirect:/people";
    }

    // Update a user
    @RequestMapping(value = "/people/{personId}", method = RequestMethod.POST)
    public String updatePerson(Person person) {
        personService.save(person);

        return "redirect:/people";
    }
}
