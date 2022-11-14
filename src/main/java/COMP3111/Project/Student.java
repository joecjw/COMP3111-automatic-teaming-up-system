package COMP3111.Project;

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
		
		public String getRowid() {
			return rowid;
		}
		
		public String getStudentid() {
			return studentid;
		}

		public String getStudentname() {
			return studentname;
		}
		
		public String getEmail() {
			return email;
		}

		public String getK1energy() {
			return k1energy;
		}

		public String getK2energy() {
			return k2energy;
		}

		
		public String getK3trick1() {
			return k3trick1;
		}

		public String getK3trick2() {
			return k3trick2;
		}

		public String getMypreference() {
			return mypreference;
		}

		public String getConcerns() {
			return concerns;
		}
}
