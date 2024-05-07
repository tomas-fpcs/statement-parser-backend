package se.fpcs.statement.backend.service;

import org.springframework.stereotype.Service;
import se.fpcs.statement.parser_core.ParserServiceFactory;
import se.fpcs.statement.parser_core.Statement;
import se.fpcs.statement.parser_core.StatementType;

import java.io.File;

@Service
public class StatementParserService {

    public Statement parse(
            StatementType statementType,
            File file) {

        if (statementType.equals(StatementType.SKANDIA)) {
            return parseSkandia(file);
        } else {
            throw new IllegalArgumentException("Statement type not supported: " + statementType);
        }

    }

    private Statement parseSkandia(File file) {

        return ParserServiceFactory
                .create(StatementType.SKANDIA)
                .parse(file);

    }
}
