package bubbleSort;

public class BubbleUnit implements Runnable{

	private BubbleSort main;
	private int n;

	public BubbleUnit(BubbleSort main, int n) {
		this.main = main;
		this.n = n;
	}
	
	public BubbleUnit(BubbleSort main) {
		this.main = main;
		n = main.getArr().length;
	}

	public void run() {
		for(int i = 0; i<n-1; i++){
			if(main.getArr()[i]>main.getArr()[i+1]){
				BubbleDownUnit temp = new BubbleDownUnit(this.main, i);
				Thread t = new Thread(temp);
				t.start();
				main.swap(i, i+1);
			}
		}
	}

}
