package chess.domain

class Game {

    open val board = Board()
    var colourToPlay = Colour.WHITE

    init {
        board.resetBoard()
    }

    fun move(x: Int, y: Int, toX: Int, toY: Int): MoveResult {

        val pieceFrom = board.getPieceAtLocation(x, y)

        if (pieceFrom?.colour != colourToPlay) {
            return MoveResult.InvalidColourMove
        }

        val moveResult = board.move(x, y, toX, toY)

        if(moveResult !in arrayOf(MoveResult.InvalidMove, MoveResult.InvalidColourMove)) {
            colourToPlay = if (colourToPlay == Colour.WHITE) Colour.BLACK else Colour.WHITE
        }

        return moveResult
    }

}