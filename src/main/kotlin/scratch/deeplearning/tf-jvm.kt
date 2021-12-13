import org.tensorflow.ConcreteFunction
import org.tensorflow.Signature
import org.tensorflow.TensorFlow
import org.tensorflow.op.Ops
import org.tensorflow.types.TInt32

object HelloTensorFlow {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        println("Hello TensorFlow " + TensorFlow.version())
        ConcreteFunction.create { obj: Ops? -> dbl(obj) }.use { dbl ->
            TInt32.scalarOf(10).use { x ->
                dbl.call(x).use { dblX ->
                    println(x.getInt().toString() + " doubled is " + (dblX as TInt32).getInt())
                }
            }
        }
    }

    private fun dbl(tf: Ops?): Signature {
        val x = tf!!.placeholder(TInt32::class.java)
        val dblX = tf.math.add(x, x)
        return Signature.builder().input("x", x).output("dbl", dblX).build()
    }
}