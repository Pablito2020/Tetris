package blocks

import java.io.*

fun serialize(o: Serializable): ByteArray {
    val bos = ByteArrayOutputStream()
    val out = ObjectOutputStream(bos)
    out.writeObject(o)
    out.flush()
    return bos.toByteArray()
}

fun deserialize(bytes: ByteArray): Any {
    val bis = ByteArrayInputStream(bytes)
    val inp = ObjectInputStream(bis)
    return inp.readObject()
}