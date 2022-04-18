package score

class SimpleScoreCalculator : ScoreCalculator {
    override fun getScore(cleanedRows: Int) = when (cleanedRows) {
        0 -> Points(0)
        1 -> Points(40 * 100)
        2 -> Points(100 * 100)
        3 -> Points(300 * 100)
        4 -> Points(1200 * 100)
        else -> throw java.lang.IllegalArgumentException("Rows should be from 0 to 4, not {$cleanedRows}")
    }
}