package com.program.kotlin

import android.content.Context
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.media.projection.MediaProjectionManager
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.Manifest
import android.app.Activity
import android.view.View
import android.widget.Chronometer
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
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
        val toggleButton=findViewById(R.id.tbSwitch)

        val displayMetrics = DisplayMetrics()
        screenDensity = displayMetrics.densityDpi
        mediaRecorder = MediaRecorder()
        mediaProjectionManager = getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager

        toggleButton.setOnClickListener(
            setupPermissions(toggleButton)
        )
    }

    private fun setupPermissions(toggleButton: ToggleButton) {
        val permissionWriteStorage = ContextCompat.checkSelfPermission(this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE)

        val permission = ContextCompat.checkSelfPermission(this,
            Manifest.permission.RECORD_AUDIO)
        if (permissionWriteStorage != PackageManager.PERMISSION_GRANTED ||  permission != PackageManager.PERMISSION_GRANTED){
            Log.i("Permission denine","Permission to record denied")
            ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
            ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.RECORD_AUDIO)
            toggleButton.isChecked = false
            Snackbar.make(findViewById(R.id.content),R.string.permission_text,Snackbar.LENGTH_INDEFINITE).setAction("ENABLE",View.OnClickListener {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.RECORD_AUDIO
                    ), // TODO
            // )
            })
        }
    }
}