package com.thindie.database.implementation

import com.thindie.database.CodersDao
import com.thindie.database.LocalSourceAdapter
import com.thindie.database.LocalSourceModel
import com.thindie.database.entities.CoderDbModel
import javax.inject.Inject

internal class LocalSourceAdapterImpl @Inject constructor(private val dao: CodersDao) :
    LocalSourceAdapter {
    override suspend fun <R> getCodersModelList(mapper: (LocalSourceModel) -> R): Result<List<R>> {
        return kotlin.runCatching {
            dao.getCoders()
                .map(mapper)
        }
    }

    override suspend fun <R> getCoderById(id: String, mapper: (LocalSourceModel) -> R): Result<R> {
        return kotlin.runCatching {
            mapper(dao.getCoder(id))
        }
    }

    override suspend fun storeCoders(list: List<LocalSourceModel>) {
        dao.upsertCoders(list.map {
            CoderDbModel(
                avatarUrl = it.getModelAvatarLink(),
                birthday = it.getModelBirthday(),
                department = it.getModelDepartment(),
                firstName = it.getModelFirstName(),
                id = it.getModelId(),
                lastName = it.getModelLastName(),
                phone = it.getModelPhone(),
                position = it.getModelPosition(),
                userTag = it.getModelUserTag()

            )
        })
    }
}