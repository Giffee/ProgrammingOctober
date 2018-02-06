package ua.org.oa.sergey_kost.practices.practice3;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private Session session;
    private Hall place;
    private Hall row;
    private double price;
}
