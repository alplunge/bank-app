package banking.ap.util;

import banking.ap.domain.BankTransaction;
import lombok.AllArgsConstructor;

import java.time.Month;
import java.util.List;

@AllArgsConstructor
public class BankStatementProcessor {

    private final List<BankTransaction> transactions;


    public double calculateTotalAmount() {
        double total = 0d;
        for (final BankTransaction transaction : transactions) {
            total += transaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month) {
        double total = 0d;
        for (final BankTransaction transaction : transactions) {
            if (transaction.getDate().getMonth() == month) {
                total += transaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0d;
        for (final BankTransaction transaction : transactions) {
            if (transaction.getDescription().equals(category)) {
                total += transaction.getAmount();
            }
        }
        return total;
    }

}
