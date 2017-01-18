package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import model.Labyrinth;
import model.Position;

public class AutomatedSolver implements LabyrinthSolver {

	@Override
	public List<Position> solve(Labyrinth l) {
		Position current = new Position(l.getStartCell());
		Queue<Position> q = new LinkedList<>();
		Set<Position> visited = new HashSet<>();
		HashMap<Position, Position> path = new HashMap<>();
		List<Position> solutionPath = new ArrayList<>();

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

				break;

			}

			List<Position> neighbours = l.getNeighbours(current);
			for (Position neighbour : neighbours) {
				if ((l.isFreeAt(neighbour) || l.getFinishCell().equals(neighbour)) && !visited.contains(neighbour)) {
					q.add(neighbour);
					path.put(neighbour, current);
				}
			}

		}

		return solutionPath;

	}

}
