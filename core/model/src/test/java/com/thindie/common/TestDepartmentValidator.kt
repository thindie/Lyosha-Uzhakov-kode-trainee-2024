package com.thindie.common

import com.thindie.model.CoderDepartmentValidator
import com.thindie.model.Department
import com.thindie.model.coders.CoderModel
import com.thindie.model.coders.findCoderByNameAndTag
import org.junit.Test
import kotlin.jvm.Throws

class TestDepartmentValidator() {
    @Test
    fun testDepartmentProvider() {
        assert(CoderDepartmentValidator.getOrThrow("ios") == Department.IOS)
        assert(CoderDepartmentValidator.getOrThrow(" ios") == Department.IOS)
        assert(CoderDepartmentValidator.getOrThrow(" IOS") == Department.IOS)
        assert(CoderDepartmentValidator.getOrThrow(" BACK_OFfice ") == Department.BACK_OFFICE)
    }

    @Test
    @Throws(IllegalArgumentException::class)
    fun faildedRequirement(){
        assert(CoderDepartmentValidator.getOrThrow("") == Department.IOS)
    }


}
