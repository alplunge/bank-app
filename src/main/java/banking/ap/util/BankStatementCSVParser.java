package banking.ap.util;

import banking.ap.domain.BankTransaction;
import banking.ap.util.validator.BankStatementValidator;
import banking.ap.util.validator.Notification;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser implements BankStatementParser {
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public BankTransaction parserFrom(String line) {
        final String[] columns = line.split(",");
        String desc = columns[2];
        String dt = columns[0];
        String amnt = columns[1];
        final BankStatementValidator bankStatementValidator = new BankStatementValidator(desc, dt, amnt);
        Notification notification = bankStatementValidator.validate();
        if (notification.hasErrors()) {
            notification.errorMessage();

        }
        final LocalDate date = LocalDate.parse(dt, DATE_PATTERN);
        final double amount = Double.parseDouble(amnt);
        return new BankTransaction(date, amount, desc);
    }

    @Override
    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for (String line : lines) {
            bankTransactions.add(parserFrom(line));
        }
        return bankTransactions;
    }
}
