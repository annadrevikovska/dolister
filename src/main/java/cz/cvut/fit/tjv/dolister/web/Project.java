package cz.cvut.fit.tjv.dolister.web;

public enum Project {
    PROGRAMMING("Programming"),
    EXAMS("Exams"),
    DATABASES("Databases"),
    FRONTEND("Front-End"),
    PERSONAL("Personal");

    private String name;

    Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
