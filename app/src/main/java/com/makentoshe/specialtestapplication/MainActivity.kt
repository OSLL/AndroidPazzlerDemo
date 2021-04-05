package com.makentoshe.specialtestapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.PrintStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        System.setOut(object : PrintStream(System.out) {
            override fun println(s: String?) = sample_text.append(s)
        })

        println("")
        try {
            doSomething { { -> }.fun Function<*>.() {}().also { it.hash() } }
        } catch (e: Exception) {
            e.apply { doSomething { System.out.println(this) } }
        } catch (e: IllegalStateException) {
            e.apply { doSomething { System.out.println(e.message!!) } }
        }
        println("")

        sample_text.append(sample_text.tag.toString())

        val anExtremelyLongAndBoringStatementThatBarelyFitsOnALine = getIndex(true)
        val anotherExtremelyLongStatementThatBarelyFitsOnALine = getIndex(false)
        val someList = listOf(1)
        val result = someList.map {
            anExtremelyLongAndBoringStatementThatBarelyFitsOnALine
            + anotherExtremelyLongStatementThatBarelyFitsOnALine
        }

        sample_text.text = sample_text.text.filterIndexed { index, _ -> index % result[0] == 0 }.subSequence(0,4)

    }

    private fun doSomething(block: String.() -> Unit) {
        val builder = AnswerBuilder(this)
        builder.hash = AnswerBuilder2(getString(R.string.answer)).build()
        builder.hash!!.block()
        block(String(stringFromJNI()))
    }

    private fun stringFromJNI() = byteArrayOf()

    private fun getIndex(bool : Boolean) = when (bool) {
        bool == true -> 2
        bool == false -> 1
        else -> 0
    }
}

fun Unit.hash(): Nothing = throw throw return throw IllegalStateException("baf3e0e2db034cdc6cfe30114bceb39f")

fun Any.hash(): Nothing = throw throw throw Exception("12b48362932528b84e72ff1408fe3805")
