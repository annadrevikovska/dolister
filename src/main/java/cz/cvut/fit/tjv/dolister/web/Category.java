package cz.cvut.fit.tjv.dolister.web;

public enum Category {
    BIPA1("BIPA1"),
    BIAAG("BIAAG"),
    BIDBS("BIDBS"),
    WORK("WORK"),
    PERSONAL("PERSONAL");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
