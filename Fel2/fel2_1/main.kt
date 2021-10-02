//import liby.IDictionary
import java.io.File



fun main(){
    
    //val dict: IDictionary = ListDictionary
    val provider = DictionaryProvider();
    val dict: IDictionary = provider.createDictionary(DictionaryType.ARRAY_LIST)
    println("Number of words: ${dict.size()}")
    var word: String?
    while(true){
        print("What to find? ")
        word = readLine()
        if( word.equals("quit")){
            break
        }
        println("Result: ${word?.let { dict.find(it) }}")
    }

     
    //val file = File("./input.txt")
    //file.forEachLine { println(it) }
}