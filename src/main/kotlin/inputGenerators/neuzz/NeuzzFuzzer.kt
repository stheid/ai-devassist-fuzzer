package inputGenerators.neuzz

import inputGenerators.Fuzzer
import mu.KLogging

class NeuzzFuzzer(jazzerCommand: Any) : Fuzzer {
    var isWarmedUp = false
    var model = NeuzzModel()
    lateinit var batch: Array<ByteArray>

    companion object : KLogging()

    /**
     * loads all files in the seed to the model
     *
     * @param paths this is actually a list of strings that refers to a file
     */
    override fun loadSeed(paths: List<String>) {
        logger.info { "stuff" }
        TODO("Not yet implemented")
    }

    /**
     * create new input from internal model
     *
     * in most implementations the first couple of inputs from this functions will be the seed files
     *
     * @return list of files as bytes
     */
    override fun createInputs(): Array<ByteArray> {
        if (!isWarmedUp) {
            /*
            collect seedfiles if any
            run jazzer with the seedfiles
            run jazzer for a defined time to collect trainingdata
             */

            TODO("Not yet implemented")

            model.retrain(listOf())
            isWarmedUp = true
        }
        batch = model.generateInputs()
        return batch
    }

    /**
     * gets execution results of the last input batch passed to the PUT.
     *
     * @param fuzzingResult transformed Observation
     */
    override fun observe(fuzzingResult: List<Any>) {
        val cov = fuzzingResult.filterIsInstance<IntArray>()

        val newData = batch.zip(cov).map { (input, cov) -> DataPoint(input, cov) }

        // train NN
        model.retrain(newData)
    }
}

