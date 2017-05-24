package ia;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import model.Model;
import view.game.GGrid;
import view.game.Square;

public class RandomIA extends IA {
	GGrid grid;
	
	Model model;
	

	public RandomIA(GGrid gGrid, Model model, int number) {
		super(number);
		this.grid = gGrid;
		this.model = model;
		this.number = number;
		
	}

	public int alea(int Min, int Max) {
		return Min + (int) (Math.random() * ((Max - Min) + 1));
	}

	@Override
	public void update(Observable o, Object arg) {

		//

		HashMap hm = (HashMap) arg;
		
		if (hm.containsKey("turn")) {
			System.out.println(hm.get("turn"));
			if ((int) hm.get("turn") == this.number) {


				Square[][] b = grid.getGrid();

				int position = alea(1, 4);



				int x = alea(0, model.getX() );
				int y = alea(0, model.getY() );
				b[x][y].playerTake(model.playerTurn, position, false);
			}
		}

	}
}
