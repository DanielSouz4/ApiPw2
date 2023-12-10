package br.com.lavajato.DoisIrmoes.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cpf;
    private String name;
    private String street;
    private String houseNumber;
    private String phone;
    private String email;
}



