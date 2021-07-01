package cz.bald.sget.mobile.model

import android.os.Parcelable
import cz.bald.sget.mobile.model.enums.Language
import cz.bald.sget.mobile.model.enums.Subject
import cz.bald.sget.mobile.model.enums.TestType
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TestSetting(
    var type: TestType,
    var language: Language,
    var subject: Subject,
    var year: Int
) : Parcelable
