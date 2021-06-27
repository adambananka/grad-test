package cz.bald.sget.mobile.ui.setup

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import cz.bald.sget.mobile.R
import cz.bald.sget.mobile.model.TestSetting
import cz.bald.sget.mobile.model.enum.CzechSubject
import cz.bald.sget.mobile.model.enum.Language
import cz.bald.sget.mobile.model.enum.TestType
import cz.bald.sget.mobile.ui.listener.FragmentChangeListener
import cz.bald.sget.mobile.ui.listener.SetupListener
import cz.bald.sget.mobile.ui.test.TestActivity

class SetupActivity : AppCompatActivity(), FragmentChangeListener,
  SetupListener {

  companion object {
    const val ARG_SETUP = "arg_setup"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_setup)

    val setting = TestSetting(TestType.MATURITA, Language.SLOVAK, CzechSubject.CZECH, 0)
    val fragment = StartFragment(setting)
    swapFragment(fragment, false)
  }

  override fun swapFragment(newFragment: Fragment, stack: Boolean) {
    supportFragmentManager.beginTransaction()
      .replace(R.id.setup_fragment_container, newFragment)
      .addToBackStack(newFragment.toString())
      .commit()
  }

  override fun finishSetup(setting: TestSetting) {
    val intent = Intent(this, TestActivity::class.java)
    intent.putExtra(ARG_SETUP, setting)
    startActivity(intent)
  }
}
