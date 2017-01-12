package model;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LabyrinthMatrix extends LabyrinthImpl {

	private int matrix[][];
	private int  freeValue, wallValue;

	public LabyrinthMatrix(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;

		matrix = new int[rows][columns];
	}

	public LabyrinthMatrix() {
	}

	public void loadFromFile(String path) {
		Scanner sc;
		try {
			sc = new Scanner(new File(path));
			rows = sc.nextInt();
			columns = sc.nextInt();
			matrix = new int[rows][columns];
			for (int i = 0; i < rows; i++)
				for (int j = 0; j < columns; j++) {
					matrix[i][j] = sc.nextInt();
					if (matrix[i][j] == startValue)
						start = new Position(i, j);
					if (matrix[i][j] == finishValue)
						finish = new Position(i, j);
				}
			sc.close();
		} catch (Exception ex) {
			System.out.println("File was not found");
		}

	}


	@Override
	public boolean isFreeAt(Position p) {
		if (matrix[p.x][p.y] == freeValue || p.equals(finish))
			return true;
		return false;
	}

	@Override
	public boolean isWallAt(Position p) {
		if (matrix[p.x][p.y] == wallValue)
			return true;
		return false;
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
