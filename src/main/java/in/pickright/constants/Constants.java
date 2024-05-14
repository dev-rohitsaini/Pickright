package in.pickright.constants;

import in.pickright.helpers.PropertiesHelpers;

public class Constants {

	private Constants() {

	}

	static {

	}

	public static final String BROWSER = PropertiesHelpers.getValue("BROWSER");
	public static final String URL = PropertiesHelpers.getValue("URL");
	public static final String IS_REMOTE = PropertiesHelpers.getValue("IS_REMOTE");
	public static final String ACTIVE_PAGE_LOADED = PropertiesHelpers.getValue("ACTIVE_PAGE_LOADED");
	public static final double WAIT_SLEEP_STEP = Double.parseDouble(PropertiesHelpers.getValue("WAIT_SLEEP_STEP"));
	public static final int WAIT_PAGE_LOADED = Integer.parseInt(PropertiesHelpers.getValue("WAIT_PAGE_LOADED"));
	public static final int WAIT_EXPLICIT = Integer.parseInt(PropertiesHelpers.getValue("WAIT_EXPLICIT"));
	
	

}
