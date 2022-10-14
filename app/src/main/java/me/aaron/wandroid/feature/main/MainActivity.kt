package me.aaron.wandroid.feature.main


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.aaron.wandroid.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
    }
}