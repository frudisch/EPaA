package sweep_line;

import java.util.ArrayList;
import java.util.Collections;

public class Schnittpunkte_Gerade {

	public Schnittpunkte_Gerade() {
		Line[] lines;
	}
	
	public void calculate (Line[] lines){
		ArrayList<Line> activeLines = new ArrayList<Line>();
		
		for (int i = 0; i < lines.length; i++) {
			activeLines.add(lines[i]);
		}
		
		Collections.sort(activeLines);
		
		for (int i = 0; i < lines.length; i++) {
			lines[i] = activeLines.get(i);
			activeLines.remove(i);
		}
 	}
}
