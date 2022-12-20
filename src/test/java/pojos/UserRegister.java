package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegister {
    private List<Game> games;
    private Integer id;
    private String login;
    private String pass;

    public UserRegister(String login, String pass){
        this.login = login;
        this.pass = pass;
    }

}
