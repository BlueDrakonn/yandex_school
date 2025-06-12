import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListItem(
    modifier: Modifier = Modifier,
    lead: (@Composable () -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
    trailingContent: (@Composable () -> Unit)? = null,
    trailIcon: (@Composable () -> Unit)? = null,
    onTrailClick: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()

            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {



        lead?.let {
            Box(modifier = Modifier.padding(end = 16.dp)) {
                it()
            }
        }


        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            content()
        }




        trailingContent?.let {
            Box(modifier = Modifier
                .padding(start = 8.dp)
                ) {
                it()
            }
        }


        trailIcon?.let {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 12.dp)
                    //.size(24.dp)
                    .clickable {
                        onTrailClick?.invoke()

                    }
            ) {
                it()
            }
        }


    }
    HorizontalDivider()
}
