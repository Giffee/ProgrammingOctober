package ua.org.oa.sergey_kost.practices.practice5.serialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Student implements Serializable{
    private String name;
    private int course;

}
