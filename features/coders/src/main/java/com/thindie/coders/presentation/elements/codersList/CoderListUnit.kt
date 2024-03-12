package com.thindie.coders.presentation.elements.codersList

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import coil.compose.rememberAsyncImagePainter
import com.thindie.design_system.KodeTraineeDrawable
import com.thindie.design_system.elements.KodeTraineeGenericImageComponentRow
import com.thindie.design_system.elements.KodeTraineeGenericTextContentRow
import com.thindie.design_system.painter
import com.thindie.model.coders.CoderModel

@Composable
internal fun CoderListUnit(coderModel: CoderModel) {
    val coderAvatar = CoderAsyncAvatarOrStub(coderModel = coderModel)
    KodeTraineeGenericImageComponentRow(painter = coderAvatar) {
        KodeTraineeGenericTextContentRow(
            text = coderModel.getFullName(),
            baseElementTextStyle = MaterialTheme.typography.titleSmall,
            slaveText = coderModel.userTag,
            slaveElementTextStyle = MaterialTheme.typography.labelSmall
        )
    }
}

@Composable
private fun CoderAsyncAvatarOrStub(modifier: Modifier = Modifier, coderModel: CoderModel): Painter {

    val stubGoose = KodeTraineeDrawable.Stub.stubGoose.painter()

    val painter = rememberAsyncImagePainter(model = coderModel.avatarUrl, placeholder = stubGoose)

    return remember { painter }
}