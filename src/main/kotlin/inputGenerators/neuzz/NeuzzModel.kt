package inputGenerators.neuzz

data class DataPoint(val input:ByteArray, val coverage: IntArray )

class NeuzzModel() {
    val dataSet = mutableListOf <DataPoint>()
    val model = nn

    /**
     * Retrain model with additional training data
     * @param newData additional data collected
     */
    fun retrain(newData:List<DataPoint>){

        TODO("Not yet implemented")



        dataSet.addAll(newData)
    }


    fun generateInputs ( ): Array<ByteArray>{

        // select collection of parent files

        // generate new mutated inputs using backprop and exaustive search (Algo 1 from the paper)

        TODO("Not yet implemented")
    }

}