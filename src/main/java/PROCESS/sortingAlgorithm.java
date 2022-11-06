package PROCESS;

public class sortingAlgorithm {
	
	public int[] AscendingSort(int[] arr) {
		int[] copy = arr.clone();
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 1; j < arr.length; j++) {
				if(copy[j-1] > copy[j]) {
					int tmp = copy[j];
					copy[j] = copy[j-1];
					copy[j-1] = tmp;
				} 
			}
		}
		return copy;
	}
	
	public int[] DescendingSort(int[] arr) {
		int[] copy = arr.clone();
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 1; j < arr.length; j++) {
				if(copy[j-1] < copy[j]) {
					int tmp = copy[j];
					copy[j] = copy[j-1];
					copy[j-1] = tmp;
				} 
			}
		}
		return copy;
	}

//	private int average(int[] data) {
//		try {
//			int sum = 0;
//			for(int i = 0; i < data.length; i++) 
//				sum += data[i];
//			
//			return (sum/data.length);
//		} catch (Exception e) {
//			System.out.println("No student!");
//			return 0;
//		}
//	}
	
	
	
	
}

