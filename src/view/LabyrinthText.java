package view;

import java.util.List;

import model.labyrinth.Labyrinth;
import model.util.Position;

public class LabyrinthText implements LabyrinthView {



	@Override
	public String displayLabyrinth(Labyrinth labyrinth) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < labyrinth.getRowCount(); i++) {
			for (int j = 0; j < labyrinth.getColumnCount(); j++) {
				sb.append("|");
				Position current = new Position(i, j);

				if (labyrinth.isFreeAt(current)) {
					sb.append("-");
				}

				if (labyrinth.isWallAt(current)) {
					sb.append("*");
				}

				if (labyrinth.getStartCell().equals(current)) {
					sb.append("S");
				}

				if (labyrinth.getFinishCell().equals(current)) {
					sb.append("F");
				}
			}
			sb.append("|\n");
		}
		return sb.toString();
	}

	@Override
	public String displaySolution(List<Position> solution) {
		StringBuilder sb = new StringBuilder();
		
		for (Position position : solution) {
			sb.append( position.toString() + "\n");
		}
		return sb.toString();
	}
}
