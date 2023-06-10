package com.example.sarirahmawati_androidexercises

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.sarirahmawati_androidexercises.databinding.FragmentContactBinding
import com.example.sarirahmawati_androidexercises.fragment.ContactFragment
import com.example.sarirahmawati_androidexercises.fragment.ProfileFragment
import com.example.sarirahmawati_androidexercises.fragment.ProjectsFragment
import com.example.sarirahmawati_androidexercises.fragment.SkillsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: FragmentContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profileFragment = ProfileFragment()
        val skillsFragment = SkillsFragment()
        val projectsFragment = ProjectsFragment()
        val contactFragment = ContactFragment()

        makeCurrentFragment(profileFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_profile -> makeCurrentFragment(profileFragment)
                R.id.navigation_skills -> makeCurrentFragment(skillsFragment)
                R.id.navigation_projects -> makeCurrentFragment(projectsFragment)
                R.id.navigation_contact -> makeCurrentFragment(contactFragment)

            }
            true
        }

    }




    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment_activity_main, fragment)
            commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.tbClose -> {
                finishActivity(0)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}