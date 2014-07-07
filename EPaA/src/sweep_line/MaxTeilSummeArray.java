package sweep_line;

public class MaxTeilSummeArray {
	
	public MaxTeilSummeArray() {
		int[] array = {2, -4, 3, -1, 4, -1, 5, -9, 2, -6, 5, -3, 5};
		int max = calculate(array);
		System.out.println(max);
	}

	private int calculate(int[] array) {
		int maximum = 0;
		int temp = 0;
		
		for (int i = 0; i < array.length; i++) {
			temp += array[i];
			if(maximum < temp) maximum = temp;
			
			if(temp < 0){
				temp = 0;
			}
		}
		
		return maximum;
	}

	public static void main(String[] args) {
		new MaxTeilSummeArray();
	}
}
