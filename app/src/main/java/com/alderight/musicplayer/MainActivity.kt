package com.alderight.musicplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lets create a new Media Player object
        // but before that lets create a raw folder
        val mediaplayer = MediaPlayer.create(this, R.raw.music)
        val play_btn = findViewById<ImageButton>(R.id.play_btn)
        val seekbar = findViewById<SeekBar>(R.id.seekbar)

        seekbar.progress = 0
        seekbar.max = mediaplayer.duration

        play_btn.setOnClickListener {
            if(!mediaplayer.isPlaying){
                mediaplayer.start()
                // and we will change the button's image
                play_btn.setImageResource(R.drawable.ic_baseline_pause_24)
            }else{
                // the media player is playing and we can pause it
                mediaplayer.pause()
                play_btn.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            }
        }
        // Now we will add the seekbar
        // When we change our seek bar progress the will change the position
        seekbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, pos: Int, changed: Boolean) {
                // now when we change the position of the seekbard the music will go tjhat position
                if(changed){
                    mediaplayer.seekTo(pos)
                }
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }
        })
    }
}