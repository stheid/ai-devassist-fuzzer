package inputGenerators

interface Fuzzer {
    /**
     * loads all files in the seed to the model
     *
     * @param paths this is actually a list of strings that refers to a file
     */
    fun loadSeed(paths: List<String>)

    /**
     * create new input from internal model
     *
     * in most implementations the first couple of inputs from this functions will be the seed files
     *
     * @return list of files as bytes
     */
    fun createInputs(): Array<ByteArray>

    /**
     * gets execution results of the last input batch passed to the PUT.
     *
     * @param fuzzingResult transformed Observation
     */
    fun observe(fuzzingResult: List<Any>)
}