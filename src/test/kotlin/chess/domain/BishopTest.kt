package chess.domain

import org.junit.Test

class BishopTest {

    @Test
    fun `should allow move a Bishop diagonal up right`() {
        val piece = Bishop(Colour.WHITE)
        assert(piece.canMove(0, 0, 1, 1)) { "can move diagonal up/right" }
    }

    @Test
    fun `should allow move a Bishop diagonal up left`() {
        val piece = Bishop(Colour.WHITE)
        assert(piece.canMove(3, 3, 4, 2)) { "can move diagonal up/left" }
    }

    @Test
    fun `should allow move a Bishop diagonal down left`() {
        val piece = Bishop(Colour.WHITE)
        assert(piece.canMove(3, 3, 2, 2)) { "can move diagonal down/left" }
    }

    @Test
    fun `should allow move a Bishop diagonal down right`() {
        val piece = Bishop(Colour.WHITE)
        assert(piece.canMove(3, 3, 2, 4)) { "can move diagonal down/right" }
    }

    @Test
    fun `should not allow move a black Bishop same place`() {
        val piece = Bishop(Colour.WHITE)
        assert(!piece.canMove(7, 0, 7, 0)) { "can't move same place" }
    }

    @Test
    fun `should not allow move a black Bishop aside`() {
        val piece = Bishop(Colour.WHITE)
        assert(!piece.canMove(1, 1, 1, 2)) { "can't move aside" }
    }

    @Test
    fun `should not allow move a black Bishop aside 2`() {
        val piece = Bishop(Colour.WHITE)
        assert(!piece.canMove(1, 1, 3, 1)) { "can't move aside" }
    }

    @Test
    fun `should not allow move a black Bishop non diagonal`() {
        val piece = Bishop(Colour.WHITE)
        assert(!piece.canMove(1, 1, 5, 2)) { "can't move non diagonal" }
    }

    @Test
    fun `should not allow move a black Bishop out board`() {
        val piece = Bishop(Colour.WHITE)
        assert(!piece.canMove(1, 1, 25, 2)) { "can't move out board" }
    }
}