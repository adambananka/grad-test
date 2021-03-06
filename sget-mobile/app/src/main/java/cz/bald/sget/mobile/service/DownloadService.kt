package cz.bald.sget.mobile.service

import android.Manifest
import android.app.Activity
import android.app.DownloadManager
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Environment
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import cz.bald.sget.mobile.model.*
import cz.bald.sget.mobile.model.enums.QuestionType
import java.io.File

class DownloadService {

    fun downloadFile(activity: Activity, testSetting: TestSetting): Long {
        val downloadUrl =
            "https://drive.google.com/uc?export=download&id=1cS7wYBtSRUJ92MXq0VMGxY0-R-dKvCo5"
        val r = DownloadManager.Request(Uri.parse(downloadUrl))
        r.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, MATURITA_2019)
        r.allowScanningByMediaScanner()
        r.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        val dm = activity.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        return dm.enqueue(r)
    }

    fun requestStoragePermission(activity: Activity): Boolean {
        return if (checkPermission(
                activity,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) && checkPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        ) {
            true
        } else {
            ActivityCompat.requestPermissions(
                activity,
                arrayOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ),
                REQUEST_STORAGE_PERMISSION
            )
            false
        }
    }

    fun fileAlreadyExists(): Boolean {
        return File(
            Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS
            ), MATURITA_2019
        )
            .exists()
    }

    fun createTest(): Test {
        return JsonConvertManager.convertJsonToTest(
            File(
                Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOWNLOADS
                ), MATURITA_2019
            )
                .readText()
        )
    }

    fun defaultTemplateTest(testSetting: TestSetting): Test {
        val q1 = Question(
            1, 1, QuestionType.TEST, "Autor uk????ky sa v nej zameriava",
            listOf(
                "(A) na vlastn?? hodnotenie pr??nosu Mar??ny pre slovensk?? literat??ru.",
                "(B) na ??tylistick?? anal??zu jazykov??ch kval??t b??snick??ho diela Mar??na.",
                "(C) na zhrnutie n??zorov Sl??dkovi??ov??ch s????asn??kov na dielo Mar??na.",
                "(D) na kritiku subjekt??vneho poh??adu liter??rnych recenzentov Mar??ny."
            ),
            "1", ""
        )
        val q2 = q1.copy(number = 2)
        val q3 = Question(
            3, 1, QuestionType.OPEN,
            "Nap????te n??zov diela J??na Koll??ra, na ktor?? sa odvol??val J. Lomen????k v ??vode uk????ky" +
                    " a ktor??ho n??zov patr?? na zakryt?? miesto v nej?",
            emptyList(), "to najlepsie", ""
        )
        val q4 = q1.copy(number = 4)
        val s1 = Section(
            1,
            "Po vyjden?? Mar??ny tla??ou v auguste 1846 sa ??tuduj??ca ml??de?? ver??ami o l??ske, kr??se " +
                    "a mladosti nadch??nala. V my??lienkovej i citovej oblasti jej vlastne nahradila Koll??rovu " +
                    ". Teraz u?? nemusela srdce rozpol??ova??, preto??e n??rodnobudite??sk?? poslanie " +
                    "mohla prejavova?? aj cez vn??torn?? poryvy du??e. Potvrdzuje to i odpor????anie z pera dobov??ho " +
                    "kritika Mikul????a Dohn??nyho v Orle tatranskom 1847: ???Tu sa v??m svety otvoria, po ktor??ch ste " +
                    "d??vno t????ili, a n??jdete sa v nich ako vo svojich vlastn??ch.??? Vo vynikaj??cej recenzii vyzdvihol " +
                    "Sl??dkovi??ovo ???vyst??penie z ko??e??? biblickej ??e??tiny, ????m polo??il slovensk??m slovom pevn?? " +
                    "z??klady slovenskej po??zie: ???Po??te sa prizrie?? kr??se re??i na??ej, vy posmieva??i, ke?? ona v kr??se " +
                    "spieva a k ch??rom anjelov bo????ch sa pribli??uje, a srdce va??e mus?? k nej zahorie?? l??skou. Uk??zal " +
                    "on, k akej dokonalosti sloven??ina na??a pr??s?? m????e!??? Z prv??ho kriticky nastaven??ho zrkadla " +
                    "pre obrazotvornos??ou h??riacu po??ziu Mar??ny jasne vidie??, ??e Dohn??ny si zobral na ???mu??ku??? " +
                    "hlavne estetick?? kvality. Oce??uj??c t??to str??nku vid?? v tomto peknom kvete z??kladn?? ??? ... v??tvor " +
                    "naj??istej??ej po??zie veku bud??ceho???.\n" +
                    "Do kritick??ho zrkadlenia prispel vo ???svojich??? Slovensk??ch poh??adoch (1847) i Jozef " +
                    "Miloslav Hurban, ktor?? b??se?? ne????tal ??abl??novito, zd??raz??uj??c hlavne slobodu tvorenia naozaj " +
                    "origin??lneho v??razu. Z??verom recenzie optimisticky Sl??dkovi??a vyprev??dza na cestu liter??rnym " +
                    "??ivotom slovami: ???My mu cestu jeho, tak pekne nast??piv??iemu v??etku sl??vu a v??etok prospech " +
                    "prajeme s t????bou n??dejnou ??al??ie jeho pr??ce o??ak??vaj??c.???",
            4, 4, listOf(q1, q2, q3, q4)
        )
        val q5 = q1.copy(number = 5)
        val q6 = q3.copy(number = 6)
        val q7 = q1.copy(number = 7)
        val s2 = s1.copy(
            number = 2, questionCount = 3, maxPoints = 3,
            questions = listOf(q5, q6, q7)
        )

        return Test(testSetting, listOf(s1, s2), 7, 7, 100, null)
    }

    private fun checkPermission(activity: Activity, permission: String): Boolean {
        return ContextCompat.checkSelfPermission(
            activity,
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    companion object {
        const val MATURITA_2019 = "MATURITA_SJL_2019.json"
    }
}
