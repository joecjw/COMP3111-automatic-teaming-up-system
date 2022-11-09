package PROCESS;

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
			this.rowid = new String(row_id);
			this.studentid = new String(student_id);
			this.studentname = new String(student_name);
			this.email = new String(student_email);
			this.k1energy = new String(k1_energy);
			this.k2energy = new String(k2_energy);
			this.k3trick1 = new String(k3_trick1);
			this.k3trick2 = new String(k3_trick1);
			this.mypreference = new String(my_preference);
			this.concerns = new String(concerns);
		}
	
		public String getRowid() {
			return rowid;
		}
		
		public String getStudentid() {
			return studentid;
		}

//		public void setStudentid(String val) {
//			studentid.set(val);
//		}

		public String getStudentname() {
			return studentname;
		}
		
		public String getEmail() {
			return email;
		}

//		public void setStudentname(String val) {
//			studentname.set(val);
//		}

		public String getK1energy() {
			return k1energy;
		}

//		public void setK1energy(String val) {
//			k1energy.set(val);
//		}

		public String getK2energy() {
			return k2energy;
		}

//		public void setK2energy(String val) {
//			k2energy.set(val);
//		}
		
		public String getK3trick1() {
			return k3trick1;
		}

//		public void setK3trick1(String val) {
//			k3trick1.set(val);
//		}

		public String getK3trick2() {
			return k3trick2;
		}

//		public void setK3trick2(String val) {
//			k3trick2.set(val);
//		}

		public String getMypreference() {
			return mypreference;
		}

//		public void setMypreference(String val) {
//			mypreference.set(val);
//		}

		public String getConcerns() {
			return concerns;
		}

//		public void setConcerns(String val) {
//			concerns.set(val);
//		}

}
