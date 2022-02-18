package com.appcrafters.gamenews.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.appcrafters.gamenews.R
import com.appcrafters.gamenews.gamedetails.view.GameDetailsFragment
import com.appcrafters.gamenews.gamelist.view.GameListFragment

class MainActivity : AppCompatActivity(), ICoordinator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        showFragment(GameListFragment(), true)
    }

    private fun showFragment(fragment: Fragment, addAsRoot: Boolean = false) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        if (!addAsRoot) transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun showDetailsFragment(gameId: Int) {
        showFragment(GameDetailsFragment.newInstance(gameId))
    }

}