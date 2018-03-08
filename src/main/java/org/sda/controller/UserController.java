package org.sda.controller;

import org.sda.domain.Password;
import org.sda.domain.User;
import org.sda.repository.UserRepository;
import org.sda.util.PasswordUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class UserController {

    //    Dzięki adnotacji Resource spring sam binduje odpowiedni obiekt
    @Resource
    private UserRepository userRepository;

    //    @ModelAttribute pozwala na utomatyczne uzupełnienie obiektu za podstawie nazw parametrów. Zastepuje request.getParameter(''). Nazwy pół w formatce musza być takie same jak w obiekcie
//    @Validated zapewnia że obiekt przejdzie walidację, m.in. na podstawie adnotacji nad polami
//    BindingResult potrzebujemy aby zapisać wyniki walidacji
//    @RequestParam("password") zmienne których nie ma w obiekcie możemy wyciągnąć uzywajac RequestParam
    @RequestMapping(value = "/adduser2", method = RequestMethod.GET)
    public String addUser(@Validated @ModelAttribute User user, BindingResult bindingResult,
                          @RequestParam("password") String password, ModelMap model) {

        //        Zmienne zapisujemy do modelu, zamiast do requestu
        model.put("userx",user);
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        Password passwordEntity = new Password();
        passwordEntity.setValue(PasswordUtil.hashPassword(password));
        passwordEntity.setUser(user);
        userRepository.save(user, passwordEntity);

        return "afterregistration";
    }
}
