package chess.domain

import kotlin.math.absoluteValue

enum class Colour {
    BLACK, WHITE
}

sealed class Piece(open val colour: Colour) {
    abstract fun canMove(x: Int, y: Int, toX: Int, toY: Int): Boolean
}

data class Pawn(override val colour: Colour) : Piece(colour) {
    override fun canMove(x: Int, y: Int, toX: Int, toY: Int): Boolean {
        return when {
            x == toX && y == toY -> false
            toX !in (0..7) || toY !in (0..7) -> false
            colour == Colour.WHITE -> {
                toX in (0..7) && y == toY && x + 1 == toX
            }
            colour == Colour.BLACK -> {
                toX in (0..7) && y == toY && x - 1 == toX
            }
            else -> false
        }
    }
}

data class Tower(override val colour: Colour) : Piece(colour) {
    override fun canMove(x: Int, y: Int, toX: Int, toY: Int): Boolean {
        return when {
            x == toX && y == toY -> false
            toX !in (0..7) || toY !in (0..7) -> false
            y == toY -> {
                toX in (0..7)
            }
            x == toX -> {
                toY in (0..7)
            }
            else -> false
        }

    }
}

data class King(override val colour: Colour) : Piece(colour) {
    override fun canMove(x: Int, y: Int, toX: Int, toY: Int): Boolean {
        return when {
            x == toX && y == toY -> false
            toX !in (0..7) || toY !in (0..7) -> false
            y == toY -> {
                toX == x - 1 || toX == x + 1
            }
            x == toX -> {
                toY == y - 1 || toY == y + 1
            }
            else -> false
        }
    }
}

data class Bishop(override val colour: Colour) : Piece(colour) {
    override fun canMove(x: Int, y: Int, toX: Int, toY: Int): Boolean {
        return when {
            x == toX && y == toY -> false
            toX !in (0..7) || toY !in (0..7) -> false
            x.absoluteValue.minus(toX.absoluteValue).absoluteValue == y.absoluteValue.minus(toY.absoluteValue).absoluteValue -> {
                true
            }
            else -> false
        }
    }
}

data class Queen(override val colour: Colour) : Piece(colour) {
    override fun canMove(x: Int, y: Int, toX: Int, toY: Int): Boolean {
        return Bishop(colour).canMove(x, y, toX, toY) || Tower(colour).canMove(x, y, toX, toY)
    }
}

data class Knight(override val colour: Colour) : Piece(colour) {
    override fun canMove(x: Int, y: Int, toX: Int, toY: Int): Boolean {
        return when {
            x == toX && y == toY -> false
            toX !in (0..7) || toY !in (0..7) -> false
            x + 2 == toX && y + 1 == toY -> true
            x + 2 == toX && y - 1 == toY -> true
            x + 1 == toX && y + 2 == toY -> true
            x + 1 == toX && y - 2 == toY -> true

            x - 2 == toX && y + 1 == toY -> true
            x - 2 == toX && y - 1 == toY -> true
            x - 1 == toX && y + 2 == toY -> true
            x - 1 == toX && y - 2 == toY -> true

            else -> false
        }
    }
}

