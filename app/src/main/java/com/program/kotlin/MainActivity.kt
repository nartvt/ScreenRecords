package com.program.kotlin

import android.hardware.display.VirtualDisplay
import android.media.MediaRecorder
import android.media.projection.MediaProjection
import android.media.projection.MediaProjection.Callback
import android.media.projection.MediaProjectionManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var screenDensity:Int = 0
    private var projectionManager:MediaProjectionManager?=null
    private var mediaProjection:MediaProjection?=null
    private var virtualDisplay:VirtualDisplay?=null
    private var mediaProjectionCallback:MediaProjectionCallback?=null

    private var mediaRecorder:MediaRecorder?=null

    internal  var videoUri:String=""


    class MediaProjectionCallback: Callback(){
        override fun onStop() {
            super.onStop()

            if (toggleButton.isChecked){

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}