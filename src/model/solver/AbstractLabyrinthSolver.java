package model.solver;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.util.Position;
import view.LabyrinthObserver;

public abstract class AbstractLabyrinthSolver implements LabyrinthSolver, LabyrinthObservable{

//	@Override
//	public abstract List<Position> solve(Labyrinth l) ;
	
	protected ArrayList<LabyrinthObserver> observers = new ArrayList<>();
	protected List<Position> solutionPath;
	
	@Override
	public List<Position> getSolution(){
		return solutionPath;
	}
	
	@Override
	public void addObserver(LabyrinthObserver o){
		observers.add(o);
	}
	
	@Override
	public void deleteObserver(LabyrinthObserver o){
		observers.remove(o);
	}
	
	@Override
	public void notifyObservers(){
		for (LabyrinthObserver observer : observers) {
			observer.processSolution(this);
		}
	}

}
