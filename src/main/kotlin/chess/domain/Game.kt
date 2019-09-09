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

        return board.move(x, y, toX, toY).also {
            colourToPlay = if (colourToPlay == Colour.WHITE) Colour.BLACK else Colour.WHITE
        }
    }

}