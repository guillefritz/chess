package chess.domain

import org.junit.Test

class KnightTest {

    @Test
    fun `should allow move a Knight 2forward right`() {
        val piece = Knight(Colour.WHITE)
        assert(piece.canMove(0, 0, 2, 1)) { "can move 2forward right" }
    }

    @Test
    fun `should allow move a Knight 2forward left`() {
        val piece = Knight(Colour.WHITE)
        assert(piece.canMove(0, 1, 2, 0)) { "can move 2forward right" }
    }

    @Test
    fun `should allow move a Knight forward 2right`() {
        val piece = Knight(Colour.WHITE)
        assert(piece.canMove(0, 0, 1, 2)) { "can move forward 2right" }
    }

    @Test
    fun `should allow move a Knight forward 2left`() {
        val piece = Knight(Colour.WHITE)
        assert(piece.canMove(2, 2, 3, 0)) { "can move forward 2left" }
    }

    @Test
    fun `should allow move a Knight 2back right`() {
        val piece = Knight(Colour.WHITE)
        assert(piece.canMove(3, 3, 1, 4)) { "can move 2back right" }
    }

    @Test
    fun `should allow move a Knight 2back left`() {
        val piece = Knight(Colour.WHITE)
        assert(piece.canMove(3, 3, 1, 2)) { "can move 2back right" }
    }

    @Test
    fun `should not allow move a Knight forward`() {
        val piece = Knight(Colour.WHITE)
        assert(!piece.canMove(3, 3, 4, 3)) { "not allow move a Knight forward" }
    }

    @Test
    fun `should not allow move a Knight aside`() {
        val piece = Knight(Colour.WHITE)
        assert(!piece.canMove(3, 3, 3, 5)) { "not allow move a Knight aside" }
    }

    @Test
    fun `should not allow move a Knight diagonal`() {
        val piece = Knight(Colour.WHITE)
        assert(!piece.canMove(3, 3, 4, 4)) { "not allow move a Knight diagonal" }
    }
}