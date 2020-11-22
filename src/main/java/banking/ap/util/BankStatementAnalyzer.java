package banking.ap.util;

import banking.ap.domain.BankTransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public void analyze(final String fileName, BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);
    }

    private void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is " +bankStatementProcessor.calculateTotalAmount());
        System.out.println("Transactions in January " +bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("Transactions for furniture category " +bankStatementProcessor.calculateTotalForCategory("furniture"));
    }
}