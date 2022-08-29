package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class Pawn extends ChessPiece {
    public Pawn(Board board, Color color) {
        super(board, color);
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean isWhite(Color color) {
        if (color == Color.WHITE) {
            return true;
        }
        return false;
    }


    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        if (piece.getMoveCount() == 0) {
            if (isWhite(getColor())) {
                //Above
                p.setValues(position.getRow() - 1, position.getColumn());
                if (getBoard().positionExists(p) && canMove(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
                p.setValues(position.getRow() - 2, position.getColumn());
                if (getBoard().positionExists(p) && canMove(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
                return mat;
            } else {
                //Bellow
                p.setValues(position.getRow() + 1, position.getColumn());
                if (getBoard().positionExists(p) && canMove(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
                p.setValues(position.getRow() + 2, position.getColumn());
                if (getBoard().positionExists(p) && canMove(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
                return mat;
            }
        }
        else {
            if (isWhite(getColor())) {
                Position opponentPosition = new Position(position.getRow()-1, position.getColumn()+1);
                Position opponentPosition2 = new Position(position.getRow()-1, position.getColumn()-1);


                if (isThereOpponentPiece(opponentPosition)) {
                    p.setValues(position.getRow() - 1, position.getColumn()+1);
                    if (getBoard().positionExists(p) && canMove(p)) {
                        mat[p.getRow()][p.getColumn()] = true;
                    }
                }

                if (isThereOpponentPiece(opponentPosition2)) {
                    p.setValues(position.getRow() - 1, position.getColumn()-1);
                    if (getBoard().positionExists(p) && canMove(p)) {
                        mat[p.getRow()][p.getColumn()] = true;
                    }
                }
                p.setValues(position.getRow() - 1, position.getColumn());
                if (getBoard().positionExists(p) && canMove(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                }

                return mat;
            }
            else {
                //Bellow
                Position opponentPosition = new Position(position.getRow()+1, position.getColumn()+1);
                Position opponentPosition2 = new Position(position.getRow()+1, position.getColumn()-1);

                if (isThereOpponentPiece(opponentPosition)) {
                    p.setValues(position.getRow() + 1, position.getColumn() + 1);
                    if (getBoard().positionExists(p) && canMove(p)) {
                        mat[p.getRow()][p.getColumn()] = true;
                    }
                }
                if (isThereOpponentPiece(opponentPosition2)) {
                    p.setValues(position.getRow() + 1, position.getColumn() - 1);
                    if (getBoard().positionExists(p) && canMove(p)) {
                        mat[p.getRow()][p.getColumn()] = true;
                    }
                }

                p.setValues(position.getRow() + 1, position.getColumn());
                if (getBoard().positionExists(p) && canMove(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
                return mat;
            }
        }
    }

    @Override
    public String toString() {
        return "P";
    }
}

