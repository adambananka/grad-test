package cz.bald.sget.mobile.ui.setup

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import cz.bald.sget.mobile.MainActivity
import cz.bald.sget.mobile.R
import cz.bald.sget.mobile.ui.listener.FragmentChangeListener
import cz.bald.sget.mobile.ui.listener.SetupListener

class SetupActivity : AppCompatActivity(), FragmentChangeListener,
  SetupListener {

  companion object {
    const val ARG_SETUP = "arg_setup"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_setup)

    val fragment = StartFragment("maturita")
    supportFragmentManager.beginTransaction()
      .replace(R.id.fragment_container, fragment)
      .commit()
  }

  override fun swapFragment(newFragment: Fragment) {
    supportFragmentManager.beginTransaction()
      .replace(R.id.fragment_container, newFragment)
      .addToBackStack(newFragment.toString())
      .commit()
  }

  override fun finishSetup(setting: String) {
    val intent = Intent(this, MainActivity::class.java)
    intent.putExtra(ARG_SETUP, setting)
    startActivity(intent)
  }
}
