package com.program.kotlin

import android.content.Context
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.media.projection.MediaProjectionManager
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.Manifest
import android.view.View
import android.widget.Chronometer
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private var toggleButton:ToggleButton?=null
    private var chronometer:Chronometer?=null
    private var readText:TextView?=null

    private var screenDensity:Int?=0
    private var mediaRecorder:MediaRecorder?=null
    private var mediaProjectionManager:MediaProjectionManager?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chronometer=findViewById(R.id.cmTimer)
        readText=findViewById(R.id.tvRecord)
        toggleButton=findViewById(R.id.tbSwitch)

        val displayMetrics = DisplayMetrics()
        screenDensity = displayMetrics.densityDpi
        mediaRecorder = MediaRecorder()
        mediaProjectionManager = getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager

        toggleButton.setOnClickListener(View.OnClickListener {
            setupPermissions()
        })
    }

    private fun setupPermissions() {
        val permissionWriteStorage = ContextCompat.checkSelfPermission(this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE)

        val permission = ContextCompat.checkSelfPermission(this,
            Manifest.permission.RECORD_AUDIO)
        if (permissionWriteStorage == PackageManager.PERMISSION_GRANTED && permission == PackageManager.PERMISSION_GRANTED){

        }

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i("Permission denine","Permission to record denied")
        }
    }
}