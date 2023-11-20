package br.com.fakeuniversity.controller;


import br.com.fakeuniversity.models.User;
import br.com.fakeuniversity.repository.UserRepository;
import br.com.fakeuniversity.services.CookieService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String index() {
        return "login/index";
    }

    @PostMapping("/logar")
    public String logar(Model model, User userParam, String lembrar, HttpServletResponse response) {
        User user = this.userRepository.Loguin(userParam.getTxEmail(), userParam.getTxSenha());
        if (user != null) {
            int tempoLogado = (60 * 30); //30min de cookie
            CookieService.setCookie(response, "userId", String.valueOf(user.getId()), 5);
            String funcao = user.getTxFuncao();
            if ("PROFESSOR".equalsIgnoreCase(funcao)) {
                return "redirect:/professor";
            } else if ("ADMINISTRADOR".equalsIgnoreCase(funcao)) {
                return "redirect:/administrator";
            } else if ("ALUNO".equalsIgnoreCase(funcao)) {
                return "redirect:/aluno";
            } else if ("FORNECEDOR".equalsIgnoreCase(funcao)) {
                return "redirect:/fornecedor";
            }
        }
        model.addAttribute("erro", "Usuário ou senha inválidos!");
        return "login/index";
    }


    @GetMapping("/sair")
       public String sair (HttpServletResponse response){
       CookieService.setCookie(response, "userId", "", 0);
       return "redirect:/login";
    }
}