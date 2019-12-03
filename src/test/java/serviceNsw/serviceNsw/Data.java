package serviceNsw.serviceNsw;

import org.testng.annotations.DataProvider;

//Separate class created to ensure data driven testing
public class Data {

	
	@DataProvider(name = "InputData")
    public static Object[][] dataProviderMethod() 
    {
			return new Object[][] { 
        	{ "Sydney 2000", "Marrickville Service Centre" },
          //{ "Sydney Domestic Airport 2020", "Rockdale Service Centre"}
        };
    }
}


 

