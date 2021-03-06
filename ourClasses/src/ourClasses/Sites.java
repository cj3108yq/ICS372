package ourClasses;

import java.util.LinkedList;

/**
 * Site is a class that holds a list of readings for a given site
 *
 */
public class Sites {

	/* collection status of a Site  */
	public static boolean canCollect = true;
	
	/* collection status of a Site  */
	public LinkedList<Reading> readings = new LinkedList<Reading>();
	
	/* collection status of a Site  */
	public LinkedList<String> ids = new LinkedList<String>();

	// a Site should have a siteID and its list of readings
	// Constructor
	public Sites(String siteID) {
		// Reading objects
		ids.add(siteID);
	}

	/**
	 * Method that returns the status of a Site for collection
	 * 
	 * @return Boolean status of collection for a Site
	 */
	public boolean checkCollStatus() {
		return canCollect;
	}

	/**
	 * Method that turns on site collection for a Site
	 **/

	public void turnOnStatus() {
		if (canCollect == false) {
			canCollect = true;
		}
	}

	/**
	 * Method that turns off site collection for a Site
	 **/
	public void turnOffStatus() {
		if (canCollect == true) {
			canCollect = false;
		}
	}


	/** Method that takes in parameters and adds it to its LinkedList of readings
	 * 
	 * precondition: collection status of Site must be true
	 * 
	 * @param studyName
	 * @param studyId
	 * @param id
	 * @param rdgType
	 * @param rdgID
	 * @param rdgValue
	 * @param rdgDate
	 */
	public void addAReading(String studyName, String studyId, String id, String rdgType, String rdgID, double rdgValue,
			String rdgDate) {
		if (checkCollStatus() == true) {
			readings.add(new Reading(studyName, studyId, id, rdgType, rdgID, rdgValue, rdgDate));
		} else {
			System.out.println("Sorry, this site is not accepting data for collection");
		}
	}

	/**
	 * Method that displays all the readings for a given site
	 * 
	 * @return String the list of readings
	 **/
	public String displayRdgs() {
		String list = "";
		for (Reading rdgs : readings) {
			list = list + rdgs.toString();

		}

		return list;
	}



	public static void main(String[] args) {

		Sites s = new Sites("12345");
		

		s.addAReading("Midwest USA Study", "450", "12345", "temprature", "974", 102.00, "1515354694451");
		s.addAReading("Eastern USA Study", "400", "12345", "temprature", "984", 99.00, "1515354694489");
		s.addAReading("Eastern USA Study", "400", "12345", "humidity", "100", 30.00, "1515784694489");

		s.displayRdgs();

	}

}
