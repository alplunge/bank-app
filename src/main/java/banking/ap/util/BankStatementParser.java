package banking.ap.util;

import banking.ap.domain.BankTransaction;

import java.util.List;

public interface BankStatementParser {
    BankTransaction parserFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
