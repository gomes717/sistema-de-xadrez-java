package BoardGame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] mPieces;
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1)
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		this.rows =rows;
		this.columns = columns;
		mPieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column)
	{
		if(!positionExists(row,column))
			throw new BoardException("position not on the board");
		return mPieces[row][column];
	}
	
	public Piece piece(Position position)
	{
		if(!positionExists(position))
			throw new BoardException("position not on the board");
		return mPieces[position.getRow()][position.getColumn()];
	}
	
	
	public void placePiece(Piece piece, Position position)
	{
		if(thereIsAPiece(position))
			throw new BoardException("there is a piece in this position");
		mPieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public boolean positionExists(int row,int column)
	{
		return (row>=0 && row < rows && column >=0 && column < columns);
	}
	
	public boolean positionExists(Position pos)
	{
		return positionExists(pos.getRow(),pos.getColumn());
	}
	
	public boolean thereIsAPiece(Position pos)
	{
		if(!positionExists(pos))
			throw new BoardException("position not on the board");
		return piece(pos) != null;
	}
	
	public Piece removePiece(Position position)
	{
		if(!positionExists(position))
			throw new BoardException("position not on the board");
		if(piece(position) == null)
			return null;
		Piece aux = piece(position);
		aux.position = null;
		mPieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
}
