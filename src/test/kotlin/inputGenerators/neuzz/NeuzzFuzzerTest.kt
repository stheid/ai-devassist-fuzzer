package inputGenerators.neuzz

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class NeuzzFuzzerTest {

    @Test
    fun loadSeed() {
        val fuzzer = NeuzzFuzzer()
        fuzzer.loadSeed(listOf("test"))
    }
}