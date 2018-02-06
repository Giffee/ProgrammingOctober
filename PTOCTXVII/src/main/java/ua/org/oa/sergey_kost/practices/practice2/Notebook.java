package ua.org.oa.sergey_kost.practices.practice2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notebook {
    private String name;
    private String description;
    private String price;
}
