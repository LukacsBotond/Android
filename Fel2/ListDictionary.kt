import kotlin.collections.listOf


object ListDictionary : IDictionary {
    private val words = mutableListOf<String>();
    override fun add(value:String):Boolean{
        return words.add(value);
    }
    override fun find(value:String):Boolean{
        return words.contains(value)
    }
    override fun size():Int{
        return words.size;
    }
}
