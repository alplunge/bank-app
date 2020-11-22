package banking.ap.domain;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class BankTransaction {
   private final LocalDate date;
   private final double amount;
   private final String description;
}
