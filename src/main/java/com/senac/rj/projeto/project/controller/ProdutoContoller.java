package com.senac.rj.projeto.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.senac.rj.projeto.project.model.Produto;
import com.senac.rj.projeto.project.model.ProdutoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class ProdutoContoller {
    @Autowired
    private ProdutoRepository repository;
    //EXIBINDO OS PRODUTOS
    @GetMapping("/")
    public String listarProdutos(Model model) {
        model.addAttribute("todosOsProdutos", repository.findAll()); //addAtribute("nome da lista", métedo de busca)
        return "listar";
    }
    
    
    //CADASTRANDO O PRODUTO
    // Get -> Precisa retornar um formulário de cadastro para o usuário preencher os dados do produto
    @GetMapping("/cadastro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("produto", new Produto()); //addAtribute  vai receber o model para que a gente possa usar ele na página de cadastro, ou seja, para mostrar os dados do produto que o usuário vai cadastrar
        //também deve passar o construtor do model
        return "cadstrar"; //é o arquivo cadastrar.html que está na pasta templates, ou seja, é a página que irá aparecer para o usuário quando ele acessar a rota /cadastro
    }

    // Post -> Cadastrar um produto com seus atributos (nome e preço). Irá ocorrer quando eu clicar no botão do formulário da página cadastrar.html
    @PostMapping("/cadastro")
    public String cadastrarPrduto(Produto produto) {
        repository.save(produto);
        return "/"; //Vai retornar para a pagina incial cadastrar.html
    }
    


}
