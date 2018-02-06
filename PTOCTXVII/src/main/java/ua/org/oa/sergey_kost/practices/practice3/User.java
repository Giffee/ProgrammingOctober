package ua.org.oa.sergey_kost.practices.practice3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends Entity<Integer> {

    private String fullName;
    private String login;
    private String password;
    private String email;
    private List<Ticket> ownTickets;
}
