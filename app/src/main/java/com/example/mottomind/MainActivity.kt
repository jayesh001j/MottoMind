package com.example.mottomind

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.mottomind.databinding.ActivityMainBinding
import com.example.soulscript.Fragment.Home_Fragment
import com.example.soulscript.Fragment.LikeAdd_Fragment
import com.example.soulscript.Fragment.Profile_Fragment
lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    loadFragment(Home_Fragment())
                    true
                }

                R.id.AddCategory -> {
                    loadFragment(LikeAdd_Fragment())
                    true
                }

                R.id.Profile -> {
                    loadFragment(Profile_Fragment())
                    true
                }

                else -> false
            }
        }

        loadFragment(Home_Fragment())
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, fragment)
            .commit()
    }

}


