package com.example.native_toast

import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.widget.Toast


class MainActivity: FlutterActivity() {
    private val CHANNEL = "samples.flutter/makeToast"

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler {
                call, result ->
            // Note: this method is invoked on the main thread.
            // TODO
            if(call.method == "makeToast" && call.argument<Boolean>("text") != null) {
                makeToast(call.argument<String>("text").toString())
            } else makeToast("text is empty")
        }
    }

    private fun makeToast(text: String) {
        Toast.makeText(context, "$text", Toast.LENGTH_SHORT).show()
    }
}
