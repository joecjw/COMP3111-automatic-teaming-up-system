package COMP3111.Project;
/**
 * Student class
 * Consists of student information
 * @author Team 9 
 * @version 1.0
 */
public class Student {
		
		private final String rowid;
		private final String studentid;
		private final String studentname;
		private final String email;
		private final String k1energy;
		private final String k2energy;
		private final String k3trick1;
		private final String k3trick2;
		private final String mypreference;
		private final String concerns;
		
		/**
		 * Constructor
		 * @param row_id for table display row_index
		 * @param student_id student id shown in the system
		 * @param student_name student name shown in the system
		 * @param student_email email address of the student
		 * @param k1_energy the value of k1
		 * @param k2_energy the value of k2
		 * @param k3_trick1 indicate whether the student have k3 trick 1
		 * @param k3_trick2 indicate whether the student have k3 trick 2
		 * @param my_preference indicate student's preferences to be a team leader
		 * @param concerns student's concerns
		 */
		public Student(String row_id, String student_id, String student_name, String student_email, String k1_energy, String k2_energy, String k3_trick1,
				String k3_trick2, String my_preference, String concerns) {
			if(student_id.length() != 8 ||Integer.parseInt(student_id) > 29999999 || Integer.parseInt(student_id) < 20000001) {
				throw new IllegalArgumentException("Object not created due to invalid student id");
			}
			
			if(student_name.length() > 40) {
				throw new IllegalArgumentException("Object not created due to invalid student name");
			}
			
			if(student_email.length() >50) {
				throw new IllegalArgumentException("Object not created due to invalid student email ");
			}
			
			if(k1_energy.length() > 3 || Integer.parseInt(k1_energy) > 100 || Integer.parseInt(k1_energy) < 0) {
				throw new IllegalArgumentException("Object not created due to invalid student k1 energy");
			}
			
			if(k2_energy.length() > 3 || Integer.parseInt(k2_energy) > 100 || Integer.parseInt(k2_energy) < 0) {
				throw new IllegalArgumentException("Object not created due to invalid student k2 energy");
			}
			
			if(k3_trick1 != "") {
				if(k3_trick1.length() > 1 || Integer.parseInt(k3_trick1) > 1 || Integer.parseInt(k3_trick1) < 0){
					throw new IllegalArgumentException("Object not created due to invalid student k3 trick1");
				}
				
			if(k3_trick2 != "" )
				if(k3_trick2.length() > 1 || Integer.parseInt(k3_trick2) > 1 || Integer.parseInt(k3_trick2) < 0){
					throw new IllegalArgumentException("Object not created due to invalid student k3 trick2");
				}
			}
			
			/*if(my_preference != "") {
				if(my_preference.length() > 1 || Integer.parseInt(my_preference) > 1 || Integer.parseInt(my_preference) < 0){
					throw new IllegalArgumentException("Object not created due to invalid student my preference");
				}
			}
				
			if(concerns != "") {
				if(concerns.length() > 200){
					throw new IllegalArgumentException("Object not created due to invalid student concern");
				}
			}*/
			
			
			this.rowid = new String(row_id);
			this.studentid = new String(student_id);
			this.studentname = new String(student_name);
			this.email = new String(student_email);
			this.k1energy = new String(k1_energy);
			this.k2energy = new String(k2_energy);
			this.k3trick1 = new String(k3_trick1);
			this.k3trick2 = new String(k3_trick2);
			this.mypreference = new String(my_preference);
			this.concerns = new String(concerns);
	
		}
		
		/**
		 * Method to get row_index of a student
		 * @return {@code String} row index of the student, return type is string is because need to convert to JavaFx SimpleStringProperty
		 */
		public String getRowid() {
			return rowid;
		}
		
		/**
		 * Method to get student id of a student
		 * @return {@code String} student id of the student, return type is string is because need to convert to JavaFx SimpleStringProperty
		 */
		public String getStudentid() {
			return studentid;
		}
		
		/**
		 * Method to get name of a student
		 * @return {@code String} name of the student, return type is string is because need to convert to JavaFx SimpleStringProperty
		 */
		public String getStudentname() {
			return studentname;
		}
		
		/**
		 * Method to get email of a student
		 * @return {@code String} email of the student, return type is string is because need to convert to JavaFx SimpleStringProperty
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * Method to get k1 energy value of a student
		 * @return {@code String} value of k1 energy of the student, return type is string is because need to convert to JavaFx SimpleStringProperty
		 */
		public String getK1energy() {
			return k1energy;
		}

		/**
		 * Method to get k2 energy value of a student
		 * @return {@code String} value of k2 energy of the student, return type is string is because need to convert to JavaFx SimpleStringProperty
		 */
		public String getK2energy() {
			return k2energy;
		}

		/**
		 * Method to get k3 trick 1 of a student
		 * @return {@code String} k3 trick 1 of the student, return type is string is because need to convert to JavaFx SimpleStringProperty
		 */
		public String getK3trick1() {
			return k3trick1;
		}

		/**
		 * Method to get k3 trick 2 of a student
		 * @return {@code String} k3 trick 2 of the student, return type is string is because need to convert to JavaFx SimpleStringProperty
		 */
		public String getK3trick2() {
			return k3trick2;
		}

		/**
		 * Method to get preference on whether the student want to be a team leader
		 * @return {@code String} preference of the student, return type is string is because need to convert to JavaFx SimpleStringProperty
		 */
		public String getMypreference() {
			return mypreference;
		}

		/**
		 * Method to get student concerns
		 * @return {@code String} concerns of the student, return type is string is because need to convert to JavaFx SimpleStringProperty
		 */
		public String getConcerns() {
			return concerns;
		}
}
