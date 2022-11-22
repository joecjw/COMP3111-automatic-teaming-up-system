package COMP3111.Project;

import javafx.beans.property.SimpleStringProperty;

/**
 * Statistics class Consists of statistic information of the class
 * @author Team 9
 *
 */
public class Statistics {
	private final SimpleStringProperty rowid;
	private final SimpleStringProperty entry;
	private final SimpleStringProperty value;
	
	/**
	 * Constructor
	 * @param row_id for table display row_index
	 * @param statistics item name
	 * @param statistics item value
	 */
	Statistics(String rowID, String fName, String lName) {
		this.rowid = new SimpleStringProperty(rowID);
		this.entry = new SimpleStringProperty(fName);
		this.value = new SimpleStringProperty(lName);
	}
	
	/**
	 * Method to get row_index for table display
	 * @return {@code String} rowid
	 */
	public String getRowid() {
		return rowid.get();
	}
	
	/**
	 * Method to get entry name
	 * @return {@code String} name
	 */
	public String getEntry() {
		return entry.get();
	}
	
	/**
	 * Method to set entry name
	 * @param val entry's name
	 */
	public void setEntry(String val) {
		entry.set(val);
	}
	
	/**
	 * Method to get entry value
	 * @return {@code String} value
	 */
	public String getValue() {
		return value.get();
	}
	
	/**
	 * Method to set entry value
	 * @param val entry's value
	 */
	public void setValue(String val) {
		value.set(val);
	}

}

