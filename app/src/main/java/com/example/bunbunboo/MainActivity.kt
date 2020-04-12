package com.example.bunbunboo

import android.app.Activity
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.AudioTrack
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : Activity(),SensorEventListener {

    // Sound生成クラス
    private val soundGenerator = DigitalSoundGenerator(44100,44100)
    // Sound再生クラス
    private var audioTrack: AudioTrack? = soundGenerator.audioTrack
    // 譜面データ
    private val soundList: MutableList<SoundDto> = ArrayList()

    private var playState = 0

    private var mSensorManager: SensorManager? = null

    @RequiresApi(Build.VERSION_CODES.M)

    /**
     * 譜面データを作成
     */
    private fun initScoreData() { // 譜面データ作成
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    WHOLE_NOTE
                ), WHOLE_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateEmptySound(
                    soundGenerator,
                    EIGHTH_NOTE
                ), EIGHTH_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    WHOLE_NOTE
                ), WHOLE_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateEmptySound(
                    soundGenerator,
                    EIGHTH_NOTE
                ), EIGHTH_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_G,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_C,
                    WHOLE_NOTE
                ), WHOLE_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_D,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    WHOLE_NOTE
                ), WHOLE_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateEmptySound(
                    soundGenerator,
                    FORTH_NOTE
                ), FORTH_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_F,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_F,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_F,
                    WHOLE_NOTE
                ), WHOLE_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateEmptySound(
                    soundGenerator,
                    FORTH_NOTE
                ), FORTH_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_F,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    WHOLE_NOTE
                ), WHOLE_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_D,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_D,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_D,
                    WHOLE_NOTE
                ), WHOLE_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_G,
                    WHOLE_NOTE
                ), WHOLE_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateEmptySound(soundGenerator, HALF_NOTE),
                HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    WHOLE_NOTE
                ), WHOLE_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateEmptySound(
                    soundGenerator,
                    EIGHTH_NOTE
                ), EIGHTH_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    WHOLE_NOTE
                ), WHOLE_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateEmptySound(
                    soundGenerator,
                    EIGHTH_NOTE
                ), EIGHTH_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_G,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_C,
                    WHOLE_NOTE
                ), WHOLE_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_D,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, 3.0),
            3.0
        ))
        soundList.add(
            SoundDto(
                generateEmptySound(
                    soundGenerator,
                    FORTH_NOTE
                ), FORTH_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_F,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_F,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_F,
                    WHOLE_NOTE
                ), WHOLE_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateEmptySound(
                    soundGenerator,
                    EIGHTH_NOTE
                ), EIGHTH_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_F,
                    EIGHTH_NOTE
                ), EIGHTH_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_F,
                    EIGHTH_NOTE
                ), EIGHTH_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_E,
                    WHOLE_NOTE
                ), WHOLE_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_G,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_G,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_F,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_D,
                    HALF_NOTE
                ), HALF_NOTE
            )
        )
        soundList.add(
            SoundDto(
                generateSound(
                    soundGenerator,
                    DigitalSoundGenerator.FREQ_C,
                    WHOLE_NOTE
                ), WHOLE_NOTE
            )
        )
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // SensorManagerのインスタンスを取得する
        mSensorManager = this.getSystemService(Context.SENSOR_SERVICE) as SensorManager

        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener{

            textView.text ="aaaaaaaaa"
            if(playState==0) {
                playState = 1
                this.createAudio()
            }
            else{
                    playState=0
            }
        }
        // スコアデータを作成
        initScoreData()
    }

    /**
     * ８ビットのピコピコ音を生成する.
     * @param gen Generator
     * @param freq 周波数(音階)
     * @param length 音の長さ
     * @return 音データ
     */
    private fun generateSound(
        gen: DigitalSoundGenerator,
        freq: Double,
        length: Double
    ): ByteArray {
        return gen.getSound(freq, length)
    }

    /**
     * 無音データを作成する
     * @param gen Generator
     * @param length 無音データの長さ
     * @return 無音データ
     */
    private fun generateEmptySound(gen: DigitalSoundGenerator?, length: Double): ByteArray {
        return gen!!.getEmptySound(length)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun createAudio() { // 再生中なら一旦止める
//        if (audioTrack!!.playState == AudioTrack.PLAYSTATE_PLAYING) {
//            audioTrack!!.stop()
//            audioTrack!!.reloadStaticData()
//        }
        // 再生開始
        // スコアデータを書き込む
            // ジャイロセンサーにより変化する音を作成する
            //
                audioTrack!!.write(soundList[0].sound, 0, soundList[0].sound.size)
                audioTrack!!.play()

        audioTrack!!.play()
        // 再生停止
        //audioTrack!!.stop()
    }

    companion object {
        const val EIGHTH_NOTE = 0.125
        const val FORTH_NOTE = 0.25
        const val HALF_NOTE = 0.5
        const val WHOLE_NOTE = 0.1
    }

    override fun onResume() {
        super.onResume()
        // 照度センサーを指定してオブジェクトリストを取得する
        val sensors =
            mSensorManager!!.getSensorList(Sensor.TYPE_GYROSCOPE)
        val s = sensors!![0]
        mSensorManager!!.registerListener(this, s, SensorManager.SENSOR_DELAY_UI)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onSensorChanged(event: SensorEvent?) {
        when (event!!.sensor.type) {
            Sensor.TYPE_GYROSCOPE -> {
                // 現在の明るさを取得
                val value = event.values[0].toString()
                textView.text = value
                this.createAudio()
            }
        }}

}
