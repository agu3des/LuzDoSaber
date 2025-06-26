package com.example.biblion.Splash

import androidx.compose.foundation.border // Importa a função para criar bordas em componentes
import androidx.compose.foundation.layout.Row // Importa para organizar componentes em uma linha horizontal
import androidx.compose.foundation.layout.fillMaxWidth // Importa para fazer componentes preencherem toda a largura disponível
import androidx.compose.foundation.layout.height // Importa para definir a altura dos componentes
import androidx.compose.foundation.layout.padding // Importa para adicionar espaço interno (margem) aos componentes
import androidx.compose.foundation.shape.RoundedCornerShape // Importa para criar cantos arredondados
import androidx.compose.material.Text // Importa para exibir textos na tela
import androidx.compose.material3.Button // Importa o componente de botão do Material Design 3
import androidx.compose.material3.ButtonDefaults // Importa configurações padrão para botões
import androidx.compose.runtime.Composable // Importa para marcar funções como componentes reutilizáveis do Compose
import androidx.compose.ui.Modifier // Importa para modificar atributos de componentes
import androidx.compose.ui.graphics.Color // Importa para usar cores
import androidx.compose.ui.res.colorResource // Importa para usar cores definidas em recursos
import androidx.compose.ui.tooling.preview.Preview // Importa para permitir visualização do componente no preview do IDE
import androidx.compose.ui.unit.dp // Importa para definir tamanhos em density-independent pixels
import androidx.compose.ui.unit.sp // Importa para definir tamanhos de fonte em scale-independent pixels
import com.example.biblion.R // Importa o arquivo de recursos onde estão definidas as cores e outros recursos

@Composable // Indica que a função é um componente reutilizável do Compose
@Preview // Permite visualizar o componente no modo de pré-visualização do IDE
fun GetStartedButton(onClick: () -> Unit = {}, modifier: Modifier = Modifier) { // Define a função que cria os botões, com uma ação padrão e um modificador padrão
    Row( // Cria uma linha horizontal para colocar os botões lado a lado
        modifier = modifier // Aplica qualquer modificação passada na chamada
            .fillMaxWidth() // Faz a linha ocupar toda a largura disponível
            .padding(horizontal = 16.dp) // Adiciona uma margem de 16dp nas laterais
    ) {
        Button( // Primeiro botão (Inscrever-se)
            onClick = {}, // Ação ao clicar (não definida aqui)
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent // Cor de fundo transparente
            ),
            shape = RoundedCornerShape(50.dp), // Cantos arredondados com raio de 50dp
            modifier = modifier // Aplica modificações passadas
                .padding(end = 12.dp) // Espaçamento à direita do botão
                .fillMaxWidth(0.40f) // Ocupa 35% da largura disponível
                .border(1.dp, Color.White, shape = RoundedCornerShape(50.dp)) // Adiciona uma borda branca de 1dp com cantos arredondados
                .height(50.dp) // Altura de 50dp
        ) {
            Text( // Texto dentro do botão
                text = "Inscreva-se", // Texto exibido
                fontSize = 14.sp, // Tamanho da fonte
                color = Color.White // Cor do texto branca
            )
        }

        Button( // Segundo botão (Começar)
            onClick = {onClick()}, // Executa a ação passada como parâmetro
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.pink) // Cor de fundo laranja do recursos
            ),
            shape = RoundedCornerShape(50.dp), // Cantos arredondados
            modifier = modifier // Aplica modificações passadas
                .fillMaxWidth() // Ocupa toda a largura restante
                .height(50.dp) // Altura de 50dp
        ) {
            Text( // Texto dentro do botão
                text = "Começar", // Texto exibido
                fontSize = 16.sp, // Tamanho da fonte
                color = Color.White // Cor do texto branca
            )
        }

    }
}