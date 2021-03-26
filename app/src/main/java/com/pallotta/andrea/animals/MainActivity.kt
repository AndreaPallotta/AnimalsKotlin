package com.pallotta.andrea.animals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import com.pallotta.andrea.animals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var listFragment: LettersListFragment? = null
    private var detailsFragment: WelcomeFragment? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)

        // change title
        val actionBar = supportActionBar
        actionBar!!.title = "Alphabet with Animals!"

        loadFragment("List")
        loadFragment("Details")

    }

    // for menus
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_info -> InfoDialog().show(supportFragmentManager, "Info")
            R.id.menu_about -> AboutDialog().show(supportFragmentManager, "About")
        }
        return super.onOptionsItemSelected(item)
    }

    private fun loadFragment(which: String, isEmpty: Boolean? = true) {
        if (which == "List") {
            listFragment = LettersListFragment()
            listFragment?.setCustomItemChangedListener(itemChangedListener)
            supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            supportFragmentManager.beginTransaction()
                    .replace(R.id.list, listFragment!!)
                    .commit()
        } else if (which == "Details") {
            if (isEmpty == false) {
                detailsFragment = WelcomeFragment()
                supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                supportFragmentManager.beginTransaction()
                        .replace(R.id.theInfo, listFragment!!)
                        .commit()
            } else {

            }

        }
    }


    // listener for when they interact with the ListFragment
    private var itemChangedListener: LettersListFragment.ItemChangedListener =
            object: LettersListFragment.ItemChangedListener {

                override fun onSelectedItemChanged(itemNameString: String) {
                    val details = WelcomeFragment.newInstance(itemNameString)
                    supportFragmentManager.beginTransaction()
                            .setCustomAnimations(R.animator.fade_in, R.animator.fade_out)
                            .replace(R.id.list, details)
                            .addToBackStack(null)
                            .commit()
                }
            }
}