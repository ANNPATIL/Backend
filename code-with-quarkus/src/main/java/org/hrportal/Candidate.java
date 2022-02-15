package org.hrportal;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Candidate extends PanacheEntity {

    @Column
    public String fname;

    @Column
    public String lname;

    @Column
    public int age;

    @Column
    public int experience;

    @Column
    private Status status;

    @Column
    private String feedback;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                ", experience=" + experience +
                ", status=" + status +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}