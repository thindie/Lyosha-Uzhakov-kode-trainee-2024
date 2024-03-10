package com.thindie.design_system.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.thindie.design_system.KodeTraineeDimenDefaults
import com.thindie.design_system.KodeTraineeDrawable
import com.thindie.design_system.painter
import com.thindie.design_system.theme.KodeTraineeTheme


@Composable
@Suppress("LongParameterList")
fun KodeTraineeGenericTextContentRow(
    modifier: Modifier = Modifier,
    text: String,
    baseElementTextStyle: TextStyle,
    slaveText: String,
    slaveElementTextStyle: TextStyle,
    contentSpacing: Dp = KodeTraineeDimenDefaults.Spacing.cutHorizontal,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
) {
    Row(
        modifier = modifier.wrapContentSize(),
        verticalAlignment = verticalAlignment,
        horizontalArrangement = horizontalArrangement
    ) {
        Text(text = text, style = baseElementTextStyle)
        Spacer(modifier = Modifier.width(contentSpacing))
        Text(text = slaveText, style = slaveElementTextStyle)
    }
}


@Composable
@Suppress("LongParameterList")
fun KodeTraineeGenericTextContentColumn(
    modifier: Modifier = Modifier,
    text: String,
    baseElementTextStyle: TextStyle,
    slaveText: String,
    slaveElementTextStyle: TextStyle,
    contentSpacingHorizontal: Dp = KodeTraineeDimenDefaults.Spacing.cutHorizontal,
    contentSpacingVertical: Dp = KodeTraineeDimenDefaults.Spacing.cutVertical,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment
    ) {
        KodeTraineeGenericTextContentRow(
            text = text,
            contentSpacing = contentSpacingHorizontal,
            baseElementTextStyle = baseElementTextStyle,
            slaveText = slaveText,
            slaveElementTextStyle = slaveElementTextStyle
        )
        Spacer(modifier = Modifier.height(contentSpacingVertical))
        content()
    }

}

private const val TEXT = "♦)_♣☻♥IlWMQA"
private const val SLAVE_TEXT = "ai"

@Composable
@Preview
fun previewKodeTraineeGenericTextContentRow() {
    KodeTraineeTheme {
        KodeTraineeGenericTextContentRow(
            text = TEXT,
            baseElementTextStyle = MaterialTheme.typography.titleSmall,
            slaveText = SLAVE_TEXT,
            slaveElementTextStyle = MaterialTheme.typography.labelMedium,
            contentSpacing = KodeTraineeDimenDefaults.Spacing.baseHorizontal,
        )
    }
}

@Composable
@Preview
fun previewKodeTraineeGenericTextContentColumn() {
    KodeTraineeTheme {
        KodeTraineeGenericTextContentColumn(
            modifier = Modifier.height(KodeTraineeDimenDefaults.CoderList.height),
            text = TEXT,
            baseElementTextStyle = MaterialTheme.typography.titleSmall,
            slaveText = SLAVE_TEXT,
            slaveElementTextStyle = MaterialTheme.typography.labelMedium,
            contentSpacingVertical = KodeTraineeDimenDefaults.Spacing.baseVertical,
        ) {
            Text(text = TEXT, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
        }
    }
}

@Composable
@Preview
fun previewDrawableTextGenericSections() {
    KodeTraineeTheme {
        KodeTraineeGenericImageComponentRow(painter = KodeTraineeDrawable.Stub.stubGoose.painter()) {
            KodeTraineeGenericTextContentColumn(
                modifier = Modifier.height(KodeTraineeDimenDefaults.CoderList.height),
                text = TEXT,
                baseElementTextStyle = MaterialTheme.typography.titleSmall,
                slaveText = SLAVE_TEXT,
                slaveElementTextStyle = MaterialTheme.typography.labelMedium,
                contentSpacingVertical = KodeTraineeDimenDefaults.Spacing.baseVertical,
            ) {
                Text(text = TEXT, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
            }
        }
    }
}