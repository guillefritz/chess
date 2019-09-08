package chess.domain

import org.junit.Test

class BoardTest {

    @Test
    fun `should set a piece inside the board`() {
        val piece = Pawn(Colour.WHITE)
        val board = Board()
        board.setPiece(piece, 2, 1)
        assert(board.getPieceAtLocation(2, 1) == piece)
    }

    @Test
    fun `should reset a board with the default pieces in place`() {
        val board = Board()
        board.resetBoard()
        assert(board.getPieceAtLocation(1, 0) is Pawn) { "should be a Pawn placed here" }
        assert(board.getPieceAtLocation(6, 0) is Pawn) { "should be a Pawn placed here" }

        assert(board.getPieceAtLocation(0, 0) is Tower) { "should be a Pawn placed here" }
        assert(board.getPieceAtLocation(0, 1) is Knight) { "should be a Knight placed here" }
        assert(board.getPieceAtLocation(0, 2) is Bishop) { "should be a Bishop placed here" }
        assert(board.getPieceAtLocation(0, 3) is King) { "should be a King placed here" }
        assert(board.getPieceAtLocation(0, 4) is Queen) { "should be a Queen placed here" }
        assert(board.getPieceAtLocation(0, 5) is Bishop) { "should be a Bishop placed here" }
        assert(board.getPieceAtLocation(0, 6) is Knight) { "should be a Knight placed here" }
        assert(board.getPieceAtLocation(0, 7) is Tower) { "should be a Tower placed here" }

        assert(board.getPieceAtLocation(7, 0) is Tower) { "should be a Pawn placed here" }
        assert(board.getPieceAtLocation(7, 1) is Knight) { "should be a Knight placed here" }
        assert(board.getPieceAtLocation(7, 2) is Bishop) { "should be a Bishop placed here" }
        assert(board.getPieceAtLocation(7, 3) is King) { "should be a King placed here" }
        assert(board.getPieceAtLocation(7, 4) is Queen) { "should be a Queen placed here" }
        assert(board.getPieceAtLocation(7, 5) is Bishop) { "should be a Bishop placed here" }
        assert(board.getPieceAtLocation(7, 6) is Knight) { "should be a Knight placed here" }
        assert(board.getPieceAtLocation(7, 7) is Tower) { "should be a Tower placed here" }

        assert(board.getPieceAtLocation(3, 0) == null) { "should be a null here" }
    }

    @Test
    fun `should allow move a piece in a blank space`() {
        val board = Board()
        board.setPiece(King(Colour.WHITE), 2, 2)
        assert(board.canMove(2, 2, 3, 2)) { "could move to a empty place" }
    }

    @Test
    fun `should allow move a piece in a rival(black) piece`() {
        val board = Board()
        board.setPiece(Pawn(Colour.WHITE), 2, 2)
        board.setPiece(Pawn(Colour.BLACK), 3, 2)
        assert(board.canMove(2, 2, 3, 2)) { "could move to a empty place" }
    }

    @Test
    fun `should not allow move a piece in a same colour piece`() {
        val board = Board()
        board.setPiece(Pawn(Colour.WHITE), 2, 2)
        board.setPiece(Pawn(Colour.WHITE), 3, 2)
        assert(!board.canMove(2, 2, 3, 2)) { "should not allow move a piece in a same colour piece" }
    }

    @Test
    fun `should get BlankSpaceOccupedMove result from a move`() {
        val board = Board()
        board.setPiece(Pawn(Colour.WHITE), 2, 2)
        assert(board.move(2, 2, 3, 2) == MoveResult.BlankSpaceOccupedMove) { "should be a BlankSpaceOccupedMove result" }
    }

    @Test
    fun `should get EatPieceMove result from a move`() {
        val board = Board()
        board.setPiece(Pawn(Colour.WHITE), 2, 2)
        board.setPiece(Pawn(Colour.BLACK), 3, 2)
        assert(board.move(2, 2, 3, 2) == MoveResult.EatPieceMove) { "a rival Pawn should be eaten as result" }
    }


    @Test
    fun `should get KingEatenMove result from a move`() {
        val board = Board()
        board.setPiece(Pawn(Colour.WHITE), 2, 2)
        board.setPiece(King(Colour.BLACK), 3, 2)
        assert(board.move(2, 2, 3, 2) == MoveResult.KingEatenMove) { "a rival Pawn should be eaten as result" }
    }
}