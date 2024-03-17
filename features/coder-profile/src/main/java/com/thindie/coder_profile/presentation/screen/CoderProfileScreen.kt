package com.thindie.coder_profile.presentation.screen

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.zIndex
import coil.compose.rememberAsyncImagePainter
import com.thindie.coder_profile.presentation.state.CoderProfileScreenState
import com.thindie.design_system.KodeTraineeDimenDefaults
import com.thindie.design_system.KodeTraineeDrawable
import com.thindie.design_system.KodeTraineeStrings
import com.thindie.design_system.elements.KodeTraineeGenericIconComponentRow
import com.thindie.design_system.elements.KodeTraineeGenericImageComponentColumn
import com.thindie.design_system.elements.KodeTraineeGenericTextContentColumn
import com.thindie.design_system.painter
import com.thindie.design_system.string
import com.thindie.design_system.theme.KodeTraineeTheme
import com.thindie.model.NotExpectedSideEffectInside
import com.thindie.model.RussianAgePostfix
import com.thindie.model.coder_profile.CoderProfileModel


@Composable
fun KodeTraineeCoderProfileScreen(
    modifier: Modifier = Modifier,
    profileModel: CoderProfileModel,
    onClickBack: () -> Unit,
) {

    IconButton(modifier = modifier.zIndex(2f), onClick = onClickBack) {
        Icon(
            painter = KodeTraineeDrawable.Profile.back.painter(),
            contentDescription = null,
            tint = Color.Black
        )
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        HeaderSection(profileModel = profileModel)
        Column(modifier = Modifier.padding(KodeTraineeDimenDefaults.PaddingValues.standart)) {

            BirthdayInfoSnippet(profileModel = profileModel)
            Divider(
                modifier
                    .fillMaxWidth()
                    .padding(vertical = KodeTraineeDimenDefaults.Spacing.cutVertical),
                thickness = Dp.Hairline
            )
            @NotExpectedSideEffectInside("DIAL_INTENT")
            TelephoneInfoSnippet(profileModel = profileModel)
        }

    }
}

@Composable
private fun HeaderSection(modifier: Modifier = Modifier, profileModel: CoderProfileModel) {
    KodeTraineeGenericImageComponentColumn(
        modifier = Modifier
            .wrapContentHeight()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(top = KodeTraineeDimenDefaults.Spacing.extendedVertical),
        painter = AsyncImageOrStubGoose(profileModel = profileModel),
        contentSpacing = KodeTraineeDimenDefaults.Spacing.extendedVertical.times(2),
        imageSize = KodeTraineeDimenDefaults.DrawableSize.extraLarge,
        contentScale = ContentScale.FillBounds
    ) {
        KodeTraineeGenericTextContentColumn(
            modifier = modifier
                .fillMaxWidth()
                .height(KodeTraineeDimenDefaults.ProfileScreen.profileInfoTitleHeight),
            text = profileModel.getFullName(),
            baseElementTextStyle = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W700),
            slaveText = profileModel.userTag,
            slaveElementTextStyle = MaterialTheme.typography.labelMedium.copy(
                color = MaterialTheme.colorScheme.onPrimaryContainer, fontWeight = W400
            ),
            contentSpacingVertical = KodeTraineeDimenDefaults.Spacing.extendedVertical.times(2),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = profileModel.position,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.tertiary,
                fontWeight = W400
            )
        }
        Spacer(modifier = Modifier.height(KodeTraineeDimenDefaults.Spacing.extendedVertical))
    }
}


@Composable
private fun AsyncImageOrStubGoose(profileModel: CoderProfileModel): Painter {
    val stubGoose = KodeTraineeDrawable.Stub.stubGoose.painter()
    return rememberAsyncImagePainter(
        model = profileModel.avatarUrl, placeholder = stubGoose, error = stubGoose
    )
}

@Composable
private fun TelephoneInfoSnippet(modifier: Modifier = Modifier, profileModel: CoderProfileModel) {

    val context = LocalContext.current

    KodeTraineeGenericIconComponentRow(
        modifier = modifier.height(KodeTraineeDimenDefaults.ProfileScreen.profileInfoSnippetHeight),
        painter = KodeTraineeDrawable.Profile.phone.painter(),
        contentSpacing = KodeTraineeDimenDefaults.Spacing.baseHorizontal
    ) {

        ClickableText(
            text = AnnotatedString(text = profileModel.phoneNumber),
            onClick = { dialIntentInvoke(context, profileModel) },
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = W500
            ),
        )
    }
}

@Composable
private fun BirthdayInfoSnippet(modifier: Modifier = Modifier, profileModel: CoderProfileModel) {
    KodeTraineeGenericIconComponentRow(
        modifier = modifier.height(KodeTraineeDimenDefaults.ProfileScreen.profileInfoSnippetHeight),
        painter = KodeTraineeDrawable.Profile.star.painter()
    ) {

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = profileModel.formattedBirthdayString,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = W500
            )
            Text(
                text = profileModel.age.toString()
                    .plus(adaptRussianAgeMorphology(profileModel.russianAgePostfix).string()),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontWeight = W500
            )
        }

    }
}
@StringRes
private fun adaptRussianAgeMorphology(russianAgePostfix: RussianAgePostfix): Int {
        return when (russianAgePostfix){
            RussianAgePostfix.FiveToTen ->  KodeTraineeStrings.CoderProfile.ageEnded5_0
            RussianAgePostfix.One ->  KodeTraineeStrings.CoderProfile.ageEnded1
            RussianAgePostfix.Stub ->  KodeTraineeStrings.CoderProfile.stub
            RussianAgePostfix.TwoToFour ->  KodeTraineeStrings.CoderProfile.ageEnded2_4
        }
}

private fun dialIntentInvoke(context: Context, profileModel: CoderProfileModel) {
    context.startActivity(Intent().apply {
        action = Intent.ACTION_DIAL
        data = try {
            Uri.parse("tel:".plus(profileModel.phoneNumber))
        } catch (_: Exception) {
            Uri.parse("tel:")
        }
    })
}

@Composable
@Preview
fun previewKodeTraineeCoderProfileScreen() {
    val state = CoderProfileScreenState.getDefault().coderProfile.copy(
        avatarUrl = "",
        firstName = "Can you hear ",
        id = "",
        lastName = "the sound",
        position = "Blasting out in stereo",
        userTag = "of the static noise",
        phoneNumber = "Music to my nervous system",
        age = 0,
        formattedBirthdayString = "Cater to the class and the paranoid",
        russianAgePostfix = RussianAgePostfix.Stub

    )
    KodeTraineeTheme {
        KodeTraineeCoderProfileScreen(profileModel = state, onClickBack = {})
    }
}
