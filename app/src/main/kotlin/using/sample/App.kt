/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package using.sample

import sample.gradle.mylibrary.Library

class App {
    val greeting: String
        get() {
            return "Hello World! ${Library().someLibraryMethod()}"
        }
}

fun main() {
    println(App().greeting)
}