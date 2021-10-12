package com.shashi.ledboard

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class DisplayAdapter(private val mList : List<LedStateModel>) : RecyclerView.Adapter<DisplayAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_led, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = mList[position]

        when(model.led_1) {
            "0" -> holder.led1.setCardBackgroundColor(Color.BLACK)
            "1" -> holder.led1.setCardBackgroundColor(Color.RED)
        }

        when(model.led_2) {
            "0" -> holder.led2.setCardBackgroundColor(Color.BLACK)
            "1" -> holder.led2.setCardBackgroundColor(Color.RED)
        }

        when(model.led_3) {
            "0" -> holder.led3.setCardBackgroundColor(Color.BLACK)
            "1" -> holder.led3.setCardBackgroundColor(Color.RED)
        }

        when(model.led_4) {
            "0" -> holder.led4.setCardBackgroundColor(Color.BLACK)
            "1" -> holder.led4.setCardBackgroundColor(Color.RED)
        }

        when(model.led_5) {
            "0" -> holder.led5.setCardBackgroundColor(Color.BLACK)
            "1" -> holder.led5.setCardBackgroundColor(Color.RED)
        }

        when(model.led_6) {
            "0" -> holder.led6.setCardBackgroundColor(Color.BLACK)
            "1" -> holder.led6.setCardBackgroundColor(Color.RED)
        }

        when(model.led_7) {
            "0" -> holder.led7.setCardBackgroundColor(Color.BLACK)
            "1" -> holder.led7.setCardBackgroundColor(Color.RED)
        }

        when(model.led_8) {
            "0" -> holder.led8.setCardBackgroundColor(Color.BLACK)
            "1" -> holder.led8.setCardBackgroundColor(Color.RED)
        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val led1 : CardView = itemView.findViewById(R.id.cv_led_1)
        val led2 : CardView = itemView.findViewById(R.id.cv_led_2)
        val led3 : CardView = itemView.findViewById(R.id.cv_led_3)
        val led4 : CardView = itemView.findViewById(R.id.cv_led_4)
        val led5 : CardView = itemView.findViewById(R.id.cv_led_5)
        val led6 : CardView = itemView.findViewById(R.id.cv_led_6)
        val led7 : CardView = itemView.findViewById(R.id.cv_led_7)
        val led8 : CardView = itemView.findViewById(R.id.cv_led_8)
    }
}