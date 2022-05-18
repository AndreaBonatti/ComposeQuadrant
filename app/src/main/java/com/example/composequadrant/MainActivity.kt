package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Quadrant()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        Quadrant()
    }
}

@Composable
fun InfoCard(title: String, desc: String, backgroundColor: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = desc,
            textAlign = TextAlign.Justify
        )
    }
}


@Preview(name = "InfoCardPreview")
@Composable()
fun InfoCardPreview() {
    ComposeQuadrantTheme {
        InfoCard(
            title = stringResource(id = R.string.text_composable),
            desc = stringResource(id = R.string.text_composable_desc),
            backgroundColor = androidx.compose.ui.graphics.Color.Green,
            Modifier
        )
    }
}

@Composable
fun Quadrant() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.weight(1f)) {
            InfoCard(
                title = stringResource(id = R.string.text_composable),
                desc = stringResource(id = R.string.text_composable_desc),
                backgroundColor = androidx.compose.ui.graphics.Color.Green,
                Modifier.weight(1f)
            )
            InfoCard(
                title = stringResource(id = R.string.image_composable),
                desc = stringResource(id = R.string.image_composable_desc),
                backgroundColor = androidx.compose.ui.graphics.Color.Yellow,
                Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            InfoCard(
                title = stringResource(id = R.string.row_composable),
                desc = stringResource(id = R.string.row_composable_desc),
                backgroundColor = androidx.compose.ui.graphics.Color.Cyan,
                Modifier.weight(1f)
            )
            InfoCard(
                title = stringResource(id = R.string.column_composable),
                desc = stringResource(id = R.string.column_composable_desc),
                backgroundColor = androidx.compose.ui.graphics.Color.Gray,
                Modifier.weight(1f)
            )
        }
    }
}