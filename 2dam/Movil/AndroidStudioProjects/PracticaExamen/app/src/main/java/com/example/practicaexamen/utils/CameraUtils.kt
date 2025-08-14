package com.example.practicaexamen.utils

/**
 * @author Rodrigo
 * @date 20 febrero, 2025
 */

import android.Manifest
import android.content.ContentResolver
import android.content.ContentValues
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class CameraUtils(private val context: Context, private val contentResolver: ContentResolver) {

    private var photoUri: Uri? = null

    private fun generateImageFileName(): String{
        val timestamp= SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        return "IMG_$timestamp.jpg"
    }

    fun createImageUri(): Uri?{
        val fileName=generateImageFileName()
        val contentValues= ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, "fichero.jpeg")
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
            put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/")
        }
        return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,contentValues)
    }

    fun takePicture(takePictureLauncher: ActivityResultLauncher<Uri>){
        val uri= createImageUri()
        photoUri = uri
        uri?.let { takePictureLauncher.launch(it) }
    }

    fun getPhotoUri(): Uri?
    {
        return photoUri
    }
    fun hasCameraPermission(context: Context): List<String> {
        val permissionsToRequest = mutableListOf<String>()

        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED) {
            permissionsToRequest.add(Manifest.permission.CAMERA)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.READ_MEDIA_IMAGES
                ) != PackageManager.PERMISSION_GRANTED) {
                permissionsToRequest.add(Manifest.permission.READ_MEDIA_IMAGES)
            }

            if (ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.READ_MEDIA_VIDEO
                ) != PackageManager.PERMISSION_GRANTED) {
                permissionsToRequest.add(Manifest.permission.READ_MEDIA_VIDEO)
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            if (ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED
                ) != PackageManager.PERMISSION_GRANTED) {
                permissionsToRequest.add(Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED)
            }

            //NI SE OS OCURRE PONER EL READ EXTERNAL STORAGE
        }
        return permissionsToRequest
    }
}