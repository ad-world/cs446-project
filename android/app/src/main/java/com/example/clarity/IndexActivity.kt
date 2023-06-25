package com.example.clarity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.clarity.databinding.IndexActivityBinding
import com.example.clarity.sets.SetsFragment

// Just created a blank file for the main content

// When the login button is pressed, it should redirect to this file
// The profile, sets, community, and classroom fragments,
// and the logic to switch between them would also rest in this file

class IndexActivity : AppCompatActivity() {

    private lateinit var binding : IndexActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: If no one else implements this, we need to get the userId after login/signup
        //  For now we use a hard coded value (0) for testing
        val intent = intent
        val userId: Int = intent.getIntExtra("userId", 0)

        binding = IndexActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(ProfileFragment())

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.profile -> replaceFragment(ProfileFragment())
                R.id.sets -> replaceFragment(SetsFragment.newInstance(userId))
                R.id.community -> replaceFragment(CommunityFragment())
                R.id.classroom -> replaceFragment(ClassroomFragment())
                else -> {}
            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}
