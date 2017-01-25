package model.labyrinth;
import java.util.List;

import model.util.Position;

public interface Labyrinth {
	
	int getRowCount();

	int getColumnCount();

	boolean isFreeAt(Position p);

	boolean isWallAt(Position p);

	Position getStartCell();

	Position getFinishCell();
	
	List<Position> getNeighbours(Position current);

	
}
