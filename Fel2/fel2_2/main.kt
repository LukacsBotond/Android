import kotlin.collections.listOf

fun String.monogram():String{
    var szavak = this.split(" ");
    var kezdo: String = "";
    szavak.map { kezdo += it[0] }
    kezdo = kezdo.uppercase();
    println(kezdo)
    return kezdo;
}

fun List<String>.joinList(lista: List<String>,separator:String):String{
    var ret:String = "";
    lista.forEach{ret += (it+separator)}
    return ret.dropLast(1);
}

fun List<String>.longest(lista:List<String>):String{
    var long:String="";
    lista.forEach{ if(it.length > long.length) long = it;}
    return long;
}


fun main(){

    var alma = "alma nagy's"
    var lista = listOf("apple", "pear", "meloasdsdasdn");
   
    alma.monogram();
    println(lista.joinList(lista, "#"));
    println(lista.longest(lista))
}