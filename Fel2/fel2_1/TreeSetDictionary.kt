import java.util.TreeSet
import java.io.File


object TreeSetDictionary : IDictionary {
    var words = TreeSet<String>()
    init{
        val file = File("./input.txt")
        file.forEachLine { words.add(it) }
        println(words)
    }
    override fun add(value: String): Boolean {
        return words.add(value)
    }
    override fun find(value: String): Boolean {
        return words.contains(value)
    }
    override fun size(): Int {
        return words.size
    }
}
