package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public Color getColor() {
        return color;
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }

    protected void increaseMoveCount() {
        moveCount++;
    };

    protected void decreaseMoveCount() {
        moveCount--;
    };

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position.getRow(), position.getColumn());
        return (p != null) && (p.getColor() != color);
    }
}
