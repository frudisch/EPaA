package sweep_line;

import java.util.ArrayList;
import java.util.Collections;

public class Schnittflaeche_Rechteck {
	
	public static void main(String[] args) {
		new Schnittflaeche_Rechteck();
	}
	
	public Schnittflaeche_Rechteck(){
		ArrayList<Rechteck> rechtecke = new ArrayList<>();
		
		Rechteck temp = new Rechteck(new Punkt(0.0, 0.0), new Punkt(3.0, 0.0), new Punkt(3.0 , 4.0), new Punkt(0.0, 4.0));
		rechtecke.add(temp);
		temp = new Rechteck(new Punkt(2.0, 2.0), new Punkt(5.0, 2.0), new Punkt(5.0 , 8.0), new Punkt(2.0, 8.0));
		rechtecke.add(temp);
		temp = new Rechteck(new Punkt(4.0, 5.0), new Punkt(7.0, 5.0), new Punkt(7.0 , 7.0), new Punkt(4.0, 7.0));
		rechtecke.add(temp);
		temp = new Rechteck(new Punkt(4.0, 0.0), new Punkt(9.0, 0.0), new Punkt(9.0 , 1.0), new Punkt(4.0, 1.0));
		rechtecke.add(temp);
		temp = new Rechteck(new Punkt(1.0, 1.0), new Punkt(2.5, 1.0), new Punkt(2.5, 3.0), new Punkt(1.0, 3.0));
		rechtecke.add(temp);
//		temp = new Rechteck(new Punkt(0.0, 0.0), new Punkt(10.0, 0.0), new Punkt(10.0, 10.0), new Punkt(0.0, 10.0));
//		rechtecke.add(temp);
		
		calculate(rechtecke);
	}

	public void calculate(ArrayList<Rechteck> rechtecke){
		ArrayList<Rechteck> activate = new ArrayList<Rechteck>();
		int counter = 0;
		
		Collections.sort(rechtecke);
		
		for (int i = 0; i < rechtecke.size(); i++) {
			deactivate(activate, rechtecke.get(i));
			
			counter += findConflicts(activate, rechtecke.get(i));
				
			activate.add(rechtecke.get(i));
		}
		System.out.println(counter);
	}

	private int findConflicts(ArrayList<Rechteck> activate, Rechteck rechteck) {
		int counter = 0;
		
		for (int i = 0; i < activate.size(); i++) {
			//rechteck schnitt oben
			if(rechteck.getX1().getY() >= activate.get(i).getX1().getY() && rechteck.getX1().getY() <= activate.get(i).getX3().getY()){
				//System.out.println("1: " + activate.size());
				counter++;
				findFaeche(activate.get(i), rechteck);
			}else if((rechteck.getX3().getY() >= activate.get(i).getX1().getY() && rechteck.getX3().getY() <= activate.get(i).getX3().getY())){
				//System.out.println("2");
				findFaeche(activate.get(i), rechteck);
				counter++;
			}
		}
		return counter;
	}

	private void findFaeche(Rechteck rechteck, Rechteck schnittRechteck) {
		double flaeche;
		
		if(rechteck.getX1().getY() < schnittRechteck.getX1().getY() && rechteck.getX3().getY() > schnittRechteck.getX3().getY()){
			if(rechteck.getX3().getX() > schnittRechteck.getX3().getX()){
				flaeche = berechneFL(schnittRechteck.getX1(), schnittRechteck.getX2(), schnittRechteck.getX3(), schnittRechteck.getX4());
			}else{
				Punkt x2 = new Punkt(rechteck.getX2().getX(), schnittRechteck.getX1().getY());
				Punkt x3 = new Punkt(rechteck.getX2().getX(), schnittRechteck.getX3().getY());
				flaeche = berechneFL(schnittRechteck.getX1(), x2, x3, schnittRechteck.getX4());
			}
		}else{
			if(schnittRechteck.getX3().getY() > rechteck.getX3().getY()){
				Punkt x2 = new Punkt(rechteck.getX2().getX(), schnittRechteck.getX1().getY());
				Punkt x4 = new Punkt(schnittRechteck.getX1().getX(), rechteck.getX3().getY());
				flaeche = berechneFL(schnittRechteck.getX1(), x2, rechteck.getX3(), x4);
			}else{
				Punkt x1 = new Punkt(schnittRechteck.getX1().getX(), rechteck.getX1().getY());
				Punkt x3 = new Punkt(rechteck.getX2().getX(), schnittRechteck.getX4().getY());
				flaeche = berechneFL(x1, rechteck.getX2(), x3, schnittRechteck.getX4());
			}
		}
		
		System.out.println(flaeche);
	}

	private double berechneFL(Punkt x1, Punkt x2, Punkt x3, Punkt x4) {
		double rc;
		
		rc = (x2.getX() - x1.getX()) * (x3.getY() - x2.getY());
				
		return rc;
	}

	private void deactivate(ArrayList<Rechteck> activate, Rechteck rechteck) {
		for (int i = 0; i < activate.size(); i++) {
			if(activate.get(i).getX2().getX() < rechteck.getX1().getX()){
				activate.remove(i);
				--i;
			}
		}		
	}
}
