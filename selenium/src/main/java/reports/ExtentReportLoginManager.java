package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportLoginManager {
  private static ExtentReports extent;

  public static ExtentReports getInstance() {
    if (extent == null) {
      ExtentSparkReporter spark = new ExtentSparkReporter("reports/login-report.html");
      extent = new ExtentReports();
      extent.attachReporter(spark);
    }
    return extent;
  }
}
