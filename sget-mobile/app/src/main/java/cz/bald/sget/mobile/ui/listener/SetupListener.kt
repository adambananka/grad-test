package cz.bald.sget.mobile.ui.listener

import cz.bald.sget.mobile.model.TestSetting

interface SetupListener {

    fun finishSetup(setting: TestSetting)
}
