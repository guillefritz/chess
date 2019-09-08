package chess.domain

import org.junit.Test

class GameTest {

    @Test
    fun `should allow move white first`() {
        val game = Game()

        val moveResult = game.move(1, 0, 2, 0)

        assert(game.colourToPlay == Colour.BLACK) { "next turn should be Black" }
        assert(moveResult == MoveResult.BlankSpaceOccupedMove) { "a rival Pawn should be eaten as result" }
    }

    @Test
    fun `should not allow move black first`() {
        val game = Game()

        val moveResult = game.move(6, 0, 5, 0)

        assert(moveResult == MoveResult.InvalidColourMove) { "should be an invalid colour move as a result" }
    }

    @Test
    fun `should allow win the game (eating black piece)`() {
        val game = Game()
        val towerBlack = game.board.getPieceAtLocation(7, 0)
        game.board.setPiece(null, 7, 3)
        game.board.setPiece(towerBlack, 2, 0)

        val moveResult = game.move(1, 0, 2, 0)

        assert(moveResult == MoveResult.EatPieceMove) { "a black tower should be eaten as result" }
        assert(game.colourToPlay == Colour.BLACK) { "next turn should be Black" }
        assert(game.board.getPieceAtLocation(2, 0) != null) { "a piece should be located after move" }
        assert(game.board.getPieceAtLocation(2, 0)?.colour == Colour.WHITE) { "a WHITE piece should be located after move" }
        assert(game.board.getPieceAtLocation(1, 0) == null) { "no piece should be here after move" }
    }

    @Test
    fun `should allow win the game (eating black king)`() {
        val game = Game()
        val kingBlack = game.board.getPieceAtLocation(7, 3)
        game.board.setPiece(null, 7, 3)
        game.board.setPiece(kingBlack, 2, 0)

        val moveResult = game.move(1, 0, 2, 0)

        assert(moveResult == MoveResult.KingEatenMove) { "a black king should be eaten as result" }
    }

}