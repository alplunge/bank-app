package banking.ap.util.exporter;

import banking.ap.domain.SummaryStatistics;

public interface Exporter {
    String export(SummaryStatistics summaryStatistics);
}
