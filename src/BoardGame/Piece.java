package BoardGame;

public abstract class Piece {
	
	protected Position position;
	private Board board;
	
	
	public Piece(Board board) {

		position = null;
		this.board = board;
		
	}

	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves();

	public boolean possibleMove(Position pos)
	{
		return possibleMoves()[pos.getRow()][pos.getColumn()];
	}

	public boolean isThereAnyPossibleMoves()
	{
		boolean[][] mataux = possibleMoves();
		for(int i = 0;i<mataux.length;i++)
			for(int j = 0; j<mataux.length;j++)
				if(mataux[i][i])
					return true;
		return false;
	}
	
}
