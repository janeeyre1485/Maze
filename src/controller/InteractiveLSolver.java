package controller;
import java.util.Scanner;

import model.Labyrinth;
import model.Position;

public class InteractiveLSolver implements LabyrinthSolver {

	Labyrinth l;

	@Override
	public Labyrinth getLabyrinth() {
		return l;
	}

	@Override
	public void setLabyrinth(Labyrinth l) {
		this.l = l;
	}

	public Position nexCellToExplore(Position current) {
		Scanner keyb = new Scanner(System.in);
		Position p;
		int x, y;
		
		do {
			x = keyb.nextInt();
			y = keyb.nextInt();
			p = new Position(x, y);
			if (l.isWallAt(p) || (Math.abs(current.x - p.x) + Math.abs(current.y - p.y) > 1))
				System.out.println("Point not accessible, choose another: ");
		} while (l.isWallAt(p) || (Math.abs(current.x - p.x) + Math.abs(current.y - p.y) > 1));
		
		keyb.close();
		return p;
	}

	public void solve() {
		Position current = new Position(l.getStartCell());
		while (!current.equals(l.getFinishCell())) {
			System.out.println("You are currently at position: " + current.x + ", " + current.y);
			System.out.println("Please choose your next position: ");
			current = nexCellToExplore(current);
		}
		System.out.println("Congratulations, you reaches the final cell!");
	}

}
