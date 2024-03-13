package com.thindie.coders.presentation.elements.codersList

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import coil.compose.rememberAsyncImagePainter
import com.thindie.design_system.KodeTraineeDrawable
import com.thindie.design_system.elements.KodeTraineeGenericImageComponentRow
import com.thindie.design_system.elements.KodeTraineeGenericTextContentColumn
import com.thindie.design_system.painter
import com.thindie.model.coders.CoderModel

@Composable
internal fun CoderListUnit(modifier: Modifier = Modifier, coderModel: CoderModel) {
    val coderAvatar = CoderAsyncAvatarOrStub(coderModel = coderModel)
    KodeTraineeGenericImageComponentRow(modifier = modifier, painter = coderAvatar) {
        KodeTraineeGenericTextContentColumn(
            text = coderModel.getFullName(),
            baseElementTextStyle = MaterialTheme.typography.titleSmall,
            slaveText = coderModel.userTag,
            slaveElementTextStyle = MaterialTheme.typography.labelSmall,
            content = {
                Text(text = coderModel.position)
            }
        )
    }
}

@Composable
private fun CoderAsyncAvatarOrStub(modifier: Modifier = Modifier, coderModel: CoderModel): Painter {

    val stubGoose = KodeTraineeDrawable.Stub.stubGoose.painter()

    val painter = rememberAsyncImagePainter(
        model = coderModel.avatarUrl,
        placeholder = stubGoose,
        error = stubGoose
    )

    return remember { painter }
}