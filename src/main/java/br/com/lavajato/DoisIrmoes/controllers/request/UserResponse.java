package br.com.lavajato.DoisIrmoes.controllers.request;

import br.com.lavajato.DoisIrmoes.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Integer id;
    private String name;
    private String street;
    private String houseNumber;
    private String phone;
    private String email;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.street = user.getStreet();
        this.houseNumber = user.getHouseNumber();
        this.phone = user.getPhone();
        this.email = user.getEmail();
    }
}
