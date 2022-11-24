package com.example.mycoincalendar

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate
import kotlin.collections.ArrayList

class CustomCalendarAdapter(
    private var dateList: ArrayList<String>,
    private var selectedDate: LocalDate?,
    private var mainActivity: MainActivity,
    private var dayList: ArrayList<ListData>
)
    : RecyclerView.Adapter<CustomCalendarAdapter.Holder>() {

    private val TAG: String = "CustomCalendarAdapter"
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_calendar_item, parent, false)
        context = parent.context
        return Holder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: Holder, position: Int) {


            val dataDay = dayList[position]
            Log.d(TAG, "onBindViewHolder: dataDay : $dataDay")
            holder.dayOfWeekText.text = dataDay.stringValue

        val dataDate = dateList[position]
        Log.d(TAG, "onBindViewHolder: dataDate : $dataDate")

        //       val currentDate = date1.substring(8,10)
        //        if(dataDate == currentDate){
        //            Log.d(TAG, "onBindViewHolder: if Condition currentDate $currentDate : $dataDate")
        //            holder.dateText.text = dataDate
        //            context?.let { it1 -> holder.dateText.setTextColor(it1.getColor(R.color.white)) }
        //            holder.dateText.setBackgroundResource(R.drawable.circle_solid)
        //        }else {
            holder.dateText.text = dataDate
        // }

        holder.dateText.setOnClickListener {

           // mainActivity.onItemClick(position,holder.dateText.text.toString())

            context?.let { it1 -> holder.dateText.setTextColor(it1.getColor(R.color.purple_200)) }
            holder.dateText.setBackgroundResource(androidx.appcompat.R.drawable.abc_btn_radio_material)


            val firstOfMonth: LocalDate = selectedDate!!.withDayOfMonth(holder.dateText.text.toString().toInt())
            Log.d(TAG, "daysInMonthArray: firstOfMonth $firstOfMonth")

            val dayOfWeek = firstOfMonth.dayOfWeek.value
            val weekDay = firstOfMonth.dayOfWeek
            Toast.makeText(context, "$dayOfWeek ::: $weekDay", Toast.LENGTH_SHORT).show()


        }
    }

    override fun getItemCount(): Int {
      return  dateList.size
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val dayOfWeekText: TextView = view.findViewById(R.id.dayOfWeekMon)
        val dateText: TextView = view.findViewById(R.id.dateText)
    }
}
