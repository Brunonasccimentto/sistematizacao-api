package com.example.sistematizacao.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Table(name="funcionario")
@Entity(name="funcionario")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;
    private String nome;
    private Date nascimento;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "funcionario_Id", referencedColumnName = "id")
    private List<Phone> telefones;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    private List<Email> emails;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    private List<Disease> doencas;

}
