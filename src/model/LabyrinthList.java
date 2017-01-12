package model;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LabyrinthList extends LabyrinthImpl {

	private HashMap<Position, Integer> list;

	@Override
	public int getRowCount() {
		return rows;
	}

	@Override
	public int getColumnCount() {
		return columns;
	}

	@Override
	public boolean isFreeAt(Position p) {
		return !list.containsKey(p);
	}


	@Override
	public boolean isWallAt(Position p) {
		return list.containsKey(p) && list.get(p) != startValue && list.get(p) != finishValue;
	}

	@Override
	public void loadFromFile(String path) {
		try {
			Scanner sc = new Scanner(new File(path));
			rows = sc.nextInt();
			columns = sc.nextInt();

			int objCount = sc.nextInt();
			list = new HashMap<Position, Integer>();

			for (int i = 0; i < objCount; i++) {
				int x, y, type;
				x = sc.nextInt();
				y = sc.nextInt();
				type = sc.nextInt();
				list.put(new Position(x, y), type);
				if (type == startValue)
					start = new Position(x, y);
				if (type == finishValue)
					finish = new Position(x, y);
			}
			sc.close();

		} catch (Exception ex) {
			System.out.println("File was not found");
		}

	}

	@Override
	public List<Position> getNeighbours(Position current) {
		List<Position> neighbours = new ArrayList<Position>();
		if (current.x - 1 >= 0)
			neighbours.add(new Position(current.x - 1, current.y));
		if (current.y + 1 < columns)
			neighbours.add(new Position(current.x, current.y + 1));
		if (current.x + 1 < rows)
			neighbours.add(new Position(current.x + 1, current.y));
		if (current.y - 1 >= 0)
			neighbours.add(new Position(current.x, current.y - 1));
		return neighbours;

	}

}
