package br.com.lavajato.DoisIrmoes.controllers.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotBlank
    private String cpf;
    @NotBlank
    private String name;
    @NotBlank
    private String street;
    @NotBlank
    private String houseNumber;
    @NotBlank
    private String phone;
    @NotBlank
    private String email;

}
