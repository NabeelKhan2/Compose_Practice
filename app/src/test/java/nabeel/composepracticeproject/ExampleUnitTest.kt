package nabeel.composepracticeproject

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun passedTest1() {
        assertEquals(2, solution(2))
    }

    @Test
    fun passedTest2() {
        assertEquals(24, solution(4))
    }

    @Test
    fun passedTest3() {
        assertEquals(1, solution(0))
    }

    @Test
    fun failedTest1() {
        assertEquals(4, solution(1))
    }

    @Test
    fun failedTest2() {
        assertEquals(10, solution(0))
    }

    private fun solution(n: Int): Int{
        return if (n == 0) 1 else n * solution(n - 1)
    }
}