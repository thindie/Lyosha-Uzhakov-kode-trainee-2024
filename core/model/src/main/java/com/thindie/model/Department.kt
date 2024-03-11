package com.thindie.model

import kotlin.jvm.Throws

enum class Department {
    ANDROID,
    IOS,
    DESIGN,
    MANAGEMENT,
    QA,
    BACK_OFFICE,
    FRONTEND,
    HR,
    PR,
    BACKEND,
    SUPPORT,
    ANALYTICS,
}

private val departmentsList = listOf(
    "android",
    "ios",
    "design",
    "management",
    "qa",
    "back_office",
    "frontend",
    "hr",
    "pr",
    "backend",
    "support",
    "analytics"
)

object CoderDepartmentValidator {
    @Throws(IllegalArgumentException::class)
    fun getOrThrow(candidate: String): Department {
        val adjustedCandidate = candidate.lowercase().trim()
        require(departmentsList.contains(adjustedCandidate))
        return Department.values().first {
            adjustedCandidate  == it.name.lowercase()
        }
    }
}