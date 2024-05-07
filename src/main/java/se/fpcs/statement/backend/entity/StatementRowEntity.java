package se.fpcs.statement.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


import java.time.LocalDate;

@Entity
@Getter
@Setter
public class StatementRowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String description;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "statement_id")
    private StatementEntity personStatement;

}
