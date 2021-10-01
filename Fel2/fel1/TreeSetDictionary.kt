import java.util.TreeSet


object TreeSetDictionary : IDictionary{
    var words = TreeSet<String>();
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