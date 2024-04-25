package com.example.tp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255, message = "Le content ne doit pas être supeieur à 255")
    @NotBlank(message ="Le content ne doit pas être vide")
    @Size(min = 3,message = "Le content doit être plus grand que 3")
    private String content;

    @Size(max = 255, message = "La description ne doit pas être supeieur à 255")
    @NotBlank(message ="La description ne doit pas être vide")
    @Size(min = 3,message = "La description doit être plus grand que 3")
    private String description;

    @Size(max = 255, message = "Le titre ne doit pas être supeieur à 255")
    @NotBlank(message ="Le titre ne doit pas être vide")
    @Size(min = 3,message = "Le titre doit être plus grand que 3")
    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "posts",fetch = FetchType.LAZY)
    private Set<Comments> comments = new HashSet<>();
}
