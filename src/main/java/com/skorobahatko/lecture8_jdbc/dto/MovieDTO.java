package com.skorobahatko.lecture8_jdbc.dto;

import com.skorobahatko.lecture8_jdbc.model.Entity;

public class MovieDTO extends Entity<Integer> {

    private String title;
    private String description;
    private int duration;

    public MovieDTO() {
    }

    public MovieDTO(String title, String description, int duration) {
        this.title = title;
        this.description = description;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }



}
