package com.example.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Resep(
var name: String,
var description: String,
var calOfAmount: String,
var price: String,
var category: String,
var photo: String,
var ingredients: List<String>,
var steps: List<String>
) : Parcelable
