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

    override fun toString(): String {
        return "P(${colour.name[0]})"
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
    override fun toString(): String {
        return "T(${colour.name[0]})"
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
    override fun toString(): String {
        return "K(${colour.name[0]})"
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
    override fun toString(): String {
        return "B(${colour.name[0]})"
    }
}

data class Queen(override val colour: Colour) : Piece(colour) {
    override fun canMove(x: Int, y: Int, toX: Int, toY: Int): Boolean {
        return Bishop(colour).canMove(x, y, toX, toY) || Tower(colour).canMove(x, y, toX, toY)
    }
    override fun toString(): String {
        return "Q(${colour.name[0]})"
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
    override fun toString(): String {
        return "H(${colour.name[0]})"
    }
}

