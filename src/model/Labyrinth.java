package model;
import java.util.List;

public interface Labyrinth {
	
	int getRowCount();

	int getColumnCount();

	boolean isFreeAt(Position p);

	boolean isWallAt(Position p);

	Position getStartCell();

	Position getFinishCell();
	
	List<Position> getNeighbours(Position current);

	
}
