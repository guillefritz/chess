package chess.domain

import org.junit.Test

class PawnTest {

    @Test
    fun `should allow move a white Pawn forward`() {
        val piece = Pawn(Colour.WHITE)
        assert(piece.canMove(0, 0, 1, 0)) { "can move forward" }
    }

    @Test
    fun `should not allow move a white Pawn forward`() {
        val piece = Pawn(Colour.WHITE)
        assert(!piece.canMove(0, 0, 2, 0)) { "can't move forward twice" }
    }

    @Test
    fun `should allow move a black Pawn forward`() {
        val piece = Pawn(Colour.BLACK)
        assert(piece.canMove(7, 0, 6, 0)) { "can move forward" }
    }


    @Test
    fun `should not allow move a black Pawn forward`() {
        val piece = Pawn(Colour.WHITE)
        assert(!piece.canMove(7, 0, 4, 0)) { "can't move forward twice" }
    }

    @Test
    fun `should not allow move a black Pawn same place`() {
        val piece = Pawn(Colour.WHITE)
        assert(!piece.canMove(7, 0, 7, 0)) { "can't move same place" }
    }
}