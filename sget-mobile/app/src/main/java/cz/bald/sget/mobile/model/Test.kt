package cz.bald.sget.mobile.model

data class Test(
  val setting: TestSetting,
  val sections: List<Section>,
  val questionsCount: Int,
  val maxPoints: Int,
  var result: Result
)
