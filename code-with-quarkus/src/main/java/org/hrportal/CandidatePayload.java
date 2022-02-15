package org.hrportal;

public class CandidatePayload {

    private String fname;

   private String lname;

    private int age;

    private int experience;

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

    @Override
    public String toString() {
        return "CandidatePayload{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                ", experience=" + experience +
                '}';
    }
}
