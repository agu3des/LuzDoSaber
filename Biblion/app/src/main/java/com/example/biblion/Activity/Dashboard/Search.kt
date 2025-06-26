package com.example.biblion.Activity.Dashboard

import androidx.compose.foundation.Image // Importa componente de imagem
import androidx.compose.foundation.background // Importa função para definir fundo
import androidx.compose.foundation.layout.fillMaxWidth // Importa para fazer a largura preencher o espaço disponível
import androidx.compose.foundation.layout.height // Importa para definir altura
import androidx.compose.foundation.layout.padding // Importa para definir espaçamento interno
import androidx.compose.foundation.layout.size // Importa para definir tamanho de componentes
import androidx.compose.foundation.shape.CircleShape // Importa forma de círculo
import androidx.compose.foundation.shape.RoundedCornerShape // Importa forma de canto arredondado
import androidx.compose.material.TextField // Importa campo de texto
import androidx.compose.material.TextFieldDefaults // Importa configurações padrão do TextField
import androidx.compose.material3.Text // Importa componente de texto (versão Material 3)
import androidx.compose.runtime.Composable // Importa anotação para funções composáveis
import androidx.compose.runtime.getValue // Importa para obter valores de estados
import androidx.compose.runtime.mutableStateOf // Importa para criar estados mutáveis
import androidx.compose.runtime.saveable.rememberSaveable // Importa para lembrar e salvar estados durante recomposições
import androidx.compose.runtime.setValue // Importa para definir valores de estados
import androidx.compose.ui.Modifier // Importa modificador para ajustar componentes
import androidx.compose.ui.graphics.Color // Importa para trabalhar com cores
import androidx.compose.ui.res.colorResource // Importa para usar cores de recursos
import androidx.compose.ui.res.painterResource // Importa para carregar imagens de recursos
import androidx.compose.ui.text.font.FontStyle // Importa estilos de fonte (normal, itálico)
import androidx.compose.ui.text.font.FontWeight // Importa peso da fonte (negrito, semi-negrito, etc.)
import androidx.compose.ui.tooling.preview.Preview // Importa para visualização prévia no Android Studio
import androidx.compose.ui.unit.dp // Importa unidade de medida em dp
import com.example.biblion.R // Importa recursos do projeto

@Composable // Indica que a função é uma componente de UI
@Preview // Permite visualizar a composable no editor
fun Search() { // Função que cria a barra de busca
    var text by rememberSaveable { mutableStateOf("") } // Cria um estado que guarda o texto do campo, preservando durante recomposições
    TextField( // Cria um campo de texto editável
        value = text, // Valor atual do campo de texto
        onValueChange = { text = it }, // Atualiza o valor quando o usuário digita
        label = { // Label do campo de texto
            Text(
                text = "O que você gostaria de ler?", // Texto do label
                fontStyle = FontStyle.Italic, // Deixa o texto em itálico
                fontWeight = FontWeight.SemiBold, // Deixa o texto semi-negrito
                color = Color.DarkGray // Cor do texto do label
            )
        },
        trailingIcon = { // Ícone que fica na extremidade do campo (lado direito)
            Image(
                painter = painterResource(R.drawable.search), // Carrega a imagem do ícone de busca
                contentDescription = null, // Descrição de acessibilidade (não fornecida)
                modifier = Modifier.size(22.dp) // Define o tamanho do ícone
            )
        },
        shape = RoundedCornerShape(10.dp), // Borda com cantos arredondados de 10.dp
        colors = TextFieldDefaults.outlinedTextFieldColors( // Configura cores do TextField
            backgroundColor = colorResource(R.color.grey), // Cor de fundo
            focusedBorderColor = Color.Transparent, // Sem borda ao focar
            unfocusedLabelColor = Color.Transparent, // Label invisível quando desfocado
            textColor = colorResource(R.color.darkPink), // Cor do texto digitado
            unfocusedBorderColor = Color.Transparent // Borda invisível quando desfocado
        ),
        modifier = Modifier // Aplica modificadores ao campo
            .fillMaxWidth() // Faz o campo ocupar toda a largura disponível
            .padding(16.dp) // Adiciona espaçamento interno de 16dp
            .height(50.dp) // Define altura de 50dp
            .background(colorResource(R.color.grey), CircleShape) // Fundo de cor cinza com forma circular
    )
} // Fim da função Search()