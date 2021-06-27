package cz.bald.sget.mobile.ui.setup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cz.bald.sget.mobile.R
import cz.bald.sget.mobile.model.TestSetting
import cz.bald.sget.mobile.ui.listener.FragmentChangeListener
import kotlinx.android.synthetic.main.fragment_setup_start.view.*

class StartFragment(private val testSetting: TestSetting) : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    retainInstance = true
    val view = inflater.inflate(R.layout.fragment_setup_start, container, false)

    view.setup_start_test_value.text = testSetting.type.name
    view.setup_start_start_button.setOnClickListener {
      val fcl = activity as FragmentChangeListener
      fcl.swapFragment(LanguageFragment(testSetting), true)
    }

    return view
  }
}
