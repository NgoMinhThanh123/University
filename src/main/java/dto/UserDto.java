package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    String username;
    String password;
    String email;
    String role;
}
