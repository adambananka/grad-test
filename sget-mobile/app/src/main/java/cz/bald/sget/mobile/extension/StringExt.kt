package cz.bald.sget.mobile.extension

import cz.bald.sget.mobile.model.TestSetting
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.toPrintable(): String {
    val dateFormat = SimpleDateFormat("dd.MM.yyyy hh:mm", Locale.getDefault())
    return dateFormat.format(this)
}

fun TestSetting.toPrintable(): String {
    return this.type.name + " / " + this.language + " / " + this.subject + " / " + this.year
}
