package com.dwj.standard.entity;


import org.springframework.data.annotation.Id;

public class Skill {

    @Id
    private String id;

    private String name;

    public Skill() {
        super();
        //do nothing
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
