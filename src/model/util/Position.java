package model.util;

public class Position {
	private int x;
	private int y;

	public Position() {

	}

	public Position(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public Position(Position p) {
		setX(p.getX());
		setY(p.getY());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Position)) {
			return false;
		}
		Position p = (Position) obj;
		return this.getX() == p.getX() && this.getY() == p.getY();
	}

	@Override
	public int hashCode() {
		int result = getX();
		result = 31 * result + getY();
		return result;
	}

	@Override
	public String toString() {
		return "(" + getX() + ", " + getY() + ")";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
