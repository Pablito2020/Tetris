package game

interface ScoreCalculator {
    fun getScore(cleanedRows: Int): Points
}