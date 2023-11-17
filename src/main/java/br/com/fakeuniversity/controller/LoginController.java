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
    public String index(){
        return "login/index";
    }

    @PostMapping("/logar")
    public String logar(Model model, User userParam, String lembrar, HttpServletResponse response){
        User user = this.userRepository.Loguin(userParam.getTxEmail(), userParam.getTxSenha());
        if(user != null){
            CookieService.setCookie(response);
            String funcao = user.getTxFuncao();
                return "redirect:/";
//            if ("PROFESSOR".equals(funcao)) {
//                return "redirect:/professor/dashboard";
//            } else if ("ADMINISTRADOR".equals(funcao)) {
//                return "redirect:/administrator/dashboard";
//            } else if ("ALUNO".equals(funcao)) {
//                return "redirect:/aluno/dashboard";
//            } else if ("FORNECEDOR".equals(funcao)) {
//                return "redirect:/fornecedor/dashboard";
//            } else {
//
//            }
//        }

        }
        model.addAttribute("erro", "Usuário ou senha inválidos!");
        return "login/index";
    }
}