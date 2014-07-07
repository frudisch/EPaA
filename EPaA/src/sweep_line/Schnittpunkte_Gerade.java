package sweep_line;

import java.util.ArrayList;
import java.util.Collections;

public class Schnittpunkte_Gerade {

	public Schnittpunkte_Gerade() {
		Line[] lines;
	}
	
	public void calculate (Line[] lines){
		ArrayList<Line> activeLines = new ArrayList<Line>();
		int j = 0;
		
		for (int i = 0; i < lines.length; i++) {
			activeLines.add(lines[i]);
		}
		
		Collections.sort(activeLines);
		
		for (int i = 0; i < lines.length; i++) {
			lines[i] = activeLines.get(i);
			activeLines.remove(i);
		}
		
		for (int i = 0; i < lines.length; i++) {
			j = i + 1;
			
			activeLines.add(lines[i]);
			while(lines[i].getStart().getX() == lines[j].getStart().getX()){
				activeLines.add(lines[j]);
				++j;
			}
			
			for (int k = 0; k < activeLines.size() - j - 1; k++) {
				if(activeLines.get(k).getEnde().getX() == lines[i].getStart().getX()) activeLines.remove(k);
			}
		}
 	}
}
