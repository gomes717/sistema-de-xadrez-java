package chess;



import BoardGame.Board;
import BoardGame.Piece;
import BoardGame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	private Board board;
	
	public ChessMatch() {
		this.board = new Board(8, 8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces()
	{
		ChessPiece[][] mpieces = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < board.getRows(); i++)
		{
			for (int j = 0; j<board.getColumns(); j++)
			{
				mpieces[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mpieces;
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece)
	{
		board.placePiece(piece, new ChessPosition(column,row).toPosition());
	}
	
	private void initialSetup()
	{
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('d', 6, new King(board, Color.WHITE));
		placeNewPiece('c', 6, new King(board, Color.BLACK));
	}
	
	public ChessPiece performeChessMove(ChessPosition sourcePosition, ChessPosition targetPosition)
	{
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source,target);
		return (ChessPiece)capturedPiece;
	}

	private void validateSourcePosition(Position pos) {
		if(!board.thereIsAPiece(pos))
			throw new ChessException("there is no piece");
		if(!board.piece(pos).isThereAnyPossibleMoves())
		{
			throw new ChessException("cant move");
		}
	}
	
	private Piece makeMove(Position source, Position target)
	{
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	
}
