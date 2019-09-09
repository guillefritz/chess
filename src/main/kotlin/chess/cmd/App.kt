package chess.cmd

import chess.domain.Game

fun main(args: Array<String>) {
    println("Welcome to Chess CMD!")

    var game = Game()
    var playing = true
    while(playing) {
        printBoard(game)
        val stringInput = readLine()!!
        val splitted = stringInput.split(",")

        var x = splitted[0].toInt()
        var y = splitted[1].toInt()
        var toX = splitted[2].toInt()
        var toY = splitted[3].toInt()

        game.move(x, y, toX, toY)
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
