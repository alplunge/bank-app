package banking.ap;

import banking.ap.util.*;
import banking.ap.util.exporter.Exporter;
import banking.ap.util.exporter.JSONExporter;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final BankTransactionFilter bankTransactionFilter = new BankTransactionIsInAprilAndExpensive();
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();
        final Exporter exporter = new JSONExporter();
        bankStatementAnalyzer.analyze(args[0], bankStatementParser, exporter);

    }
}
