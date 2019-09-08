package chess.domain

import org.junit.Test

class KingTest {

    @Test
    fun `should allow move a King forward`() {
        val piece = King(Colour.WHITE)
        assert(piece.canMove(0, 0, 1, 0)) { "can move forward" }
    }

    @Test
    fun `should allow move a King aside`() {
        val piece = King(Colour.WHITE)
        assert(piece.canMove(0, 0, 0, 1)) { "can move aside" }
    }

    @Test
    fun `should not allow move a King diagonal`() {
        val piece = King(Colour.WHITE)
        assert(!piece.canMove(0, 0, 1, 1)) { "can't move diagonal" }
    }

    @Test
    fun `should not allow move a King forward more than one place`() {
        val piece = King(Colour.WHITE)
        assert(!piece.canMove(0, 0, 3, 0)) { "can't move forward more than one place" }
    }

    @Test
    fun `should not allow move a King aside more than one place`() {
        val piece = King(Colour.WHITE)
        assert(!piece.canMove(0, 0, 0, 2)) { "can't move aside more than one place" }
    }

    @Test
    fun `should not allow move a King same place`() {
        val piece = King(Colour.WHITE)
        assert(!piece.canMove(7, 0, 7, 0)) { "can't move same place" }
    }
}