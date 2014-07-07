package sort_fuer_Pruefung;

public abstract class Sort {
	
	public abstract void sort(int[] array);
	
	public void print(int[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
