package com.example.biblion.Activity.Cart

import androidx.compose.foundation.Image // Importa componente para exibir imagens
import androidx.compose.foundation.background // Importa componente para fundo de elementos
import androidx.compose.foundation.layout.Column // Importa componente para layout em coluna
import androidx.compose.foundation.layout.Row // Importa componente para layout em linha
import androidx.compose.foundation.layout.Spacer // Importa componente para espaçamento
import androidx.compose.foundation.layout.fillMaxWidth // Importa função para preencher toda a largura
import androidx.compose.foundation.layout.height // Importa função para definir altura
import androidx.compose.foundation.layout.padding // Importa função para padding (espaçamento interno)
import androidx.compose.foundation.layout.width // Importa função para definir largura
import androidx.compose.foundation.shape.RoundedCornerShape // Importa forma arredondada para cantos
import androidx.compose.material3.Button // Importa componente de botão
import androidx.compose.material3.ButtonDefaults // Importa configurações padrão do botão
import androidx.compose.material.Divider // Importa componente para dividir linhas
import androidx.compose.material3.Text // Importa componente para texto
import androidx.compose.runtime.Composable // Importa anotação para funções composáveis
import androidx.compose.ui.Alignment // Importa alinhamento de componentes
import androidx.compose.ui.Modifier // Importa modificador para alterar componentes
import androidx.compose.ui.graphics.Color // Importa classe para cores
import androidx.compose.ui.graphics.painter.Painter // Importa classe para pintar imagens
import androidx.compose.ui.res.colorResource // Importa função para obter cores de recursos
import androidx.compose.ui.res.painterResource // Importa função para obter imagens de recursos
import androidx.compose.ui.text.font.FontWeight // Importa peso da fonte
import androidx.compose.ui.unit.dp // Importa unidade de densidade (dp)
import androidx.compose.ui.unit.sp // Importa unidade de tamanho de fonte (sp)
import com.example.biblion.R // Importa recursos do projeto

@Composable // Indica que a função é uma composição de UI
fun DeliveryInfoBox() { // Função que cria a caixa de informações de entrega
    Column( // Layout em coluna para empilhar elementos verticalmente
        modifier = Modifier
            .fillMaxWidth() // Ocupa toda a largura disponível
            .padding(top = 8.dp) // Espaçamento superior
            .background(color = colorResource(R.color.grey), shape = RoundedCornerShape(10.dp)) // Fundo cinza com cantos arredondados
            .padding(8.dp) // Padding interno
    ) {
        InfoItem( // Componente para endereço de entrega
            title = "Seu endereço de entrega", // Título do item
            content = "Brasília, SQSW 205", // Conteúdo do endereço
            icon = painterResource(R.drawable.location) // Ícone de localização
        )

        Divider(modifier = Modifier.padding(vertical = 8.dp)) // Linha divisória com espaçamento vertical
        InfoItem( // Componente para método de pagamento
            title = "Método de pagamento", // Título do método
            content = "Dinheiro", // Forma de pagamento
            icon = painterResource(R.drawable.credit_card) // Ícone de cartão de crédito
        )

    }
    Button( // Botão para fazer o pedido
        onClick = {}, // Ação ao clicar ( vazio aqui)
        shape= RoundedCornerShape(10.dp), // Cantos arredondados
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.orange) // Cor de fundo laranja
        ),
        modifier = Modifier
            .padding(vertical = 32.dp) // Espaçamento vertical ao redor
            .fillMaxWidth() // Ocupa toda a largura
            .height(50.dp) // Altura do botão
    ) {
        Text(text="Fazer pedido", fontSize = 18.sp, // Texto do botão com tamanho
            color = Color.White // Cor do texto branca
        )
    }
}

@Composable // Anotação de função composável
fun InfoItem(title: String, content: String, icon: Painter) { // Função que exibe um item de informação
    Column { // Layout em coluna para empilhar elementos
        Text(text = title, fontSize = 14.sp, color = Color.Gray) // Título em cinza e tamanho menor
        Spacer(modifier = Modifier.height(4.dp)) // Espaçamento entre título e conteúdo
        Row(verticalAlignment = Alignment.CenterVertically) { // Linha com alinhamento central
            Image(
                painter = icon, // Ícone passado como parâmetro
                contentDescription = null // Descrição de acessibilidade nula
            )
            Spacer(modifier = Modifier.width(8.dp)) // Espaçamento entre ícone e texto
            Text(
                text = content, fontSize = 18.sp, // Conteúdo maior e em negrito
                fontWeight = FontWeight.Bold
            )
        }
    }

} // Fim da função InfoItem