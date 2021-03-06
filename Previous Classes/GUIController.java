

//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Locale;

import java.io.*;
import java.util.*; //collections
//import siteCollection.*;
//import classes.SiteGson;

//import com.google.gson.annotations.Expose;
//mport com.google.gson.annotations.SerializedName;
// import org.apache.commons.lang.builder.ToStringBuilder;

public class GUIController {
   

	/* Site with list of active readings */
	//private Site site; 

	/* All Sites with list of active readings */
	//in this class is a linkedlist of all sites, in the site object is a linked list of readings
	private AllSites sites; 

	//public SiteGSON siteGson;
	public GUIController guic;
	


	/*Show list of all readings for a site by validating user input 
	*@param String the siteID of a site 
	*@returns String  A list of all readings
    */
	public String showReadings(String aSiteID){
	//check if siteID is found in the list of AllSites by calling a method

	if (sites.findSite(aSiteID) == null){
     	System.out.println("Sorry, the siteID you entered is not a valid siteID. Please enter a valid siteID.");
	}
	else{
    	return sites.findSite(aSiteID);
	}

	}

	/**Validate user input and call the method to verify a site's collection status, then call the appropiate method 
	 * 
	 * @param siteID
	 */
	public void startSiteColl(String siteID){
		//verify that user entered a correct site id by using findSite method in AllSites		
		if(findSite(siteID)){
			site.checkCollectStatus() = true;
		}
	}

	/* Take user input and verify that the user has valid input, then call the appropiate method
    */
    public boolean addAReading(String siteID){
    //verify that user entered right input 
    	boolean output = false;
    	if(findSite(siteID)){output = true;}
    	return output;
    }
	/** Display a Menu */
	public void displayMenu(){
	System.out.println("To add a Reading, enter 1");
	System.out.println("To start site collection for a site, enter 2");
	System.out.println("To view list of all readings for a site, enter 3");
	System.out.println("To end site collection for an exsisting site,enter 4");
	System.out.println("To export a list of all site readings into a JSOn file, enter 5");
	
	}
	public static void main(String[] args) {
		//Load JSON file with site readings and different sites
		SiteGSON file = new SiteGSON();
		GUIController guic = new GUIController();
		System.out.println("Hello Welcome to the Site Management System. Please select an option");
		guic.displayMenu();
		Scanner sc = new Scanner(System.in);
	    int input = sc.nextInt();
	    String option =  String.valueOf(input);
        if(option == "1"){
			System.out.println("---------------------------------------");
			System.out.println("Please enter the following information ");
			Scanner stringSC = new Scanner(System.in);
			int option1 =  stringSC.nextInt();
			String.valueOf(option1);
			stringSC.close();

	     }
	   else if(option == "3"){
			System.out.println("---------------------------------------");
			System.out.println("Please enter a siteID to view all of its readings ");
			Scanner stringSC = new Scanner(System.in);
			int input1 =  stringSC.nextInt();
			String userSiteID = String.valueOf(input1);
			guic.showReadings(userSiteID);
		}
        else{
		System.out.println("bye bye");
		sc.close();
		}
		
        	
	}
}

