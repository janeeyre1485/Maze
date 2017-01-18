package model;

import java.util.Scanner;

public abstract class AbstractLabyrinth implements Labyrinth {
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

	public void readSetupValues(Scanner sc) {
		try {
			startValue = sc.nextInt();
			finishValue = sc.nextInt();
			freeValue = sc.nextInt();
			wallValue = sc.nextInt();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	
	public boolean isFreeAt(Position p){
		return freeValue == getValueForPosition(p);
	}
	
	public boolean isWallAt(Position p){
		return wallValue == getValueForPosition(p);
	}
	
	protected abstract int getValueForPosition(Position p);

}
