package banking.ap.util;

import banking.ap.domain.BankTransaction;
import banking.ap.domain.SummaryStatistics;
import lombok.AllArgsConstructor;

import java.time.Month;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@AllArgsConstructor
public class BankStatementProcessor {

    private final List<BankTransaction> transactions;

    public SummaryStatistics summarizeStatistics() {
        final DoubleSummaryStatistics doubleSummaryStatistics = transactions.stream().mapToDouble(BankTransaction::getAmount).summaryStatistics();
        return new SummaryStatistics(doubleSummaryStatistics.getSum(), doubleSummaryStatistics.getMax(), doubleSummaryStatistics.getMin(), doubleSummaryStatistics.getAverage());
    }

    public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0;
        for (BankTransaction transaction : transactions) {
            result = bankTransactionSummarizer.summarize(result, transaction);
        }
        return result;
    }

    public double calculateTotalInMonth(final Month month) {
        return summarizeTransactions((accumulator, bankTransaction) -> bankTransaction.getDate().getMonth() == month ? accumulator + bankTransaction.getAmount() : accumulator);
    }

    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
        final List<BankTransaction> result = new ArrayList<>();
        for (BankTransaction transaction : transactions) {
            if (bankTransactionFilter.test(transaction)) {
                result.add(transaction);
            }
        }
        return result;
    }

    public List<BankTransaction> findTransactionGreaterThanEqual(final int amount) {
        return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
    }

}
