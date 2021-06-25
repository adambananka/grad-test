package cz.bald.sget.mobile.model.enum

interface Subject {

  fun getAllSubjects(): Array<String>

  fun getSubjectName(): String

  fun getYearsOfSubject(): Array<Int>
}
