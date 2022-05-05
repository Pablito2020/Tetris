package score

class SimpleScoreCalculator : ScoreCalculator {
    override fun getScore(cleanedRows: Int) = when (cleanedRows) {
        0 -> Points(0)
        1 -> Points(40)
        2 -> Points(100)
        3 -> Points(160)
        4 -> Points(200)
        else -> throw java.lang.IllegalArgumentException("Rows should be from 0 to 4, not {$cleanedRows}")
    }
}