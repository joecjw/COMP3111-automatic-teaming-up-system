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

	Statistics(String rowID, String fName, String lName) {
		this.rowid = new SimpleStringProperty(rowID);
		this.entry = new SimpleStringProperty(fName);
		this.value = new SimpleStringProperty(lName);
	}
	
	public String getRowid() {
		return rowid.get();
	}
	
	public String getEntry() {
		return entry.get();
	}

	public void setEntry(String val) {
		entry.set(val);
	}

	public String getValue() {
		return value.get();
	}

	public void setValue(String val) {
		value.set(val);
	}

}

