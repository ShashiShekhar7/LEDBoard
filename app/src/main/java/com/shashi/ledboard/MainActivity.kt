package com.shashi.ledboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.rv_led_display)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<LedStateModel>()

        for (i in 1..8) {
            val model = LedStateModel("0", "0", "0", "0", "0", "0",
                "0", "0")
            data.add(model)
        }

        val adapter = DisplayAdapter(data)

        recyclerView.adapter = adapter

        val button : Button = findViewById(R.id.btn_next)

        var index = 0

        button.setOnClickListener{
            val model = LedStateModel("1", "1", "1", "1", "1", "1",
                "1", "1")

            update(recyclerView, data, model, index)

            if (index == 7)
                index = 0
            else
                index++
        }

    }

    fun update(recyclerView: RecyclerView, data : ArrayList<LedStateModel>, item: LedStateModel, index: Int) {

        val modelReset = LedStateModel("0", "0", "0", "0", "0", "0",
            "0", "0")

        val previousIndex : Int = if (index == 0) {
            data.size - 1
        } else {
            index - 1
        }

        Log.d(TAG, "update: previousIndex : $previousIndex")
        Log.d(TAG, "update: index : $index")
        Log.d(TAG, "update: list size : ${data.size}")

        data[previousIndex] = modelReset
        data[index] = item
        Log.d(TAG, "update: list size : ${data.size}")
        recyclerView.adapter?.notifyItemChanged(previousIndex)
        recyclerView.adapter?.notifyItemChanged(index)

    }
}