package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixLabyrinth extends AbstractLabyrinth {

	private int labyrinthMatrix[][];

	public MatrixLabyrinth(String path) {

		try (Scanner sc = new Scanner(new File(path))) {

			readSetupValues(sc);

			rows = sc.nextInt();
			columns = sc.nextInt();
			labyrinthMatrix = new int[rows][columns];

			for (int i = 0; i < rows; i++)
				for (int j = 0; j < columns; j++) {
					labyrinthMatrix[i][j] = sc.nextInt();
					if (labyrinthMatrix[i][j] == startValue) {
						start = new Position(i, j);
					}
					if (labyrinthMatrix[i][j] == finishValue) {
						finish = new Position(i, j);
					}
				}

		} catch (Exception ex) {
			System.out.println(ex.toString());
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
		return labyrinthMatrix[p.getX()][p.getY()];
	}

}
