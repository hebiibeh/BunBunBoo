package com.example.bunbunboo.logic

import android.hardware.Sensor
import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import com.example.bunbunboo.dto.SensorValueDto
import com.example.bunbunboo.dto.WaveformDto
import kotlin.math.ceil
import kotlin.math.sin

class GenerateSoundLogic {

    /*
    * decleare
    */
    private var audioTrack: AudioTrack? = null
    private val sampleRate = 44100
    private val bufferSize = 44100
    private var flag = true

    /*
    * public function
    */
    fun generateSoundBySensor(sensorType: Int,sensorValue: SensorValueDto) {

        if(flag) {
            initAudioTrack(sampleRate, bufferSize)
            flag = false
        }
        val waveform = calculateWaveform(sensorType,sensorValue)
        val soundByteArray = generateSound(waveform);
        playAudio(soundByteArray)
    }

    fun getAudioTrack(): AudioTrack? {
        return this.audioTrack
    }

    /*
    * private function
    */
    private fun initAudioTrack(sampleRate: Int, bufferSize: Int) {

        // AudioTrackを作成
        audioTrack = AudioTrack(AudioManager.STREAM_MUSIC, 	// 音楽ストリームを設定
        sampleRate,	// サンプルレート
        AudioFormat.CHANNEL_OUT_MONO,	// モノラル
        AudioFormat.ENCODING_DEFAULT, 	// オーディオデータフォーマットPCM16とかPCM8とか
        bufferSize,	// バッファ・サイズ
        AudioTrack.MODE_STREAM); // Streamモード。データを書きながら再生する
    }

    private fun calculateWaveform(sensorType: Int,sensorValue: SensorValueDto): WaveformDto {
        var frequency = 0.0
        var soundLength = 0.0

        if(sensorType == Sensor.TYPE_GYROSCOPE){
            // covert Gyro to Waveform
            frequency = (sensorValue.gyroX+sensorValue.gyroY+sensorValue.gyroZ)*100
            soundLength = 0.05
        }
        return WaveformDto(frequency,soundLength)
    }

    private fun generateSound(waveformDto: WaveformDto):ByteArray {

        val frequency = waveformDto.frequency
        val soundLength = waveformDto.soundLength

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