package banking.ap;

import banking.ap.util.BankStatementAnalyzer;
import banking.ap.util.BankStatementCSVParser;
import banking.ap.util.BankStatementParser;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();
        bankStatementAnalyzer.analyze(args[0], bankStatementParser);
    }
}
