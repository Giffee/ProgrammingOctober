package ua.org.oa.sergey_kost.lectures.lecture6.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book implements Serializable{
    private String title;
    private String author;
    private int year;
}
