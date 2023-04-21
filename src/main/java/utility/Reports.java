package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	public static ExtentReports createReport() {
	ExtentReports reports=new ExtentReports();
	ExtentSparkReporter htmlReport=new ExtentSparkReporter("NaptolReports.html");
	reports.attachReporter(htmlReport);
	reports.setSystemInfo("Application", "Swag Lab");
	reports.setSystemInfo("TestType", "Regression");
	reports.setSystemInfo("CreatedBy", "Shila");
	return reports;

}
}
