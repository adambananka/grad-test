package cz.bald.sget.mobile.ui.test

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import cz.bald.sget.mobile.R
import cz.bald.sget.mobile.ui.listener.FragmentChangeListener
import cz.bald.sget.mobile.ui.setup.SetupActivity

class TestActivity : AppCompatActivity(), FragmentChangeListener {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_test)

    val setting = intent.getStringExtra(SetupActivity.ARG_SETUP)
    Toast.makeText(this, setting, setting.length).show()

    val fragment = QuestionFragment(listOf(1, 2, 2, 3, 2, 1, 2, 3, 2), 0, Int.MIN_VALUE,
      Int.MIN_VALUE)
    swapFragment(fragment, true)
  }

  override fun swapFragment(newFragment: Fragment, stack: Boolean) {
    val transaction = supportFragmentManager.beginTransaction()
      .replace(R.id.fragment_container, newFragment)

    if (stack) {
      transaction.addToBackStack(newFragment.toString())
    }
    transaction.commit()
  }
}
