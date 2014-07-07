package sort_fuer_Pruefung;

public class Heap extends Sort{
	
	public static void main(String[] args) {
		new Heap();
	}

	public Heap() {
		int vArray [] = {0,
				16, 2,
				18, 15, 3, 19,
				1, 12, 11, 13, 4, 17, 9, 5,
				8, 10, 14, 6, 7};
		
		sort(vArray);
		print(vArray);
	}

	public void sort(int[] array) {
		int laenge = array.length;
		
		heapify(array, laenge);
		while(laenge > 1){
			laenge--;
			swap(array, 0, laenge);
			reheap(array, 0, laenge);
		}
	}
	
	public void heapify(int[] array, int i){		
		for(int root = i/2 - 1; root >= 0; root--){
			reheap(array, root, i);
		}
	}

	public void reheap(int[] array, int root, int ende){
		int daughter = root*2 + 1;
		
		while(daughter < ende){
			if(daughter + 1 < ende){
				if(array[daughter + 1] > array[daughter]) daughter++;
			}
			if(array[root] >= array[daughter]) return;
			
			swap(array, root, daughter);
			
			root = daughter;
			daughter = root*2 + 1; 
		}
		
	}

	private void swap(int[] array, int root, int daughter) {
		int temp = array[root];
		array[root] = array[daughter];
		array[daughter] = temp;
	}
}
