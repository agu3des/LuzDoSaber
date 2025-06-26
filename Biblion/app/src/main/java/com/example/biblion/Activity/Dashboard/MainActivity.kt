package com.example.biblion.Activity.Dashboard

import android.os.Bundle // importa a classe Bundle do Android, usada para passar dados na criação da activity
import androidx.activity.compose.setContent // importa a função setContent para usar Compose na activity
import androidx.activity.enableEdgeToEdge // importa a função para habilitar o conteúdo que vai até as bordas da tela
import androidx.appcompat.app.AppCompatActivity // importa a classe base para atividades compatíveis com ActionBar
import androidx.compose.foundation.layout.fillMaxSize // importa o modificador fillMaxSize para preencher espaço disponível
import androidx.compose.foundation.layout.padding // importa o modificador padding para adicionar espaçamento interno
import androidx.compose.foundation.lazy.LazyColumn // importa a LazyColumn, que cria uma lista rolável preguiçosa
import androidx.compose.material.Scaffold // importa o Scaffold, que fornece estrutura básica com barra, rodapé, etc.
import androidx.compose.material.rememberScaffoldState // importa para lembrar o estado do Scaffold
import androidx.compose.runtime.Composable // importa a anotação para funções Compose
import androidx.compose.runtime.LaunchedEffect // importa para executar efeitos colaterais ao iniciar a composição
import androidx.compose.runtime.getValue // importa para usar propriedade Delegates para estado
import androidx.compose.runtime.mutableStateListOf // importa para criar listas mutáveis que reagem às mudanças
import androidx.compose.runtime.mutableStateOf // importa para criar estados mutáveis simples
import androidx.compose.runtime.remember // importa para manter o estado durante a recomposição
import androidx.compose.runtime.setValue // importa para usar propriedade Delegates para estado
import androidx.compose.ui.Modifier // importa a classe Modifier para modificar componentes
import com.example.biblion.Domain.BannerModel // importa o modelo de banner
import com.example.biblion.Domain.CategoryModel // importa o modelo de categoria
import com.example.biblion.ViewModel.MainViewModel // importa o ViewModel principal

class MainActivity : AppCompatActivity() { // define a atividade principal estendendo AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) { // método chamado na criação da atividade
        super.onCreate(savedInstanceState) // chama o método pai para configuração padrão
        enableEdgeToEdge() // habilita o conteúdo que vai até as bordas da tela
        setContent { // define o conteúdo da atividade usando Compose
            MainScreen() // chama a função Compose que monta a tela principal
        }
    }
}

@Composable // indica que a função é um componente Compose
fun MainScreen() {
    val scaffoldState = rememberScaffoldState() // lembra o estado do scaffold (barra, drawer, etc.)
    val viewModel = MainViewModel() // cria uma instância do ViewModel para buscar dados

    val banners = remember { mutableStateListOf<BannerModel>() } // lista de banners que reage às mudanças
    val categories = remember { mutableStateListOf<CategoryModel>() } // lista de categorias que reage às mudanças

    var showBannerLoading by remember { mutableStateOf(true) } // controla a exibição do loading de banners
    var showCategoryLoading by remember { mutableStateOf(true) } // controla o loading de categorias

    LaunchedEffect(Unit) { // efeito ao iniciar a composição
        viewModel.loadBanner().observeForever { // observa as mudanças nos banners carregados
            banners.clear() // limpa a lista de banners
            banners.addAll(it) // adiciona os banners carregados
            showBannerLoading = false // esconde o loading de banners
        }
    }

    LaunchedEffect(Unit) { // outro efeito ao iniciar a composição
        viewModel.loadCategory().observeForever { // observa as categorias carregadas
            categories.clear() // limpa a lista de categorias
            categories.addAll(it) // adiciona as categorias carregadas
            showCategoryLoading = false // esconde o loading de categorias
        }
    }

    Scaffold(
        bottomBar = { MyBottomBar() }, // define a barra inferior personalizada
        scaffoldState = scaffoldState // passa o estado do scaffold
    ) { paddingValues -> // bloco de conteúdo do scaffold com padding automático
        LazyColumn(
            modifier = Modifier
                .fillMaxSize() // preenche toda a tela disponível
                .padding(paddingValues = paddingValues) // aplica o padding do scaffold
        ) {
            item {
                TopBar() // adiciona a barra superior
            }
            item {
                Banner(banners, showBannerLoading) // exibe os banners com loading
            }
            item {
                Search() // componente de busca
            }
            item{
                CategorySection(categories, showCategoryLoading) // seção de categorias com loading
            }
        }
    }
}