package com.example.bunbunboo.activity

import android.app.Activity
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.AudioTrack
import android.os.Bundle
import com.example.bunbunboo.R
import com.example.bunbunboo.dto.SensorValueDto
import com.example.bunbunboo.logic.GenerateSoundLogic


class MainActivity : Activity(), SensorEventListener {
    /*
    * decleare
    */
    private var mSensorManager: SensorManager? = null
    private val generateSoundLogic =
        GenerateSoundLogic()

    /*
    * activity function
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get SensorManager instance
        mSensorManager = this.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        // process every sensorType
        when (event!!.sensor.type) {
            // gyro sensor
            Sensor.TYPE_GYROSCOPE -> {
                val sensorValue = getSensorValue(event);
                generateSoundLogic.generateSoundBySensor(Sensor.TYPE_GYROSCOPE, sensorValue);
            }
        }
    }

    override fun onResume() {
        super.onResume()
        // 照度センサーを指定してオブジェクトリストを取得する
        val sensors =
            mSensorManager!!.getSensorList(Sensor.TYPE_GYROSCOPE)
        val s = sensors!![0]
        mSensorManager!!.registerListener(this, s, SensorManager.SENSOR_DELAY_UI)
    }



    /*
    * private function
    */
    private fun getSensorValue(event: SensorEvent?): SensorValueDto {

        val sensorValue = SensorValueDto(0.0, 0.0, 0.0)
        // process every sensorType
        when (event!!.sensor.type) {
            Sensor.TYPE_GYROSCOPE -> {
                sensorValue.gyroX = event.values[0].toDouble()
                sensorValue.gyroY = event.values[1].toDouble()
                sensorValue.gyroZ = event.values[2].toDouble()
            }
        }
        return sensorValue
    }
}