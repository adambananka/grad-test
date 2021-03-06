package cz.bald.sget.mobile.ui.setup

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import cz.bald.sget.mobile.R
import cz.bald.sget.mobile.model.TestSetting
import cz.bald.sget.mobile.model.enums.CzechSubject
import cz.bald.sget.mobile.model.enums.Language
import cz.bald.sget.mobile.model.enums.TestType
import cz.bald.sget.mobile.ui.listener.FragmentChangeListener
import cz.bald.sget.mobile.ui.listener.SetupListener
import cz.bald.sget.mobile.ui.result.ResultActivity
import cz.bald.sget.mobile.ui.test.TestActivity

class SetupActivity : AppCompatActivity(), FragmentChangeListener, SetupListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup)

        setupNavDrawer()
        if (savedInstanceState == null) {
            val setting = TestSetting(TestType.MATURITA, Language.SLOVAK, CzechSubject.CZECH, 0)
            val fragment = StartFragment(setting)
            swapFragment(fragment, false)
        }
    }

    override fun swapFragment(newFragment: Fragment, stack: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()
            .replace(R.id.setup_fragment_container, newFragment)
        if (stack) {
            transaction.addToBackStack(newFragment.toString())
        }
        transaction.commit()
    }

    override fun finishSetup(setting: TestSetting) {
        val intent = Intent(this, TestActivity::class.java)
        intent.putExtra(ARG_SETUP, setting)
        startActivity(intent)
    }

    private fun setupNavDrawer() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.setup_drawer_layout)
        val navView = findViewById<NavigationView>(R.id.setup_nav_view)

        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.nav_menu_open,
            R.string.nav_menu_close
        )
        drawerLayout.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        navView.menu.findItem(R.id.nav_menu_maturita).setOnMenuItemClickListener {
            startActivity(Intent(this, SetupActivity::class.java))
            drawerLayout.closeDrawer(GravityCompat.START)
            finish()
            true
        }
        navView.menu.findItem(R.id.nav_menu_results).setOnMenuItemClickListener {
            startActivity(Intent(this, ResultActivity::class.java))
            drawerLayout.closeDrawer(GravityCompat.START)
            finish()
            true
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    companion object {
        const val ARG_SETUP = "arg_setup"
    }
}
