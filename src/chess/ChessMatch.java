package chess;

import BoardGame.Board;
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
	
	private void initialSetup()
	{
		board.placePiece(new Rook(board, Color.WHITE), new Position(3,1));
		board.placePiece(new King(board, Color.WHITE), new Position(4,1));
		board.placePiece(new King(board, Color.BLACK), new Position(4,2));
	}
	
}
