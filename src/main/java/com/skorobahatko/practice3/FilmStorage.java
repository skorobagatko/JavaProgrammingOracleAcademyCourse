package com.skorobahatko.practice3;

import java.util.HashMap;
import java.util.Map;

public class FilmStorage implements GenericStorage<Integer, Film> {

    private static int id = 0;

    private Map<Integer, Film> films = new HashMap<>();

    @Override
    public Integer add(Film film) {
        Integer key;
        if (films.containsValue(film)) {
            key = films.entrySet()
                    .stream()
                    .filter(e -> e.getValue().equals(film))
                    .findAny()
                    .get()
                    .getKey();
        } else {
            key = id++;
            films.put(key, film);
        }
        return key;

    }

    @Override
    public Film get(Integer key) {
        return films.get(key);
    }

    @Override
    public void update(Integer key, Film film) {
        films.merge(key, film, (v1, v2) -> film);
    }

    @Override
    public boolean remove(Integer key) {
        return films.remove(key) != null;
    }

    @Override
    public String toString() {
        return "FilmStorage{" +
                "films=" + films +
                '}';
    }

}
