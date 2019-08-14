import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class SolutionTest(private val input: Array<CharArray>, private val expected: Int) {
    private val soln = Solution1()

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun params() = arrayOf(
                arrayOf(arrayOf(
                        "11110".toCharArray(),
                        "11010".toCharArray(),
                        "11000".toCharArray(),
                        "00000".toCharArray()), 1),
                arrayOf(arrayOf(
                        "11000".toCharArray(),
                        "11000".toCharArray(),
                        "00100".toCharArray(),
                        "00011".toCharArray()), 3)
        )
    }

    @Test
    fun test() {
        assertEquals(expected, soln.numIslands(input))
    }
}