package com.dwj.standard.entity;


import org.springframework.data.annotation.Id;

import java.util.List;

public class User {

    @Id
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 性别
     */
    private int gender;
    /**
     * 体重
     */
    private int weight;
    /**
     * 技能包
     */
    private List<Skill> skillList;

    public User() {
        super();
        //do nothing
    }

    private User(Builder builder) {
        id = builder.id;
        name = builder.name;
        age = builder.age;
        pwd = builder.pwd;
        gender = builder.gender;
        weight = builder.weight;
        skillList = builder.skillList;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private String name;
        private int age;
        private String pwd;
        private int gender;
        private int weight;
        private List<Skill> skillList;

        private Builder() {
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder pwd(String pwd) {
            this.pwd = pwd;
            return this;
        }

        public Builder gender(int gender) {
            this.gender = gender;
            return this;
        }

        public Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder skillList(List<Skill> skillList) {
            this.skillList = skillList;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPwd() {
        return pwd;
    }

    public int getGender() {
        return gender;
    }

    public int getWeight() {
        return weight;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", pwd='" + pwd + '\'' +
                ", gender=" + gender +
                ", weight=" + weight +
                ", skillList=" + skillList +
                '}';
    }
}
