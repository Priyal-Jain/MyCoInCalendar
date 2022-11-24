package com.example.mycoincalendar

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView


class FreelancerTimeSlotsAdapter(
    var fromTimeSlots: ArrayList<String>,
    var fromTimeMeridiemSlots: ArrayList<String>,
    var toTimeSlots: ArrayList<String>,
    var toTimeMeridiemSlots: ArrayList<String>,
    private var selectTimeSlotListener: SelectTimeSlotListener
) : RecyclerView.Adapter<FreelancerTimeSlotsAdapter.Holder>() {
    private val TAG: String = "FreelancerTimeSlotsAdapter"
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_time_slot, parent, false)
        context = parent.context
        return Holder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {

        Log.e("FTimeSlotAdapter","Priyal fromTimeSlots : $fromTimeSlots ")

        try {

        holder.startTimePM.text = fromTimeSlots[position]
        Log.e("FTimeSlotAdapter","Priyal startTimePM : ${holder.startTimePM.text} ")
        holder.txtPM.text = fromTimeMeridiemSlots[position]
        holder.endTimePM.text = toTimeSlots[position]
        holder.txtPM2.text = toTimeMeridiemSlots[position]
        }catch (e: java.lang.Exception){}
        holder.itemView.setOnClickListener {
//            holder.const_layout3.setBackgroundResource(R.drawable.color_accent_background)
            val startTime = holder.startTimePM.text.toString() + holder.txtPM.text.toString()
            val endTime = holder.endTimePM.text.toString() + holder.txtPM2.text.toString()
            //val startTime = fromTimeSlots[holder.absoluteAdapterPosition]+fromTimeMeridiemSlots[holder.absoluteAdapterPosition]
            //val endTime = toTimeSlots[holder.absoluteAdapterPosition]+toTimeMeridiemSlots[holder.absoluteAdapterPosition]
            selectTimeSlotListener.onSelectTimeSlot(holder.adapterPosition,startTime,endTime)
            Log.e("FTimeSlotAdapter","Priyal startTime : $startTime  &&& endTime $endTime")
        }

    }

    override fun getItemCount(): Int {
        Log.d(TAG,"${fromTimeSlots.size}")
        return fromTimeSlots.size
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val const_layout3: ConstraintLayout = view.findViewById(R.id.const_layout3)
        val startTimePM: AppCompatTextView = view.findViewById(R.id.startTimePM)
        val txtPM: AppCompatTextView = view.findViewById(R.id.txtPM)
        val endTimePM: AppCompatTextView = view.findViewById(R.id.endTimePM)
        val txtPM2: AppCompatTextView = view.findViewById(R.id.txtPM2)
    }

    interface SelectTimeSlotListener {
        fun onSelectTimeSlot(position: Int, startTime: String?, endTime: String?)
    }

}