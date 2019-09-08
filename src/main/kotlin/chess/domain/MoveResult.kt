package chess.domain

sealed class MoveResult {
    object BlankSpaceOccupedMove : MoveResult()
    object EatPieceMove : MoveResult()
    object KingEatenMove : MoveResult()
    object InvalidMove : MoveResult()
    object InvalidColourMove : MoveResult()
}