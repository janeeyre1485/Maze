package model.labyrinth;

public  class LabyrinthFactory {
	public Labyrinth createLabyrinth(String path){
		Labyrinth l = null;
		if (path.contains("list")){
			l = new ListLabyrinth(path);
		}
		if(path.contains("matrix")){
			l = new MatrixLabyrinth(path);
		}
		return l;
	}

}
