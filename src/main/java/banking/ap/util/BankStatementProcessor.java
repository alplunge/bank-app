package banking.ap.util;

import banking.ap.domain.BankTransaction;
import lombok.AllArgsConstructor;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class BankStatementProcessor {

    private final List<BankTransaction> transactions;

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

    public double calculateTotalForCategory(final String category) {
        return summarizeTransactions((accumulator, bankTransaction) -> bankTransaction.getDescription().equals(category) ? accumulator + bankTransaction.getAmount() : accumulator);
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
