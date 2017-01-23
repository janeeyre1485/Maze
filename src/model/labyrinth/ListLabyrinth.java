package model.labyrinth;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import model.util.Position;

public class ListLabyrinth extends AbstractLabyrinth {

	private HashMap<Position, Integer> labyrinthMap;

	public ListLabyrinth(String path) {
		try (Scanner sc = new Scanner(new File(path))) {

			readSetupValues(sc);
			rows = sc.nextInt();
			columns = sc.nextInt();

			int objCount = sc.nextInt();
			labyrinthMap = new HashMap<>();

			for (int i = 0; i < objCount; i++) {
				int x, y, type;
				x = sc.nextInt();
				y = sc.nextInt();
				type = sc.nextInt();
				labyrinthMap.put(new Position(x, y), type);
				if (type == startValue) {
					start = new Position(x, y);
				}
				if (type == finishValue) {
					finish = new Position(x, y);
				}
			}
			sc.close();

		} catch (Exception ex) {
			System.out.println("File was not found");
		}
	}

	@Override
	public List<Position> getNeighbours(Position current) {
		List<Position> neighbours = new ArrayList<Position>();
		if (current.getX() - 1 >= 0) {
			neighbours.add(new Position(current.getX() - 1, current.getY()));
		}
		if (current.getY() + 1 < columns) {
			neighbours.add(new Position(current.getX(), current.getY() + 1));
		}
		if (current.getX() + 1 < rows) {
			neighbours.add(new Position(current.getX() + 1, current.getY()));
		}
		if (current.getY() - 1 >= 0) {
			neighbours.add(new Position(current.getX(), current.getY() - 1));
		}
		return neighbours;

	}

	@Override
	protected int getValueForPosition(Position p) {
		if (labyrinthMap.get(p) == null) {
			return 0;
		}
		return labyrinthMap.get(p);
	}

}
