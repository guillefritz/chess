package chess.cmd

import chess.domain.Game
import chess.domain.MoveResult

class App {

}

fun main(args: Array<String>) {
    println("Welcome to Chess CMD!")

    var game = Game()
    var playing = true
    while(playing) {
        printBoard(game)
        val stringInput = readLine()!!
        val splitted = stringInput.split(",")

        var x = splitted[0].toIntOrNull() ?:-1
        var y = splitted[1].toIntOrNull() ?:-1
        var toX = splitted[2].toIntOrNull() ?:-1
        var toY = splitted[3].toIntOrNull() ?:-1

        val m = game.move(x, y, toX, toY)

        val moveStr = when(m) {
            MoveResult.KingEatenMove -> "king eaten!"
            MoveResult.InvalidColourMove,MoveResult.InvalidMove -> "bad move, try again!"
            else -> ""
        }

        println(" move: $moveStr")
        println("------------------------------------------------")

    }
}

fun printBoard(game: Game) {

    println("should play ${game.colourToPlay.name}:  ROW,COL,ROW(to),COL(to)")

    var i = 0
    game.board.board.take(8).forEach { x ->
        print("$i |")
        x.forEach { y ->
            print(" ${y?.toString()?:"    "} ")
        }
        println()
        i++
    }
    println("     0     1     2     3     4     5     6     7 ")
}
