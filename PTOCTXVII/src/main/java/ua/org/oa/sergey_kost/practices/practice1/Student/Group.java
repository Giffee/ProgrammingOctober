package ua.org.oa.sergey_kost.practices.practice1.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Group {

    private String faculty;
    private int course;

    @Override
    public String toString() {
        return "Group:" + faculty + " - " + course + " course";
    }
}