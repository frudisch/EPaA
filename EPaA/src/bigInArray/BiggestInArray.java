package bigInArray;

public class BiggestInArray {
	
	public static void main(String[] args) {
		new BiggestInArray();
	}
	
	public BiggestInArray() {
		int[] arr = {-1, 2, -3, 5, -2, -1, 8, -2, 0, 1, -9, 3, -1, 3, -4, 8, 2, 1};
		int max = biggest(arr);
		System.out.println(max);
	}

	private int biggest(int[] arr) {
		int rc = 0;
		int max = 0;
		int posMom = 0;
		int temp;
		
		for (int i = 1; i < arr.length - 1; i++) {
			temp = arr[i-1] + arr[i];
			if(temp > 0){
				if(posMom == i - 1){
					posMom = i;
					max = max + arr[i-1];
				}else{
					rc = max;
					max = arr[i-1];
					posMom = i;
				}
			}else{
				if(i + 2 < arr.length){
					if((arr[i] + arr[i+1]) <= (arr[i+1] + arr[i + 2])){
						posMom = i;
						max = max + arr[i-1];
					}else{
						rc = max;
						max = arr[i-1];
						posMom = i;
					}
				}
			}
		}
		
		if(max > rc){
			rc = max;
		}
		
		return rc;
	}

}
