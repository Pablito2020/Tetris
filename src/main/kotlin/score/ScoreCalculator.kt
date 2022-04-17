package score

interface ScoreCalculator {
    fun getScore(cleanedRows: Int): Points
}