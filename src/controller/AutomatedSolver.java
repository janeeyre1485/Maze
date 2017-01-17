package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.Labyrinth;
import model.Position;

public class AutomatedSolver implements LabyrinthSolver {
	private Labyrinth l;

	public AutomatedSolver(Labyrinth l) {
		this.l = l;
	}

	@Override
	public Labyrinth getLabyrinth() {
		return l;
	}

	@Override
	public void setLabyrinth(Labyrinth l) {
		this.l = l;
	}

	public void solve() {
		Position current = new Position(l.getStartCell());
		Queue<Position> q = new LinkedList<Position>();
		List<Position> visited = new ArrayList<Position>();
		HashMap<Position, Position> path = new HashMap<Position, Position>();
		List<Position> solutionPath = new ArrayList<Position>();

		q.add(current);
		visited.add(current);
		path.put(current, null);

		while (!q.isEmpty()) {
			current = q.poll();
			visited.add(current);
			if (current.equals(l.getFinishCell())) {
				solutionPath.add(current);
				do {
					current = path.get(current);
					solutionPath.add(current);
				} while (path.get(current) != null);

				for (Position position : solutionPath) {
					System.out.println(position.toString());
				}
				return;
			}

			List<Position> neighbours = l.getNeighbours(current);
			for (Position neighbour : neighbours) {
				if ((l.isFreeAt(neighbour) || l.getFinishCell().equals(neighbour)) && !visited.contains(neighbour)) {
					q.add(neighbour);
					path.put(neighbour, current);
				}
			}

		}
	}

}
