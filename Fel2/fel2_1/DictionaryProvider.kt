enum class DictionaryType {
    ARRAY_LIST,
    TREE_SET,
    HASH_SET
}

class DictionaryProvider {
    fun createDictionary(type: DictionaryType): IDictionary {
        when (type) {
            DictionaryType.ARRAY_LIST -> return ListDictionary
            DictionaryType.TREE_SET -> return TreeSetDictionary
            DictionaryType.HASH_SET -> return HashSetDictionary
        }
    }
}
