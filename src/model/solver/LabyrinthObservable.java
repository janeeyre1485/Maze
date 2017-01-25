package model.solver;

import view.LabyrinthObserver;

public interface LabyrinthObservable {
	public void addObserver(LabyrinthObserver observer);
	public void deleteObserver(LabyrinthObserver observer);
	public void notifyObservers();
}
