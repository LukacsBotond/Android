import java.util.Base64
import kotlin.collections.listOf

fun primteszt(szam: Int): Boolean {
    if (szam < 2 || szam % 2 == 0 || szam % 3 == 0 || szam % 5 == 0) {
        return false
    }
    val veg: Int = szam / 2
    for (i in 7..veg step 2) {
        if (szam % i == 0) {
            return false
        }
    }
    return true
}

fun encod(input: String): String {
    return Base64.getEncoder().encodeToString(input.toByteArray())
}

fun decod(input: String): String {
    val decodedBytes = Base64.getDecoder().decode(input)
    return String(decodedBytes)
}

fun messageCoding(msg: String, func: (input: String) -> String): String {
    return func(msg)
}

fun evenPrint(inp: List<Int>): Unit = inp.filter { it % 2 == 0 }.forEach { println(it) }

fun even(i: Int): Boolean {
    if (i % 2 == 0) {
        return true
    }
    return false
}

fun main() {
    val a = 2
    val b = 3
    println("$a + $b = ${a+b}")

    var listOfWeek = listOf("hetfo", "kedd", "szerda", "friday")
    for (i in listOfWeek) {
        println(i)
    }
    listOfWeek.filter { it.startsWith("h") }.forEach { println(it) }

    listOfWeek.filter { it.contains("e") }.forEach { println(it) }

    listOfWeek.filter { it.length == 6 }.forEach { println(it) }

    for (i in 1..120) {
        if (primteszt(i)) {
            println(i)
        }
    }
    val encoded = messageCoding("almafa", ::encod)
    val decoded = messageCoding(encoded, ::decod)
    println(decoded)
    val lista = listOf(1, 2, 6, 565, 5441, 541, 354, 64, 6, 43541, 34135, 465, 41, 215, 4351, 2)
    evenPrint(lista)

    lista.map { it * 2 }.forEach { println(it) }
    listOfWeek.map { it.uppercase() }.forEach { println(it) }
    listOfWeek.map { it.capitalize()[0] }.forEach { println(it) }
    listOfWeek.map { it }.forEach { println(it.length) }
    listOfWeek.map { it.length }.forEach { println(it) }

    var mutList = listOfWeek.toMutableList()
    mutList.filter { !it.contains('n') }.sortedBy { it }.forEach {
        println("Item at ${mutList.indexOf(it)} is $it")
    }

    var radArray = List(10) { (0..10).random() }.toMutableList()
    radArray.sort() // .forEach{println(it)};
    radArray.forEach { println(it) }
    println(radArray.any { even(it) })
    println(radArray.all { even(it) }); // .forEach{println(it)}
    println(radArray.average())
    var sum = 0
    radArray.forEach { sum += it }
    println("atlag = ${sum/radArray.size}")
}
