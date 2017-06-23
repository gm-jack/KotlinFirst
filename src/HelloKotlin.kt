import java.io.File

/**
 * Created by yxy on 2017/6/15.
 */
fun main(args: Array<String>) {
    println("Hellow Kotlin")

    var x = 0
    if (x !in 1..5)
        println(x)

    println("3+5 = ${sum(3, 5)}")

    println("length  =  ${getLength("hahahaha")}")

//    var names = Array<String>(2, )
//    var name: String = "1"
//    var a: Int = 0
//    if (name in names) {
//        a = sum(1, 2)
//        println(a)
//    }

    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))

    var list = listOf<String>("a", "b", "c", "d", "e", "f")
    println("list.size  = ${list.size}    list.indices    =  ${list.indices}")

    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }

    //循环自动增加  默认step 1
    for (x in 2..5) {
        println(x)
    }
    //递增2
    for (x in 1..10 step 2) {
        println(x)
    }

    //递减
    for (x in 10 downTo 2) {
        println(x)
    }

    val items = listOf("apple", "banana", "kiwi")
//sampleStart
    for (item in items) {
        println(item)
    }

    when {
        "orange" in items -> println("-1")
        "kiwi" in items -> println("3")
    }

    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }

    //访问map
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    for ((k, v) in map) {
        println("$k -> ${map.getValue(k)}     $v")
    }

    val p: String by lazy {
        "aaaaaa${x}"
    }
    println(p)

    //if not null
    val files = File("Test").listFiles()
    println(files?.size)

    //if not null and else
    println(files?.size ?: "empty")

    var number: Float = 123f

    println(number === number)

    //类型不能转换
    //val b: Byte = 1 // OK, 字面值是静态检测的
    //val i: Int = b // 错误

    // 创建一个 Array<String> 初始化为 ["0", "1", "4", "9", "16"]
    var arr = Array(3, { i -> (i * i).toString() })

    var intArr: IntArray = intArrayOf(1, 2, 3)

    //原生字符串，内部没有转义
    var text = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin("|")
    println("原生字符串  \n $text")

    //if分支可以是代码块 最后的表达式是返回值
    var a = 5
    var b = 6
    var max = if (a > b) {
        a
    } else {
        b
    }
    println(max)

    //循环for
    for (ai in arr) {
        println(ai)
    }
    for (ai in arr.indices) {
        println(arr[ai])
    }
    lin@ for ((k, v) in arr.withIndex()) {
        if (k == 1) {
            continue@lin
        }
        println("$k  -> $v")
    }

    arr.forEach {
        foreach@
        fun(v: Int) {
            if (v == 1)
                return@foreach
            println("匿名函数   $v")
        }
    }
//    arr.forEach {
//        if ( == 1)
//            return@forEach
//        println("匿名函数   $it")
//    }

    var person = Person("小明")
    println(person.name)
    person.ageName = "123456"
    println(person.ageName)
    println(person.exten())
    person.foo()
    println(person.ageName)


    //指定构造函数默认值
    var person1 = Person()

    var person2 = person.copy(name = "小茗同学")
    var (name) = person2
    println("name  =  $name")

    var str = arr.map { value -> value }
    for (st in str) {
        println("str   ${str.indices}  $st")
    }

    println(1 sha 2)
}

infix fun Int.sha(x: Int): Int {
    return x
}

//扩展
fun Person.exten(): Int = 1

fun Person.foo() {

}

fun check(c: Char) {
    if (c.toInt() == 1) {

    }
}

fun <K, V> List<K>.map(tranform: (K) -> V): List<V> {
    var result = arrayListOf<V>()
    for (item in this)
        result.add(tranform(item))
    return result
}

//when 替换 switch语句
fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

//当某个变量的值可以为  null  的时候，必须在声明处的类型后添加  ?  来标识该引用可为空
fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun getLength(obj: Any): Int? {
    if (obj is String) {
        return obj.length
    }
    return null
}

//普通返回
fun sum(a: Int, b: Int) = a + b

//无意义
fun sums(a: Int, b: Int): Unit {

}

fun max(a: Int, b: Int): Int = if (a > b) {
    a
} else {
    b
}