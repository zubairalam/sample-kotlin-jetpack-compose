package com.devhustlers.eduone

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devhustlers.eduone.ui.utils.PROBLEM_LIST_ITEMS
import com.devhustlers.eduone.ui.utils.ProblemSummary
import com.wakaztahir.codeeditor.highlight.model.CodeLang
import com.wakaztahir.codeeditor.highlight.prettify.PrettifyParser
import com.wakaztahir.codeeditor.highlight.theme.CodeThemeType
import com.wakaztahir.codeeditor.highlight.utils.parseCodeAsAnnotatedString

@Composable
fun ProblemSolutionActivity(navController: NavController, problemID: String?) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
            .horizontalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start,
    ) {

        for (problem: ProblemSummary in PROBLEM_LIST_ITEMS) {
            if (problem.id == problemID) {
                SyntaxHighlighterWithLineNumbers(problem.solution)
            }
        }
    }
}

@Composable
fun SyntaxHighlighterWithLineNumbers(code: String) {
    val language = CodeLang.Python

    val parser = remember { PrettifyParser() }
    val themeState by remember { mutableStateOf(CodeThemeType.Default) }
    val theme = remember(themeState) { themeState.theme() }

    fun parse(code: String): AnnotatedString {
        return parseCodeAsAnnotatedString(
            parser = parser,
            theme = theme,
            lang = language,
            code = code
        )
    }

    var textFieldValue by remember { mutableStateOf(TextFieldValue(parse(code))) }
    var lineTops by remember { mutableStateOf(emptyArray<Float>()) }
    val density = LocalDensity.current

    Row {
        if (lineTops.isNotEmpty()) {
            Box(modifier = Modifier.padding(horizontal = 4.dp)) {
                lineTops.forEachIndexed { index, top ->
                    Text(
                        modifier = Modifier.offset(y = with(density) { top.toDp() }),
                        text = index.toString(),
                        color = MaterialTheme.colors.onBackground.copy(.3f)
                    )
                }
            }
        }
        BasicTextField(
            modifier = Modifier.fillMaxSize(),
            value = textFieldValue,
            onValueChange = {
                textFieldValue = it.copy(annotatedString = parse(it.text))
            },
            onTextLayout = { result ->
                lineTops = Array(result.lineCount) { result.getLineTop(it) }
            }
        )
    }

}