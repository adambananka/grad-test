package cz.bald.sget.mobile.ui.setup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import cz.bald.sget.mobile.R
import cz.bald.sget.mobile.model.TestSetting
import cz.bald.sget.mobile.ui.listener.FragmentChangeListener
import kotlinx.android.synthetic.main.fragment_setup_subject.view.*

class SubjectFragment(private val testSetting: TestSetting) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        retainInstance = true
        val view = inflater.inflate(R.layout.fragment_setup_subject, container, false)

        view.setup_subject_subject_list.adapter = ArrayAdapter<String>(
            this.requireContext(),
            android.R.layout.simple_list_item_1, testSetting.language.getSubjects()
        )
        view.setup_subject_subject_list.setOnItemClickListener { adapterView, _, i, _ ->
            val fcl = activity as FragmentChangeListener
            testSetting.subject = testSetting.subject.of(adapterView.getItemAtPosition(i) as String)
            fcl.swapFragment(YearFragment(testSetting), true)
        }

        return view
    }
}
