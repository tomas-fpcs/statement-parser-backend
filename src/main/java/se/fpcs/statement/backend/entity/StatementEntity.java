package se.fpcs.statement.backend.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import se.fpcs.statement.parser_core.StatementRow;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
public class StatementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String person;
    private String statementType;
    private String accountNumber;

    @OneToMany(mappedBy = "statement", cascade = CascadeType.ALL)
    private List<StatementRowEntity> rows;

}
