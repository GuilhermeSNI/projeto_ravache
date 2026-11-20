package com.acervo.sistema.web;

import com.acervo.sistema.dominio.Categoria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private List<Categoria> categorias = new ArrayList<>();

    @GetMapping("/inicio")
    public String inicio() { return "categorias/inicio";}

    @GetMapping
    public String listar(Model model){
        model.addAttribute("categorias",categorias);
        return "categorias/lista";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Categoria categoria)
    {
        categorias.add(categoria);
        return "redirect:/categorias";
    }

    @DeleteMapping("excluir/{indice}")
    public String excluir(@PathVariable int indice){
        if (indice >= 0 && indice < categorias.size())
        {
            categorias.remove(indice);
        }
        return "redirect:/categorias";
    }

}
