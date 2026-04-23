package com.example.lazycolumnbasic

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

data class ItemCompra(
    val id: Int,
    val nome: String,
    val imagem: String,
    val imagemLocal: Int? = null,
    var comprado: Boolean = false,
)

@Composable
fun ListaComprasScreen(
    modifier: Modifier = Modifier,
) {
    val itens = remember {
        mutableStateListOf(
            ItemCompra(1, "DOm CAsmurro ", "https://picsum.photos/200/300?random=1"),
            ItemCompra(2, "A vida invisível de Addie LaRue", "https://picsum.photos/id/2/200"),
            ItemCompra(3, "Jantar Secreto", "https://picsum.photos/id/3/200"),
            ItemCompra(4, "A Canção de Aquiles", "https://picsum.photos/id/4/200"),
            ItemCompra(5, "Quem é você Alasca", "https://picsum.photos/id/5/200"),
            ItemCompra(6, "Vidas Secas", "https://picsum.photos/id/6/200"),
            ItemCompra(7, "Dom Casmurro", "https://picsum.photos/id/7/200"),
            ItemCompra(8, "Os dois morrem no final", "https://picsum.photos/id/8/200"),
            ItemCompra(9, "Vilarejo", "https://picsum.photos/id/9/200"),
            ItemCompra(10, "A Empregada", "https://picsum.photos/id/10/200"),
            ItemCompra(11, "Os últimos a morrerem no final", "https://picsum.photos/id/11/200"),
            ItemCompra(12, "1984", "https://picsum.photos/id/12/200"),
            ItemCompra(13, "O Estrangeiro", "https://picsum.photos/id/13/200"),
            ItemCompra(14, "O Pequeno Príncipe", "https://picsum.photos/id/14/200"),
            ItemCompra(15, "A Cartomante", "https://picsum.photos/id/15/200"),
            ItemCompra(16, "Romeu e Julieta", "https://picsum.photos/id/16/200"),
            ItemCompra(17, "Dom Quixote", "https://picsum.photos/id/17/200"),
            ItemCompra(18, "A Hora da Estrela", "https://picsum.photos/id/18/200"),
            ItemCompra(19, "Grande Sertão", "https://picsum.photos/id/19/200"),
        )
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(
            items = itens,
            key = { it.id }
        ) { item ->

            ItemCompraRow(
                item = item,
                onCompradoChange = { marcado ->
                    item.comprado = marcado
                }
            )
        }
    }
}

@Composable
private fun ItemCompraRow(
    item: ItemCompra,
    modifier: Modifier = Modifier,
    onCompradoChange: (Boolean) -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {


        AsyncImage(
            model = item.imagem,
            contentDescription = "Capa do livro",
            modifier = Modifier.size(60.dp)
        )

        Checkbox(
            checked = item.comprado,
            onCheckedChange = onCompradoChange,
        )

        Text(
            text = item.nome,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.titleMedium,
        )
    }
}




@Preview(showBackground = true)
@Composable
private fun ListaComprasScreenPreview() {
    MaterialTheme {
        ListaComprasScreen()
    }
}