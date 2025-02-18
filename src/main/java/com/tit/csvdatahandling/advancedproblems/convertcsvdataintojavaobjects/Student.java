package com.tit.csvdatahandling.advancedproblems.convertcsvdataintojavaobjects;
public class Student{
    public String ID;
    public String Name;
    public String Age;
    public String Marks;

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setMarks(String marks) {
        Marks = marks;
    }

    public void setAge(String age) {
        Age = age;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public String getMarks() {
        return Marks;
    }

    public String getAge() {
        return Age;
    }

    public String getName() {
        return Name;
    }
}
