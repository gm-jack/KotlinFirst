import sun.rmi.runtime.Log
import java.util.logging.Logger

/**
 * Created by yxy on 2017/6/22.
 *
 */
//主构造函数在头
data class Person(var name: String = "") : MyInterface {

    companion object {
        lateinit var instance: Person
    }

    override fun foo(x: Int) {
        this.ageName = "123"
        println(ageName)
    }

    lateinit var parent: String

    //主构造初始化
    init {
        instance = this
    }

    val ages get() = this.name.toInt()

    var ageName: String get() = "1234"
        set(value) {
            "123"
        }

    constructor(name: String, age: Int) : this(name) {

    }

}