package view;

import model.Labyrinth;
import model.Position;

public class LabyrinthText implements LabyrinthView {

	private Labyrinth lab;

	public LabyrinthText(Labyrinth l) {
		lab = l;
	}

	@Override
	public void setLabyrinth(Labyrinth l) {
		lab = l;
	}

	@Override
	public Labyrinth getLabyrinth() {
		return lab;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < lab.getRowCount(); i++) {
			for (int j = 0; j < lab.getColumnCount(); j++) {
				sb.append("|");
				Position current = new Position(i, j);
				
				if (lab.isFreeAt(current))
					sb.append("-");

				if (lab.isWallAt(current))
					sb.append("*");

				if (lab.getStartCell().equals(current))
					sb.append("S");

				if (lab.getFinishCell().equals(current))
					sb.append("F");
			}
			sb.append("|\n");
		}
		return sb.toString();
	}
}
