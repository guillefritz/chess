package chess.domain

import org.junit.Test

class TowerTest {

    @Test
    fun `should allow move a Tower forward`() {
        val piece = Tower(Colour.WHITE)
        assert(piece.canMove(0, 0, 1, 0)) { "can move forward" }
    }

    @Test
    fun `should allow move a Tower aside`() {
        val piece = Tower(Colour.WHITE)
        assert(piece.canMove(0, 0, 0, 4)) { "can move aside" }
    }

    @Test
    fun `should not allow move a Tower diagonal`() {
        val piece = Tower(Colour.WHITE)
        assert(!piece.canMove(0, 0, 2, 1)) { "can't move diagonal" }
    }

    @Test
    fun `should not allow move a Tower same place`() {
        val piece = Tower(Colour.WHITE)
        assert(!piece.canMove(7, 0, 7, 0)) { "can't move same place" }
    }
}