{
		"name": "Vladimir Kaminsky",
		"designation": "Client Service Manager",
		"phone": "555-890-6185",
		"tollFree": "555-954-5813",
		"email": "test_csm@aires.com"
	}
	
	//*[@id='dcmhhr1:pfl1']//span
	
	
	/AIRES-Automation/src/features/MobilityX_DashboardHome.feature
/AIRES-Automation/src/features/MobilityX_MXReports_MyReportsTab.feature

@183727

CoreUtilities.explctWaitTillElementListVisibility(driver, _myFavorites);
		if (_myFavorites.isEmpty()) {
			CoreUtilities.explctWaitTillElementVisibility(driver,
					driver.findElement(
							By.xpath("//span[text()='Reports List                                          (0)']")),
					"Report List");

		}
		
		
		[
	{
		"name": [
			"Vladimir Kaminsky",
			"Joleen Lauffer"
		],
		"designation": [
			"Client Service Manager",
			"Account Executive"
		],
		"phone": [
			"555-890-6185",
			"555-355-1699"
		],
		"tollFree": [
			"555-954-5813",
			" 555-365-4320"
		],
		"email": [
			"test_csm@aires.com",
			"testrelonet@aires.com"
		]
	}
]





package testDataTypes;

public class FooterData {

	public String name;
	public String designation;
	public String phone;
	public String tollFree;
	public String email;

}

public static final String fullName = "Vladimir Kaminsky";