package com.example.mycoincalendar

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.YearMonth
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(),
    FreelancerTimeSlotsAdapter.SelectTimeSlotListener {

    var TAG: String = "MainActivity"
    private var customCalendarRecyclerView: RecyclerView? = null
    var timeSlotsRecyclerView: RecyclerView? = null
    private lateinit var timer: RelativeLayout
    
    private val dayList = ArrayList<ListData>()
    var daysInMonth: ArrayList<String> = ArrayList()
    private var selectedDate: LocalDate? = null

    //TimeSlot
    var customVendorServiceAvailability = java.util.ArrayList<VendorServiceAvailability>()
    private lateinit var slots: VendorServiceAvailability

    private var fromTimeMonSlots = java.util.ArrayList<String>()
    private var fromTimeMeridiemMonSlots = java.util.ArrayList<String>()
    private var toTimeMonSlots = java.util.ArrayList<String>()
    private var toTimeMeridiemMonSlots = java.util.ArrayList<String>()

    private var fromTimeTueSlots = java.util.ArrayList<String>()
    private var fromTimeMeridiemTueSlots = java.util.ArrayList<String>()
    private var toTimeTueSlots = java.util.ArrayList<String>()
    private var toTimeMeridiemTueSlots = java.util.ArrayList<String>()

    private var fromTimeWedSlots = java.util.ArrayList<String>()
    private var fromTimeMeridiemWedSlots = java.util.ArrayList<String>()
    private var toTimeWedSlots = java.util.ArrayList<String>()
    private var toTimeMeridiemWedSlots = java.util.ArrayList<String>()

    private var fromTimeThuSlots = java.util.ArrayList<String>()
    private var fromTimeMeridiemThuSlots = java.util.ArrayList<String>()
    private var toTimeThuSlots = java.util.ArrayList<String>()
    private var toTimeMeridiemThuSlots = java.util.ArrayList<String>()

    private var fromTimeFriSlots = java.util.ArrayList<String>()
    private var fromTimeMeridiemFriSlots = java.util.ArrayList<String>()
    private var toTimeFriSlots = java.util.ArrayList<String>()
    private var toTimeMeridiemFriSlots = java.util.ArrayList<String>()

    private var fromTimeSatSlots = java.util.ArrayList<String>()
    private var fromTimeMeridiemSatSlots = java.util.ArrayList<String>()
    private var toTimeSatSlots = java.util.ArrayList<String>()
    private var toTimeMeridiemSatSlots = java.util.ArrayList<String>()

    private var fromTimeSunSlots = java.util.ArrayList<String>()
    private var fromTimeMeridiemSunSlots = java.util.ArrayList<String>()
    private var toTimeSunSlots = java.util.ArrayList<String>()
    private var toTimeMeridiemSunSlots = java.util.ArrayList<String>()


    @SuppressLint("SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customCalendarRecyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView
        customCalendarRecyclerView!!.setHasFixedSize(true)

        dayListAddData()

        selectedDate = LocalDate.now()
        daysInMonth = daysInMonthArray(selectedDate)
        Log.d(TAG, "onCreate: daysInMonth $daysInMonth")

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        customCalendarRecyclerView!!.layoutManager = layoutManager
        customCalendarRecyclerView!!.adapter = CustomCalendarAdapter(daysInMonth,selectedDate,this@MainActivity,dayList)

        ////////////////////////FreelancerTimeSlotAdapter////////////////////////////////////////////////

        timeSlotsRecyclerView = findViewById(R.id.timeSlotsRecyclerView)
        timeSlotsRecyclerView!!.layoutManager = layoutManager
        timeSlotsRecyclerView!!.setHasFixedSize(true)
        timer = findViewById(R.id.timer)
    }

    private fun clearArrays() {

        if (customVendorServiceAvailability.isNotEmpty()) {
            customVendorServiceAvailability.clear()
        }
        if (fromTimeMonSlots.isNotEmpty()) {
            fromTimeMonSlots.clear()
        }
        if (fromTimeMeridiemMonSlots.isNotEmpty()) {
            fromTimeMeridiemMonSlots.clear()
        }
        if (toTimeMonSlots.isNotEmpty()) {
            toTimeMonSlots.clear()
        }
        if (toTimeMeridiemMonSlots.isNotEmpty()) {
            toTimeMeridiemMonSlots.clear()
        }
    }

    private fun dayListAddData() {
        dayList.add(ListData("Mo"))
        dayList.add(ListData("Tu"))
        dayList.add(ListData("We"))
        dayList.add(ListData("Th"))
        dayList.add(ListData("Fr"))
        dayList.add(ListData("Sa"))
        dayList.add(ListData("Su"))
        dayList.add(ListData("Mo"))
        dayList.add(ListData("Tu"))
        dayList.add(ListData("We"))
        dayList.add(ListData("Th"))
        dayList.add(ListData("Fr"))
        dayList.add(ListData("Sa"))
        dayList.add(ListData("Su"))
        dayList.add(ListData("Mo"))
        dayList.add(ListData("Tu"))
        dayList.add(ListData("We"))
        dayList.add(ListData("Th"))
        dayList.add(ListData("Fr"))
        dayList.add(ListData("Sa"))
        dayList.add(ListData("Su"))
        dayList.add(ListData("Mo"))
        dayList.add(ListData("Tu"))
        dayList.add(ListData("We"))
        dayList.add(ListData("Th"))
        dayList.add(ListData("Fr"))
        dayList.add(ListData("Sa"))
        dayList.add(ListData("Su"))
        dayList.add(ListData("Mo"))
        dayList.add(ListData("Tu"))
        dayList.add(ListData("We"))
        dayList.add(ListData("Th"))
        dayList.add(ListData("Fr"))
        dayList.add(ListData("Sa"))
        dayList.add(ListData("Su"))
        dayList.add(ListData("Mo"))
        dayList.add(ListData("Tu"))
        dayList.add(ListData("We"))
        dayList.add(ListData("Th"))
        dayList.add(ListData("Fr"))
        dayList.add(ListData("Sa"))
        dayList.add(ListData("Su"))

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun daysInMonthArray(localDate: LocalDate?): ArrayList<String> {
        Log.d(TAG, "daysInMonthArray: date $localDate")

        val daysInMonthArray = ArrayList<String>()
        val yearMonth = YearMonth.from(localDate)
        Log.d(TAG, "daysInMonthArray: yearMonth $yearMonth")

        val daysInMonth = yearMonth.lengthOfMonth()
        Log.d(TAG, "daysInMonthArray: daysInMonth $daysInMonth")

        val firstOfMonth: LocalDate = selectedDate!!.withDayOfMonth(14)
        Log.d(TAG, "daysInMonthArray: firstOfMonth $firstOfMonth")

        val dayOfWeek = firstOfMonth.dayOfWeek.value
        val weekDay = firstOfMonth.dayOfWeek
        Log.d(TAG, "daysInMonthArray: dayOfWeek $dayOfWeek &&& weekDay : $weekDay")

        for (i in 1..42) {
            if ((i <= dayOfWeek)||(i > (daysInMonth + dayOfWeek))) {
                Log.d(TAG, "daysInMonthArray: for If Condition dayOfWeek $dayOfWeek &&& i : $i")
                daysInMonthArray.add("")
            } else {
                Log.d(TAG, "daysInMonthArray: for else Condition dayOfWeek $dayOfWeek")
                daysInMonthArray.add((i - dayOfWeek).toString())
            }
        }
        Log.d(TAG, "daysInMonthArray: daysInMonthArray $daysInMonthArray")
        return daysInMonthArray
    }

    override fun onSelectTimeSlot(position: Int, startTime: String?, endTime: String?) {
        TODO("Not yet implemented")
    }
}