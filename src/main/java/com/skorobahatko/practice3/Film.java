package com.skorobahatko.practice3;

import java.util.Objects;

public class Film {

    private final String name;
    private final Ganre ganre;
    private final Integer duration;
    private final String description;

    public Film(String name, Ganre ganre, Integer duration, String description) {
        this.name = name;
        this.ganre = ganre;
        this.duration = duration;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(name, film.name) &&
                ganre == film.ganre &&
                Objects.equals(duration, film.duration) &&
                Objects.equals(description, film.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ganre, duration, description);
    }

    public String getName() {
        return name;
    }

    public Ganre getGanre() {
        return ganre;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", ganre=" + ganre +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                '}';
    }

}
