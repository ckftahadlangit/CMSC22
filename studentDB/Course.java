package studentDB;

import java.io.Serializable;

/**
 * Created by chezkah kate on 11/4/2016.
 */

import java.io.*;

public class Course implements Serializable{

    String courseCode;
    String courseDescription;

    public Course(String courseCode, String courseDescription){
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
}
