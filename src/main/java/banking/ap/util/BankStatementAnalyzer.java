package banking.ap.util;

import banking.ap.domain.BankTransaction;
import banking.ap.domain.SummaryStatistics;
import banking.ap.util.exporter.Exporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public void analyze(final String fileName, final BankStatementParser bankStatementParser, final Exporter exporter) throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        final SummaryStatistics summaryStatistics = bankStatementProcessor.summarizeStatistics();
        System.out.println(exporter.export(summaryStatistics));
    }

}
