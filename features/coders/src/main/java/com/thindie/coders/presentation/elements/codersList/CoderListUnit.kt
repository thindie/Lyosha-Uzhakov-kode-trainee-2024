package com.thindie.coders.presentation.elements.codersList

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import coil.compose.rememberAsyncImagePainter
import com.thindie.design_system.KodeTraineeDimenDefaults
import com.thindie.design_system.KodeTraineeDrawable
import com.thindie.design_system.elements.KodeTraineeGenericImageComponentRow
import com.thindie.design_system.elements.KodeTraineeGenericTextContentColumn
import com.thindie.design_system.painter
import com.thindie.model.coders.CoderModel

@Composable
internal fun CoderListUnit(modifier: Modifier = Modifier, coderModel: CoderModel) {
    val coderAvatar = CoderAsyncAvatarOrStub(coderModel = coderModel)
    KodeTraineeGenericImageComponentRow(
        modifier = modifier,
        painter = coderAvatar,
        contentSpacing = KodeTraineeDimenDefaults.Spacing.extendedHorizontal
    ) {
        KodeTraineeGenericTextContentColumn(
            text = coderModel.getFullName(),
            baseElementTextStyle = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = W500,
                color = MaterialTheme.colorScheme.onBackground
            ),
            slaveText = coderModel.userTag,
            slaveElementTextStyle = MaterialTheme.typography.labelMedium.copy(
                fontWeight = W500,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            ),
            content = {
                Text(
                    text = coderModel.position,
                    color = MaterialTheme.colorScheme.tertiary,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = W400
                )
            }
        )
    }
}

@Composable
private fun CoderAsyncAvatarOrStub(modifier: Modifier = Modifier, coderModel: CoderModel): Painter {

    val stubGoose = KodeTraineeDrawable.Stub.stubGoose.painter()

    return rememberAsyncImagePainter(
        model = coderModel.avatarUrl,
        placeholder = stubGoose,
        error = stubGoose
    )
}