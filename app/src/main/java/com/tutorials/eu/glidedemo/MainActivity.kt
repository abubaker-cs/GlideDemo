package com.tutorials.eu.glidedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.tutorials.eu.glidedemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // A Random image from google to load it using Glide.
    private val image = "https://cdn.pixabay.com/photo/2018/05/03/21/49/android-3372580_960_720.png"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Load the image to the ImageView with simple options.
        Glide.with(this)
            .load(image) // A new request builder for loading a Drawable using the given model.
            .into(binding.imageOne) // Sets the ImageView the resource will be loaded into

        // Load the image to the ImageView with some more params.
        Glide.with(this)
            .load(image)
            .fitCenter()
            .circleCrop() // Applies CircleCrop to all default types and throws an exception if asked to transform an unknown type.
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.drawable.img_placeholder)
            .into(binding.imageTwo)

        // Load the image to the ImageView with custom size defined at runtime.
        Glide.with(this)
            // To check the error you can change the link by adding some char
            .load("https://cdn.pixabay.com/photo/2018/05/03/21/49/android-3372580_960_720.png")
            .override(300, 400)
            .centerCrop() // scale to fill the ImageView and crop any extra
            .error(R.drawable.img_placeholder)
            .into(binding.imageThree)
    }
}