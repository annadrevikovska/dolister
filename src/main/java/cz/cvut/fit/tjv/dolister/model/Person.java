package cz.cvut.fit.tjv.dolister.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 5, max = 15)
    private String username;

    @NotNull
    @Size(min = 3, max = 50)
    private String firstName;

    @NotNull
    @Size(min = 5, max = 100)
    private String lastName;

    @NotNull
    @Pattern(regexp = "[a-z]*@[a-z]*.[a-z]*")
    private String email;

    @OneToMany(mappedBy = "person")
    private List<ToDo> toDos = new ArrayList<>();

    @OneToMany(mappedBy = "person")
    private List<Doing> doings = new ArrayList<>();

    @OneToMany(mappedBy = "person")
    private List<Done> dones = new ArrayList<>();

    public Person(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ToDo> getToDos() {
        return toDos;
    }

    public void setToDos(List<ToDo> toDos) {
        this.toDos = toDos;
    }

    public List<Doing> getDoings() {
        return doings;
    }

    public void setDoings(List<Doing> doings) {
        this.doings = doings;
    }

    public List<Done> getDones() {
        return dones;
    }

    public void setDones(List<Done> dones) {
        this.dones = dones;
    }
}
