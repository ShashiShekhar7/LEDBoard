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
        var start = false

        button.setOnClickListener{
            Thread(Runnable {
                start = !start

                while (start) {

                    var model = LedStateModel("1", "1", "1", "1", "1", "1", "1", "1")

                    when(index) {
                        0 -> model = LedStateModel("1", "1", "1", "1", "1", "1",
                            "1", "1")
                        1 -> model = LedStateModel("1", "0", "0", "0", "0", "0",
                            "0", "1")
                        2 -> model = LedStateModel("1", "0", "0", "0", "0", "0",
                            "0", "1")
                        3 -> model = LedStateModel("1", "0", "0", "0", "0", "0",
                            "0", "1")
                        4 -> model = LedStateModel("1", "1", "1", "1", "1", "1",
                            "1", "1")
                        5 -> model = LedStateModel("1", "0", "0", "0", "0", "0",
                            "0", "1")
                        6 -> model = LedStateModel("1", "0", "0", "0", "0", "0",
                            "0", "1")
                        7 -> model = LedStateModel("1", "0", "0", "0", "0", "0",
                            "0", "1")
                    }

                    runOnUiThread{ update(recyclerView, data, model, index) }
                    Thread.sleep(20)

                    if (index == 7)
                        index = 0
                    else
                        index++

                }
            }).start()
        }
    }

    private fun update(recyclerView: RecyclerView, data : ArrayList<LedStateModel>, item: LedStateModel, index: Int) {

        val modelReset = LedStateModel("0", "0", "0", "0", "0", "0",
            "0", "0")

        val previousIndex : Int = if (index == 0) {
            data.size - 1
        } else {
            index - 1
        }

        data[previousIndex] = modelReset
        data[index] = item

//        Log.d(TAG, "update: previousIndex $previousIndex")
//        Log.d(TAG, "update: index $index")

//        recyclerView.adapter?.notifyDataSetChanged()

        recyclerView.adapter?.notifyItemChanged(previousIndex)
        recyclerView.adapter?.notifyItemChanged(index)

    }
}