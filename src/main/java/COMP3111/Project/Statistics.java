package COMP3111.Project;

import javafx.beans.property.SimpleStringProperty;

public class Statistics {

	private final SimpleStringProperty entry;
	private final SimpleStringProperty value;

	Statistics(String fName, String lName) {
		this.entry = new SimpleStringProperty(fName);
		this.value = new SimpleStringProperty(lName);
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

