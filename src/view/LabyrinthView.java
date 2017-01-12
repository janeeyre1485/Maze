package view;
import model.Labyrinth;

public interface LabyrinthView {
	
	public String toString();

	public void setLabyrinth(Labyrinth l);

	public Labyrinth getLabyrinth();
}
