package view;
import model.Labyrinth;
import model.Position;

public class LabyrinthText implements LabyrinthView {

	private Labyrinth lab;

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
				if (lab.isFreeAt(new Position(i, j)))
					sb.append("-");
				if (lab.isWallAt(new Position(i, j)))
					sb.append("*");
				if (lab.getStartCell().x == i && lab.getStartCell().y == j)
					sb.append("S");
				if (lab.getFinishCell().x == i && lab.getFinishCell().y == j)
					sb.append("F");
			}
			sb.append("|\n");
		}
		return sb.toString();
	}
}
