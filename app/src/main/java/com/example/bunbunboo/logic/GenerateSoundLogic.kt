package com.example.bunbunboo.logic

import android.hardware.Sensor
import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import com.example.bunbunboo.dto.SensorValueDto
import com.example.bunbunboo.dto.SoundValueDto
import kotlin.math.ceil
import kotlin.math.sin

class GenerateSoundLogic {

    /*
    * decleare
    */
    private val sampleRate = 44100
    private val bufferSize = 44100
    private val audioTrack: AudioTrack = AudioTrack(AudioManager.STREAM_MUSIC, 	// 音楽ストリームを設定
        sampleRate,	// サンプルレート
        AudioFormat.CHANNEL_OUT_MONO,	// モノラル
        AudioFormat.ENCODING_DEFAULT, 	// オーディオデータフォーマットPCM16とかPCM8とか
        bufferSize,	// バッファ・サイズ
        AudioTrack.MODE_STREAM);


    /*
    * public function
    */
    fun generateSound(soundValue: SoundValueDto) {
        val soundByteArray = generateSoundBuffer(soundValue);
        playAudio(soundByteArray)
    }

    fun generateSoundBySensor(sensorType: Int,sensorValues: DoubleArray) {
        val soundValueDto = convertSensorValueToSound(sensorType,sensorValues)
        val soundByteArray = generateSoundBuffer(soundValueDto);
        playAudio(soundByteArray)
    }

    /*
    * private function
    */
    private fun convertSensorValueToSound(sensorType: Int, sensorValue: DoubleArray): SoundValueDto {
        var frequency = 0.0
        var soundLength = 0.0

        if(sensorType == Sensor.TYPE_GYROSCOPE){
            // covert Gyro to Waveform
            frequency = (sensorValue[0]+sensorValue[1]+sensorValue[2])*100
            soundLength = 0.05
        }
        if(sensorType == Sensor.TYPE_LIGHT){
            // covert Light to Waveform
            frequency = (sensorValue[0])*1000
            soundLength = 0.05
        }
        if(sensorType == Sensor.TYPE_ROTATION_VECTOR){
            // covert Light to Waveform
            frequency = (sensorValue[0]+sensorValue[1]+sensorValue[2]+sensorValue[3]+sensorValue[4])*50
            soundLength = 0.05
        }

        return SoundValueDto(frequency,soundLength)
    }

    private fun generateSoundBuffer(soundValueDto: SoundValueDto):ByteArray {
        val frequency = soundValueDto.frequency
        val soundLength = soundValueDto.soundLength
        val buffer =
            ByteArray(ceil(bufferSize * soundLength).toInt())

        for(i in buffer.indices step 1) {
            var wave = i / (this.sampleRate / frequency) * (Math.PI * 2);
            wave = sin(wave);
            buffer[i] = if (wave > 0.0) Byte.MAX_VALUE else Byte.MIN_VALUE;
        }
        return buffer;
    }

    private fun playAudio(soundByteArray: ByteArray) {
        audioTrack!!.write(soundByteArray, 0,soundByteArray.size)
        audioTrack!!.play()
        audioTrack!!.stop()
    }
}