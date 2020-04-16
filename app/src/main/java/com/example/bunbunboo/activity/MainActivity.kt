package com.example.bunbunboo.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.Button
import com.example.bunbunboo.R
import com.example.bunbunboo.dto.SensorValueDto
import com.example.bunbunboo.logic.GenerateSoundLogic


class MainActivity : Activity(), SensorEventListener {
    /*
    * decleare
    */
    private var mSensorManager: SensorManager? = null
    private val generateSoundLogic = GenerateSoundLogic()
    private var useSensorArray = arrayOf(Sensor.TYPE_GYROSCOPE,Sensor.TYPE_LIGHT,Sensor.TYPE_ROTATION_VECTOR)

    /*
    * activity function
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get SensorManager instance
        mSensorManager = this.getSystemService(Context.SENSOR_SERVICE) as SensorManager

        // button event
        val btnIntent = findViewById<Button>(R.id.button)
        btnIntent.setOnClickListener {
            val intent = Intent(this@MainActivity, Main2Activity::class.java)
            startActivity(intent)
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        // prosess by only useSensorArray
        if (useSensorArray.contains(event!!.sensor.type)) {
            val sensorValue = getSensorValue(event);
            generateSoundLogic.generateSoundBySensor(event!!.sensor.type, sensorValue);
        }
    }

    override fun onResume() {
        super.onResume()

        // registerListner by useSensorArray
        for(i in useSensorArray) {
            val sensors =
                mSensorManager!!.getSensorList(i)
            val s = sensors!![0]
            mSensorManager!!.registerListener(this, s, SensorManager.SENSOR_DELAY_FASTEST)
        }
    }

    /*
    * private function
    */
    private fun getSensorValue(event: SensorEvent?): DoubleArray {

        var sensorValues = DoubleArray(event!!.values.size)

        for (i in event!!.values.indices) {
            sensorValues[i] = event.values[i].toDouble()
        }

        return sensorValues
    }
}