package util;

import banking.ap.domain.BankTransaction;
import banking.ap.util.BankStatementCSVParser;
import banking.ap.util.BankStatementParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class BankStatementCSVParserTest {

    @Test
    public void shouldParseOneCorrectLine() {
        final BankStatementParser statementParser = new BankStatementCSVParser();
        final String line = "30-11-2020,-50,RIMI";
        final BankTransaction bankTransaction = statementParser.parserFrom(line);

        final BankTransaction expectedTransaction = new BankTransaction(LocalDate.of(2020, Month.NOVEMBER, 30), -50, "RIMI");
        final double tolerance = 0.0d;

        Assertions.assertEquals(expectedTransaction.getAmount(), bankTransaction.getAmount(), tolerance);
        Assertions.assertEquals(expectedTransaction.getDate(), bankTransaction.getDate());
        Assertions.assertEquals(expectedTransaction.getDescription(), bankTransaction.getDescription());
    }
}
