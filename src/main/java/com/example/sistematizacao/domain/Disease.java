package com.example.sistematizacao.domain;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name = "funcionario_doenca")
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String doenca;
    private String descricao;
}
