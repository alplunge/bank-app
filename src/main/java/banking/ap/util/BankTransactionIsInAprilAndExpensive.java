package banking.ap.util;

import banking.ap.domain.BankTransaction;

import java.time.Month;

public class BankTransactionIsInAprilAndExpensive implements BankTransactionFilter {
    @Override
    public boolean test(BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth() == Month.APRIL && bankTransaction.getAmount() >= 1_000;
    }
}
