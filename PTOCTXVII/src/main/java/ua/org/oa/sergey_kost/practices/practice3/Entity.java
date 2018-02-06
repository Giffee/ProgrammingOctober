package ua.org.oa.sergey_kost.practices.practice3;

import lombok.Data;

@Data
public abstract class Entity<T> {
    private T id;
}
