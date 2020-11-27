package banking.ap.util.exporter;

import banking.ap.domain.SummaryStatistics;
import com.google.gson.Gson;

public class JSONExporter implements Exporter {
    @Override
    public String export(SummaryStatistics summaryStatistics) {
        Gson gson = new Gson();
        gson.toJson(summaryStatistics);
        return gson.toString();
    }
}
