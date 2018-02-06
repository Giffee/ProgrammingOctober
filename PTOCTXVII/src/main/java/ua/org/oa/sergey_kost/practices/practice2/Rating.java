package ua.org.oa.sergey_kost.practices.practice2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rating {
    private int rate;
    private String maleName;
    private String femaleName;
}
