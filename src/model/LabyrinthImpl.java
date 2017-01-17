package model;
public abstract class LabyrinthImpl implements Labyrinth{
	protected int startValue, finishValue, freeValue, wallValue;
	protected int rows, columns;
	protected Position start, finish;
	
	
	public Position getStartCell() {
		return start;
	}

	public Position getFinishCell() {
		return finish;
	}
	
	public int getRowCount() {
		return rows;
	}

	public int getColumnCount() {
		return columns;
	}

}
