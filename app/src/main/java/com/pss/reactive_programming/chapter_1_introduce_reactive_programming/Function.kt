package com.pss.reactive_programming.chapter_1_introduce_reactive_programming

import java.util.*

/*출력값
Sum 30
random output 6
named pure func square = 16
lambda pure func qube = 64
a 10 is Valid
a 17 is Invalid
1 Output 2
2 Output 6
3 Output 12
4 Output 20
5 Output 30
6 Output 42
7 Output 56
8 Output 72
9 Output 90
10 Output 110*/

fun main(args: Array<String>) {
    lambda()
    pureFunctionEx()
    highOrderFunctionEx()
    inlineEx()
}

//익명 함수 (람다 표현식)
private fun lambda() {
    val sum = { x: Int, y: Int -> x + y } //1
    println("Sum ${sum(10, 20)}") //2
    val anonymousMult = { x: Int -> (Random().nextInt(15) + 1) * x } //3
    println("random output ${anonymousMult(3)}") //4
}

//순수 함수 Ex
private fun pureFunctionEx() {
    println("named pure func square = ${square(4)}")
    //람다
    val qube = { n: Int -> n * n * n }
    println("lambda pure func qube = ${qube(4)}")
}

//순수 함수
private fun square(n: Int): Int {
    return n * n
}

//고차 함수 Ex
private fun highOrderFunctionEx() {
    highOrderFunc(10) { a: Int -> a % 2 == 0 }
    highOrderFunc(17) { a: Int -> a % 2 == 0 }
}

//고차 함수
private fun highOrderFunc(a: Int, validityCheckFunc: (a: Int) -> Boolean) {
    if (validityCheckFunc(a)) println("a $a is Valid")
    else println("a $a is Invalid")
}

//인라인 함수
fun inlineEx(){
    for(i in 1..10){
        println("$i Output ${doSomeStuff(i)}")
    }
}

inline  fun doSomeStuff(a:Int = 0) = a+(a*a)