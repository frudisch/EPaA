package bubbleSort;

import java.util.ArrayList;

public class BubbleSort {
	
	private int arr[];
	
	public static void main(String[] args) {
		BubbleSort b = new BubbleSort();
	}
	
	public BubbleSort() {
		int temp[] = new int[10000];
		
		for(int i = 0; i<temp.length; i++){
			temp[i] = (int) (Math.random()*temp.length);
		}
		System.out.println("Array erstellt");
		arr = temp;
		
		long zstVorher;
		long zstNachher;
		
//		System.out.println("Normaler Sort startet");
//		zstVorher = System.currentTimeMillis();
//		sort();
//		zstNachher = System.currentTimeMillis();
//		System.out.println("Zeit normaler Sort: " + ((zstNachher - zstVorher)) + " sec");
//		
//		for(int i = 0; i<temp.length; i++){
//			temp[i] = (int) (Math.random()*temp.length);
//		}
//		System.out.println("Array erstellt");
//		arr = temp;
		
		System.out.println("Thread Sort startet");
		zstVorher = System.currentTimeMillis();
		sortMultiThread();
		zstNachher = System.currentTimeMillis();
		System.out.println("Zeit Thread Sort: " + ((zstNachher - zstVorher)) + " sec");
		
		augeben();
	}

	private void sortMultiThread() {
		ArrayList<Thread> threads = new ArrayList<Thread>();
		
		//for(int n = 0; n<1; n++){
			BubbleUnit temp = new BubbleUnit(this);
			Thread t = new Thread(temp);
			threads.add(t);
			t.start();
		//}
		//for(Thread temp : threads){
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//}
	}

	private void augeben() {
		for(int i : arr){
			System.out.println(i);
		}
	}

	private void sort() {
		for(int n = arr.length; n>1; n--){
			for(int i = 0; i<n-1; i++){
				if(arr[i]>arr[i+1]){
					swap(i, i+1);
				}
			}
		}
		
	}

	synchronized public void swap(int i, int j) {
		int zwischen = arr[i];
		arr[i] = arr[j];
		arr[j] = zwischen;		
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int arr[]) {
		this.arr = arr;
	}

}
