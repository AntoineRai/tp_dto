package com.example.tp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255, message = "Le body ne doit pas être supeieur à 15")
    @NotBlank(message =" Le body ne doit pas être vide")
    @Size(min = 3,message = "Le body doit être plus grand que 3")
    private String body;

    @NotBlank(message = "L'email ne peut être vide")
    @Email(message = "Un email valide" )
    @Pattern(regexp = ".*\\.com$", message = "L'email doit se terminer par .com")
    private String email;

    @Size(max = 255, message = "Le nom ne doit pas être supeieur à 15")
    @NotBlank(message =" Le commentaire doit avoir un nom")
    @Size(min = 3,message = "Le nom doit être plus grand que 3")
    private String name;

    @ManyToOne
    @JoinColumn(name = "posts_id")
    private Posts posts;
}
