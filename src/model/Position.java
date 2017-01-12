package model;

public class Position {
	public int x, y;

	public Position() {
		x = 0;
		y = 0;
	}

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Position(Position p) {
		x = p.x;
		y = p.y;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Position))
			return false;
		Position p = (Position) obj;
		return this.x == p.x && this.y == p.y;
	}

	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		return result;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
