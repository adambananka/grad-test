package cz.bald.sget.mobile.ui.setup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cz.bald.sget.mobile.R
import cz.bald.sget.mobile.model.enums.CzechSubject
import cz.bald.sget.mobile.model.enums.Language
import cz.bald.sget.mobile.model.enums.SlovakSubject
import cz.bald.sget.mobile.model.TestSetting
import cz.bald.sget.mobile.model.enums.Subject
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

    view.setup_language_selection_value.text = testSetting.type.name
    view.setup_language_slovak_button.setOnClickListener {
      saveAndContinue(Language.SLOVAK, SlovakSubject.SLOVAK)
    }

    view.setup_language_czech_button.setOnClickListener {
      saveAndContinue(Language.CZECH, CzechSubject.CZECH)
    }

    return view
  }

  private fun saveAndContinue(lang: Language, subject: Subject) {
    val fcl = activity as FragmentChangeListener
    testSetting.language = lang
    testSetting.subject = subject
    fcl.swapFragment(SubjectFragment(testSetting), true)
  }
}
