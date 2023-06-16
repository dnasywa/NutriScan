package com.example.nutriscan.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.TextView
import com.example.nutriscan.R

class MainActivity : AppCompatActivity() {
    private val PICK_FILE_REQUEST = 1
    private lateinit var btnChooseFile: Button
    private lateinit var tvFilePath: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnChooseFile = findViewById(R.id.btnSelectFile)
        tvFilePath = findViewById(R.id.tvFilePath)

        btnChooseFile.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "*/*"  // Allow all file types
            startActivityForResult(intent, PICK_FILE_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_FILE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val selectedFileUri: Uri? = data.data
            val selectedFilePath: String? = selectedFileUri?.let { getPathFromUri(it) }
            tvFilePath.text = selectedFilePath
            // Call your file upload method here using the selectedFilePath
        }
    }

    private fun getPathFromUri(uri: Uri): String? {
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(uri, projection, null, null, null)
        cursor?.use {
            val columnIndex = it.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            if (it.moveToFirst()) {
                return it.getString(columnIndex)
            }
        }
        return null
    }


}