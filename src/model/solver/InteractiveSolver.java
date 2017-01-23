package model.solver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.labyrinth.Labyrinth;
import model.util.Position;

public class InteractiveSolver extends AbstractLabyrinthSolver {

	@Override
	public List<Position> solve(Labyrinth l) {
		Position current = l.getStartCell();
		solutionPath = new ArrayList<>();
		solutionPath.add(current);
		while (!current.equals(l.getFinishCell())) {
			System.out.println("You are currently at position: " + current.getX() + ", " + current.getY());
			System.out.println("Please choose your next position: ");
			current = nexCellToExplore(current, l);
			solutionPath.add(current);
		}
		System.out.println("Congratulations, you reaches the final cell!");
		return solutionPath;
	}

	private Position nexCellToExplore(Position current, Labyrinth l) {
		Scanner keyb = new Scanner(System.in);
		Position p;
		int x, y;

		do {
			x = keyb.nextInt();
			y = keyb.nextInt();
			p = new Position(x, y);
			if (l.isWallAt(p) || (Math.abs(current.getX() - p.getX()) + Math.abs(current.getY() - p.getY()) > 1)) {
				System.out.println("Point not accessible, choose another: ");
			}
		} while (l.isWallAt(p) || (Math.abs(current.getX() - p.getX()) + Math.abs(current.getY() - p.getY()) > 1));

		keyb.close();
		return p;
	}

	@Override
	public List<Position> getSolution() {
		return solutionPath;
	}
}
