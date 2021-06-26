package cz.bald.sget.mobile.ui.setup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cz.bald.sget.mobile.R
import cz.bald.sget.mobile.model.enum.CzechSubject
import cz.bald.sget.mobile.model.enum.Language
import cz.bald.sget.mobile.model.enum.SlovakSubject
import cz.bald.sget.mobile.model.TestSetting
import cz.bald.sget.mobile.ui.listener.FragmentChangeListener
import kotlinx.android.synthetic.main.fragment_setup_language.view.*

class LanguageFragment(private val testSetting: TestSetting) : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    retainInstance = true
    val view = inflater.inflate(R.layout.fragment_setup_language, container, false)

    view.language_selection_text_view.text = testSetting.type.name

    view.slovak_button.setOnClickListener {
      val fcl = activity as FragmentChangeListener
      testSetting.language = Language.SLOVAK
      testSetting.subject = SlovakSubject.SLOVAK
      fcl.swapFragment(SubjectFragment(testSetting), true)
    }

    view.czech_button.setOnClickListener {
      val fcl = activity as FragmentChangeListener
      testSetting.language = Language.CZECH
      testSetting.subject = CzechSubject.CZECH
      fcl.swapFragment(SubjectFragment(testSetting), true)
    }

    return view
  }
}
