import java.util.ArrayList;

public class Rook extends Piece
{
	String pieceType;

	public Rook(Player player, String type) 
  {
		super(player, type);
		pieceType = "Rook";
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
		for (int j = 0; j < 8; j++) 
    {
			int incrX = prevX + j;
			if (incrX > 7) 
      {
				incrX = 7;
			}
			Piece potentialPiece = board[incrX][prevY].getPiece();
			if ((prevX + j > 7) || startSquare == board[prevX + j][prevY]) 
      {
				continue;
			}
			if (potentialPiece == null) 
      {
				moves.add(board[prevX + j][prevY]);
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
					// Enemy Piece
					moves.add(board[prevX + j][prevY]);
					break;
				}
			}
		}
		for (int j = 0; j < 8; j++) 
    {
			int decrX = prevX - j;
			if (decrX < 0) 
      {
				decrX = 0;
			}
			Piece potentialPiece = board[decrX][prevY].getPiece();
			if ((prevX - j < 0) || startSquare == board[prevX - j][prevY]) 
      {
				continue;
			}
			if (potentialPiece == null) 
      {
				moves.add(board[prevX - j][prevY]);
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
					// Enemy Piece
					moves.add(board[prevX - j][prevY]);
					break;
				}
			}
		}
		for (int j = 0; j < 8; j++) 
    {
			int incrY = prevY + j;
			if (incrY > 7) 
      {
				incrY = 7;
			}
			Piece potentialPiece = board[prevX][incrY].getPiece();
			if ((prevY + j > 7) || startSquare == board[prevX][prevY + j]) 
      {
				continue;
			}
			if (potentialPiece == null) 
      {
				moves.add(board[prevX][prevY + j]);
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
					// Enemy Piece
					moves.add(board[prevX][prevY + j]);
					break;
				}
			}
		}
		for (int j = 0; j < 8; j++) 
    {
			int decrY = prevY - j;
			if (decrY < 0) 
      {
				decrY = 0;
			}
			Piece potentialPiece = board[prevX][decrY].getPiece();
			if ((prevY - j < 0) || startSquare == board[prevX][prevY - j]) 
      {
				continue;
			}
			if (potentialPiece == null) {
				moves.add(board[prevX][prevY - j]);
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
					// Enemy Piece
					moves.add(board[prevX][prevY - j]);
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