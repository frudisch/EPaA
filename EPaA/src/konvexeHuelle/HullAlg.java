package konvexeHuelle;
import java.util.Random;

public class HullAlg {
	
	public static void main(String[] args) {
		Point[] Pointe = new Point[15];
		
		Random rand = new Random(150);
		for (int i = 0; i < Pointe.length; i++) {
			Pointe[i] = new Point(rand.nextDouble()*10, rand.nextDouble()*10);
		}
		
		HullAlg test = new HullAlg();
		test.print(Pointe);
		Pointe = test.huelle(Pointe);
		test.print(Pointe);
	}
	
	
	public Point[] huelle(Point[] Pointe){
		int minInd = findMin(Pointe);
		int maxInd = findMax(Pointe);
		
		Point[] a = leftMax(minInd, maxInd, Pointe);
		Point[] b = leftMax(maxInd, minInd, Pointe);
		
		Point[] temp = {Pointe[minInd], Pointe[maxInd]};
		
		return concat(concat(a, b), temp);
	}
	private int findMax(Point[] Pointe) {
		double max = Pointe[0].getX();
		int rc = 0;
		
		for (int i = 1; i < Pointe.length; i++) {
			if(Pointe[i].getX() > max){
				rc = i;
				max = Pointe[i].getX();
			}
		}
		
		return rc;
	}
	private int findMin(Point[] Pointe) {
		double min = Pointe[0].getX();
		int rc = 0;
		
		for (int i = 1; i < Pointe.length; i++) {
			if(Pointe[i].getX() < min){
				rc = i;
				min = Pointe[i].getX();
			}
		}
		
		return rc;
	}
	private Point[] leftMax(int minInd, int maxInd, Point[] Pointe) {
		boolean found = false;
		int tempInd = 0;
		double tempFl = 0;
		
		for (int i = 0; i < Pointe.length; i++) {
			if(flaeche(Pointe[minInd], Pointe[maxInd], Pointe[i]) > tempFl){
				tempFl = flaeche(Pointe[minInd], Pointe[maxInd], Pointe[i]);
				tempInd = i;
				found = true;
			}
		}
		
		if(found){
			Point[] temp = new Point[1];
			temp[0] = Pointe[tempInd];
			
			Point[] a = leftMax(minInd, tempInd, Pointe);
			Point[] b = leftMax(tempInd, maxInd, Pointe);
			return concat(concat(a,b), temp);
		} else {
			return new Point[0];
		}
		
	}
	private Point[] concat(Point[] a, Point[] b) {
		Point[] rc = new Point[a.length + b.length];
		for (int i = 0; i < a.length; i++) {
			rc[i] = a[i];
		}
		for (int i = a.length; i < rc.length; i++) {
			rc[i] = b[i-a.length];
		}
		
		
		return rc;
	}
	private boolean determinante(Point a, Point b, Point c){
		if((b.getX() - a.getX())*(c.getY() - a.getY()) - (c.getX() - a.getX())*(b.getY() - a.getY()) < 0) return false; //c rechts
		return true; //c links
	}
	
	private double flaeche(Point a , Point b, Point c){
		return (b.getX() - a.getX())*(c.getY() - a.getY()) - (c.getX() - a.getX())*(b.getY() - a.getY());
	}
	
	private void print(Point[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.println("("+arr[i].getX()+","+arr[i].getY()+")");
		}
		System.out.println("\n");
	}
}
