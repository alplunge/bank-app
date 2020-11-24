package banking.ap.domain;

import lombok.Data;

@Data
public class SummaryStatistics {
    private final double sum;
    private final double max;
    private final double min;
    private final double average;

}
