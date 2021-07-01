package cz.bald.sget.mobile.model

data class Test(
    val setting: TestSetting,
    val sections: List<Section>,
    val questionsCount: Int,
    val maxPoints: Int,
    val timeAvailable: Int,
    var result: Result?
)
