package com.example.sistematizacao.domain;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name = "funcionario_telefone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String telefone;
    private String tipo;
}
