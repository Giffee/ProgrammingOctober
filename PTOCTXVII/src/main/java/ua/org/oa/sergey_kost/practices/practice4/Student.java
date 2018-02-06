package ua.org.oa.sergey_kost.practices.practice4;

import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Student {
    private String firstName;
    private String lastName;
    private int course;
}
