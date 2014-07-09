package sweep_line;

import java.util.ArrayList;
import java.util.Collections;

public class Schnittpunkte_Gerade {
	
	public static void main(String[] args) {
		new Schnittpunkte_Gerade();
	}

	public Schnittpunkte_Gerade() {
		Line[] lines = new Line[5];
		
		lines[0] = new Line(new Punkt(0.0, 5.0), new Punkt(5.0, 5.0));
		lines[1] = new Line(new Punkt(2.0, 0.0), new Punkt(2.0, 8.0));
		lines[2] = new Line(new Punkt(3.0, 2.5), new Punkt(8.0, 2.5));
		lines[3] = new Line(new Punkt(4.0, 4.0), new Punkt(6.0, 4.0));
		lines[4] = new Line(new Punkt(5.0, 0.0), new Punkt(5.0, 8.0));
		
		calculate(lines);
	}
	
	public void calculate (Line[] lines){
		int schnittStellenCounter = 0;
		ArrayList<Line> activeLines = new ArrayList<Line>();
		
		for (int i = 0; i < lines.length; i++) {
			activeLines.add(lines[i]);
		}
		
		Collections.sort(activeLines);
		
		for (int i = 0; i < lines.length; i++) {
			lines[i] = activeLines.get(i);
		}
		
		for (int i = 0; i < activeLines.size(); i++) {
			activeLines.remove(i);
		}
		
		for (int i = 0; i < lines.length; i++) {
			
			activate(lines, activeLines, i);
						
			deactivate(lines, activeLines, i);
			
			for (int k = 0; k < activeLines.size(); k++) {
				if(activeLines.get(k).isVertivcal()){
					for (int indActiveLines = 0; indActiveLines < activeLines.size(); indActiveLines++) {
						if(k == indActiveLines) continue;
						if(!activeLines.get(indActiveLines).isVertivcal() && activeLines.get(indActiveLines).getStart().getY() >= activeLines.get(k).getStart().getY() && activeLines.get(indActiveLines).getEnde().getY() <= activeLines.get(k).getEnde().getY()){
							++schnittStellenCounter;
						}
					}
				}
			}
			
			
		}
		System.out.println(schnittStellenCounter);
 	}

	private void deactivate(Line[] lines, ArrayList<Line> activeLines, int i) {
		double temp = lines[i].getEnde().getX();
		for (int k = 0; k < activeLines.size(); k++) {
			if(activeLines.get(k).getEnde().getX() < temp){
				activeLines.remove(k);
				k--;
			}
		}
	}

	private void activate(Line[] lines, ArrayList<Line> activeLines, int i) {
		double temp = lines[i].getStart().getX();
		while(i < lines.length && Double.compare(temp, lines[i].getStart().getX()) == 0){
			activeLines.add(lines[i]);
			i++;
		}
	}
}
