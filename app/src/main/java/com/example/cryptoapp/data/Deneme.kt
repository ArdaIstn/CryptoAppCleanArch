package com.example.cryptoapp.data

fun main() {

    val hayvan: Aslan = Hayvan() // Hayvan nesnesi Aslan referansı ile
    println(hayvan.kukre())



}



interface Aslan {
    fun kukre(): String
}

class Hayvan : Aslan {
    override fun kukre(): String {
        return "Aslan kükredi"
    }
}