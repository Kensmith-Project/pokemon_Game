package com.example.secondimplementation.Module

data class Payload(
    val downloadUri: String,
    val fileId: String,
    val fileName: String,
    val fileType: String,
    val uploadStatus: Boolean
)
