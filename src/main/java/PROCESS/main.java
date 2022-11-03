package PROCESS;

public class main {

	public static void main(String[] args) {
		fileInterpreter a = new fileInterpreter();
		studentData database = new studentData("abc");
		algorithm ATU = new algorithm();
		a.read(database);
//		a.print(database);
		ATU.compute(database);
		a.print(database);
		
		
	}

}
