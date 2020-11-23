package banking.ap;

import banking.ap.util.*;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final BankTransactionFilter bankTransactionFilter = new BankTransactionIsInAprilAndExpensive();
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();
        bankStatementAnalyzer.analyze(args[0], bankStatementParser, bankTransactionFilter);

    }
}
