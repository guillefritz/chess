package chess.domain

/**
 *(X)
 * 7
 * 6
 * 5
 * 4
 * 3
 * 2
 * 1
 * 0
 *      0   1   2   3   4   5   6   7   (Y)
 */
class Board {

    var board: Array<Array<Piece?>> = arrayOf()

    init {
        for (x in 0..7) {
            val subarray = arrayOf<Piece?>(null, null, null, null, null, null, null, null)
            board += subarray
        }
    }

    fun resetBoard() {
        for (x in 0..7) {
            val subarray = arrayOf<Piece?>(null, null, null, null, null, null, null, null)
            board += subarray
        }

        val subarray = Array<Piece?>(8) { null }
        subarray.fill(Pawn(Colour.WHITE), 0, 7)
        board[1] = subarray
        board[0] = arrayOf(Tower(Colour.WHITE), Knight(Colour.WHITE), Bishop(Colour.WHITE), King(Colour.WHITE), Queen(Colour.WHITE), Bishop(Colour.WHITE), Knight(Colour.WHITE), Tower(Colour.WHITE))

        val subarrayB = Array<Piece?>(8) { null }
        subarrayB.fill(Pawn(Colour.BLACK), 0, 7)
        board[6] = subarrayB
        board[7] = arrayOf(Tower(Colour.BLACK), Knight(Colour.BLACK), Bishop(Colour.BLACK), King(Colour.BLACK), Queen(Colour.BLACK), Bishop(Colour.BLACK), Knight(Colour.BLACK), Tower(Colour.BLACK))

    }

    fun setPiece(piece: Piece?, x: Int, y: Int) {
        board[x][y] = piece
    }

    fun getPieceAtLocation(x: Int, y: Int): Piece? {
        return board[x][y]
    }

    fun isValidPlaceInBoard(x: Int, y: Int): Boolean {
        return x in (0..7) || y in (0..7)
    }

    fun canMove(x: Int, y: Int, toX: Int, toY: Int): Boolean {
        //out of board pieces from/to
        if (!isValidPlaceInBoard(x, y) || !isValidPlaceInBoard(toX, toY)) {
            return false
        }
        val piece = getPieceAtLocation(x, y) ?: return false //not found piece
        val legalMove = piece.canMove(x, y, toX, toY)
        return if (legalMove) {
            val toPiece = getPieceAtLocation(toX, toY)
            toPiece == null || toPiece.colour != piece.colour
        } else {
            false
        }
    }

    fun move(x: Int, y: Int, toX: Int, toY: Int): MoveResult {
        if (!canMove(x, y, toX, toY)) {
            return MoveResult.InvalidMove
        }

        val fromPiece = getPieceAtLocation(x, y)
        val toPiece = getPieceAtLocation(toX, toY)
        setPiece(null, x, y)
        setPiece(fromPiece, toX, toY)
        return when (toPiece) {
            is King -> {
                MoveResult.KingEatenMove
            }
            null -> {
                MoveResult.BlankSpaceOccupedMove
            }
            else -> {
                MoveResult.EatPieceMove
            }
        }
    }

}

