package chess.domain

import org.junit.Test

class QueenTest {

    @Test
    fun `should allow move a Queen diagonal up right`() {
        val piece = Queen(Colour.WHITE)
        assert(piece.canMove(0, 0, 1, 1)) { "can move diagonal up/right" }
    }

    @Test
    fun `should allow move a Queen diagonal up left`() {
        val piece = Queen(Colour.WHITE)
        assert(piece.canMove(3, 3, 4, 2)) { "can move diagonal up/left" }
    }

    @Test
    fun `should allow move a Queen diagonal down left`() {
        val piece = Queen(Colour.WHITE)
        assert(piece.canMove(3, 3, 2, 2)) { "can move diagonal down/left" }
    }

    @Test
    fun `should allow move a Queen diagonal down right`() {
        val piece = Queen(Colour.WHITE)
        assert(piece.canMove(3, 3, 2, 4)) { "can move diagonal down/right" }
    }

    @Test
    fun `should not allow move a Queen non diagonal`() {
        val piece = Queen(Colour.WHITE)
        assert(!piece.canMove(1, 1, 5, 2)) { "can't move non diagonal" }
    }

    @Test
    fun `should not allow move a Queen out board`() {
        val piece = Queen(Colour.WHITE)
        assert(!piece.canMove(1, 1, 25, 2)) { "can't move out board" }
    }

    @Test
    fun `should allow move a Queen forward`() {
        val piece = Queen(Colour.WHITE)
        assert(piece.canMove(0, 0, 1, 0)) { "can move forward" }
    }

    @Test
    fun `should allow move a Queen aside`() {
        val piece = Queen(Colour.WHITE)
        assert(piece.canMove(0, 0, 0, 4)) { "can move aside" }
    }

    @Test
    fun `should not allow move a Queen same place`() {
        val piece = Queen(Colour.WHITE)
        assert(!piece.canMove(7, 0, 7, 0)) { "can't move same place" }
    }
}