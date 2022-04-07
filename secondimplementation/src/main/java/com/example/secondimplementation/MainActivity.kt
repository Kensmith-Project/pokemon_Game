package com.example.secondimplementation

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.secondimplementation.Module.ImageUploadResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val My_PERMISSION_REQUEST = 100
    private val PICK_IMAGE_FROM_GALLERY_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestPermission()



        if (ContextCompat.checkSelfPermission(
                this@MainActivity,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this@MainActivity,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                My_PERMISSION_REQUEST
            )
            val uploadImg = findViewById<ImageView>(R.id.iv_img_to_upload) as ImageView

        }
        val btnUpload = findViewById<Button>(R.id.iv_Upload_btn)
        btnUpload.setOnClickListener {
            pickImageGallery()
        }

//        uploadImg.setOnClickListener {
//            val intent = Intent()
//            intent.type = "image/*"
//            intent.action = Intent.ACTION_GET_CONTENT
//            startActivityForResult(
//                Intent.createChooser(intent, "Select Picture"),
//                PICK_IMAGE_FROM_GALLERY_REQUEST
//            )
//        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == PICK_IMAGE_FROM_GALLERY_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {
//            val uri = data.data
//            Log.d("AAAA", "Wel done")
//            println("successfully done")
//            println(uri)
//            // log -
//
//            // how to set uri to image view  ------
//
//            // image view
//
//
//            // inside a button
//
////            {
////               uploadFile(uri)
////            }
//        }
        val uploadImg = findViewById<ImageView>(R.id.iv_img_to_upload) as ImageView
        if(requestCode==PICK_IMAGE_FROM_GALLERY_REQUEST && resultCode== RESULT_OK){
          uploadImg.setImageURI(data?.data)
        }

    }

    fun onRequestPermission(requestCode: Int, permission: Array<String?>?, grantResults: IntArray) {
        when (requestCode) {
            My_PERMISSION_REQUEST -> {
                if (grantResults.size > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) {
                } else {
                }
                return
            }
        }
    }
    private fun pickImageGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type= "image/*"
        startActivityForResult(intent,PICK_IMAGE_FROM_GALLERY_REQUEST)
    }

    private fun uploadFile(fileUri: Uri?) {
//        val name = findViewById<View>(R.id.iv_editText) as EditText
//        val description = RequestBody.create(MultipartBody.FORM, name.text.toString())
//        val originalFile: File = FileUtils.getFile(this, fileUri)
//        val filePart = RequestBody.create(
//            MediaType.parse(contentResolver.getType(fileUri!!)),
//            originalFile
//        )
//        val file = MultipartBody.Part.createFormData("photo", originalFile.name, filePart)


        var retrofit = RetrofitInstance.getRetrofit()

        retrofit?.uploadPhoto("")?.

        enqueue(object : Callback<ImageUploadResponse?> {
            override fun onResponse(
                call: Call<ImageUploadResponse?>,
                response: Response<ImageUploadResponse?>
            ) {
                if (response.isSuccessful){

                }
            }

            override fun onFailure(call: Call<ImageUploadResponse?>, t: Throwable) {

            }

        })
    }

    private fun requestPermission() {
        var permissionToRequest = mutableListOf<String>()

        if (permissionToRequest.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissionToRequest.toTypedArray(), 0)
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_CONTACTS)
        ) {
            AlertDialog.Builder(this, )
                .setTitle("Request User Permission")
                .setMessage("Permission needed for this or that")
                .setPositiveButton("Ok") { _, _ ->
                    //do something
                }
                .setNegativeButton("Cancel") { _, _ ->
                }.show()
        }

        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)== PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"you have already granted permission!", Toast.LENGTH_SHORT ).show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0 && grantResults.isNotEmpty()) {
            for (i in grantResults.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("PermissionRequest", "${permissions[i]} granted.")
                    Toast.makeText(this, "PERMISSION GRANTED", Toast.LENGTH_SHORT).show()

                } else{
                    Toast.makeText(this, "PERMISSSION DENIED", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}