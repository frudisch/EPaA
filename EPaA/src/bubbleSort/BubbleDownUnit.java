package bubbleSort;

public class BubbleDownUnit  implements Runnable{

	private BubbleSort main;
	private int n;
	
	public BubbleDownUnit(BubbleSort main, int n) {
		this.main = main;
		this.n = n;
	}
	
	public void run() {
		for(int i = n; i>0; i--){
			if(main.getArr()[i]<main.getArr()[i-1]){
				main.swap(i, i-1);
			}
		}		
	}

}
