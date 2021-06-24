package cz.bald.sget.mobile.ui.listener

import androidx.fragment.app.Fragment

interface FragmentChangeListener {

  fun swapFragment(newFragment: Fragment, stack: Boolean)
}
