package se.fpcs.statement.backend;

import se.fpcs.statement.backend.entity.StatementEntity;
import se.fpcs.statement.backend.entity.StatementRowEntity;
import se.fpcs.statement.parser_core.Statement;
import se.fpcs.statement.parser_core.StatementRow;

import java.util.List;

public class StatementService {
    public Statement create(Statement statement) {

        List<StatementRowEntity> rows = statement.getRows().stream()
                .map(row-> toStatementRowEntity(row))
                .toList();

        StatementEntity statementEntity = StatementEntity.builder()
                .person(statement.getPerson())
                .statementType(statement.getStatementType().name())
                .accountNumber(statement.getAccountNumber())
                .rows(rows)
                .build();
         --> store in repo
        return null;
    }

    private StatementRowEntity toStatementRowEntity(StatementRow row) {
        return null;
    }
}
