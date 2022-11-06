package PROCESS;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class lab7_test {
	sortingAlgorithm algo = new sortingAlgorithm();
	int[][] resultSet = new int[5][];
	int Team_Size = 6;

	@Before
	public void setUp() throws Exception {
		for(int i = 0; i < 5; i++) {
			int[] randomArray = new int[20];
			for(int j = 0; j < 20; j++) {
				Random r = new Random();
				randomArray[j] = r.nextInt(101);
//				System.out.println(randomArray[j]);
			}
			resultSet[i] = randomArray;
		}
	}

	@Test
	public void sortAscendingOrder() {
		for(int i = 0; i < 5; i++) {
			int[] tmp = resultSet[i].clone();
			Arrays.sort(tmp);
			assertArrayEquals(tmp, algo.AscendingSort(resultSet[i]));
		}
	}
	
	@Test
	public void sortDescendingOrder() {
		for(int i = 0; i < 5; i++) {
			Integer[] tmp = new Integer[resultSet[i].length];
			int j = 0;
			for (int value : resultSet[i]) {
			    tmp[j++] = Integer.valueOf(value);
			}
			Arrays.sort(tmp, Collections.reverseOrder());

			int[] tmp2 = new int[resultSet[i].length];
			int k = 0;
			for (int value : tmp) {
			    tmp2[k++] = Integer.valueOf(value);
			}
			
			assertArrayEquals(tmp2, algo.DescendingSort(resultSet[i]));
		}
	}
}
