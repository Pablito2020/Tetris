package score

import score.Points

interface ScoreCalculator {
    fun getScore(cleanedRows: Int): Points
}