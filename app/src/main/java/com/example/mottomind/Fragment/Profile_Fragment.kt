package com.example.soulscript.Fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.mottomind.databinding.FragmentProfileBinding
import com.example.soulscript.App

class Profile_Fragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        val mode = AppCompatDelegate.getDefaultNightMode()

        binding.switchmode.isChecked = (mode == AppCompatDelegate.MODE_NIGHT_YES)

        binding.switchmode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Dark mode
                App.changeTheme(isChecked)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                // Light mode
                App.changeTheme(isChecked)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        return binding.root
    }


}

