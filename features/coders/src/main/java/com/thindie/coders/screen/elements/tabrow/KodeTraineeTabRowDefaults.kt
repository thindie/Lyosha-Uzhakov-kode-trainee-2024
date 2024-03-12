package com.thindie.coders.screen.elements.tabrow

import com.thindie.design_system.KodeTraineeStrings
import com.thindie.model.Department

internal object KodeTraineeTabRowDefaults {

    val tabRowUnitsList by lazy {
        Department.values()
            .map { department ->
                TabRowUnit(
                    tabRowTitle = department.getDepartmentStringRes(),
                    department = department
                )
            }
    }


    private fun Department.getDepartmentStringRes() =
        when (this) {
            Department.ANDROID -> KodeTraineeStrings.ScrollableTabRow.android
            Department.IOS -> KodeTraineeStrings.ScrollableTabRow.ios
            Department.DESIGN -> KodeTraineeStrings.ScrollableTabRow.design
            Department.MANAGEMENT -> KodeTraineeStrings.ScrollableTabRow.management
            Department.QA -> KodeTraineeStrings.ScrollableTabRow.qa
            Department.BACK_OFFICE -> KodeTraineeStrings.ScrollableTabRow.back_office
            Department.FRONTEND -> KodeTraineeStrings.ScrollableTabRow.frontend
            Department.HR -> KodeTraineeStrings.ScrollableTabRow.hr
            Department.PR -> KodeTraineeStrings.ScrollableTabRow.pr
            Department.BACKEND -> KodeTraineeStrings.ScrollableTabRow.backend
            Department.SUPPORT -> KodeTraineeStrings.ScrollableTabRow.support
            Department.ANALYTICS -> KodeTraineeStrings.ScrollableTabRow.analytics
            Department.UNSPECIFIED -> KodeTraineeStrings.ScrollableTabRow.all
        }
}