//import liby.IDictionary
import java.io.File

fun main(){
    /*
    val dict: IDictionary = ListDictionary
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

    */    
    val file = File("./input.txt")
    file.forEachLine { println(it) }
}