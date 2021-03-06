import java.util.ArrayList;

public class Bishop extends Piece
{
	String pieceType;

	public Bishop(Player player, String type) 
  {
		super(player, type);
		pieceType = type;
	}

	public boolean isValid(Square[][] board, int prevX, int prevY, int finX, int finY) 
  {
		Square targetSquare = board[finX][finY];
		ArrayList<Square> moves = getPotentialMoves(board, prevX, prevY);
		for (Square move : moves) 
    {
			if (targetSquare == move) 
      {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Square> getPotentialMoves(Square[][] board, int prevX, int prevY) 
  {
		ArrayList<Square> moves = new ArrayList<Square>();
		Square startSquare = board[prevX][prevY];
		//Loop through each diagonal until we either fall off board or find another piece in the way
		for (int j = 0; j < 8; j++) 
    {
			int incrX = prevX + j;
			int incrY = prevY + j;
			if (incrX > 7) 
      {
				incrX = 7;
			}
			if (incrY > 7) 
      {
				incrY = 7;
			}
			Piece potentialPiece = board[incrX][incrY].getPiece();
			if ((prevX + j > 7) || (prevY + j > 7) || startSquare == board[prevX + j][prevY + j]){
				continue;
			}
			if (potentialPiece == null) 
      {
				moves.add(board[prevX + j][prevY + j]);
			} 
      else 
      {
				if (potentialPiece.getPlayer() == getPlayer()) 
        {
					//Same color piece
					break;
				} 
        else 
        {
					//Enemy piece
					moves.add(board[prevX + j][prevY + j]);
					break;
				}
			}
		}
		for (int j = 0; j < 8; j++) 
    {
			int incrX = prevX + j;
			int decrY = prevY - j;
			if (incrX > 7) 
      {
				incrX = 7;
			}
			if (decrY < 0) 
      {
				decrY = 0;
			}
			Piece potentialPiece = board[incrX][decrY].getPiece();
			if ((prevX + j > 7) || (prevY - j < 0) || startSquare == board[prevX + j][prevY - j]){
				continue;
			}
			if (potentialPiece == null) 
      {
				moves.add(board[prevX + j][prevY - j]);
			} 
      else 
      {
				if (potentialPiece.getPlayer() == getPlayer()) 
        {
					// Same color piece
					break;
				} 
        else 
        {
					// Enemy piece
					moves.add(board[prevX + j][prevY - j]);
					break;
				}
			}
		}
		for (int j = 0; j < 8; j++) 
    {
			int decrX = prevX - j;
			int incrY = prevY + j;
			if (decrX < 0) 
      {
				decrX = 0;
			}
			if (incrY > 7) 
      {
				incrY = 7;
			}
			Piece potentialPiece = board[decrX][incrY].getPiece();
			if ((prevX - j < 0) || (prevY + j > 7) || startSquare == board[prevX - j][prevY + j]){
				continue;
			}
			if (potentialPiece == null) 
      {
				moves.add(board[prevX - j][prevY + j]);
			} 
      else 
      {
				if (potentialPiece.getPlayer() == getPlayer()) 
        {
					// Same color piece
					break;
				} 
        else 
        {
					// Enemy piece
					moves.add(board[prevX - j][prevY + j]);
					break;
				}
			}
		}
		for (int j = 0; j < 8; j++) 
    {
			int decrX = prevX - j;
			int decrY = prevY - j;
			if (decrX < 0 || decrY < 0) 
      {
				decrX = 0;
				decrY = 0;
			}
			Piece potentialPiece = board[decrX][decrY].getPiece();
			if ((prevX - j < 0) || (prevY - j < 0) || startSquare == board[prevX - j][prevY - j])
      {
				continue;
			}
			if (potentialPiece == null) 
      {
				moves.add(board[prevX - j][prevY - j]);
			} 
      else 
      {
				if (potentialPiece.getPlayer() == getPlayer()) 
        {
					// Same color piece
					break;
				} 
        else 
        {
					// Enemy piece
					moves.add(board[prevX - j][prevY - j]);
					break;
				}
			}
		}
		return moves;
	}
	
	public String getPieceType() 
  {
		return pieceType;
	}
}