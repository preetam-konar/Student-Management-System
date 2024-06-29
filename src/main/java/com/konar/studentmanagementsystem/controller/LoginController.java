package com.konar.studentmanagementsystem.controller;

import com.konar.studentmanagementsystem.entity.security.Role;
import com.konar.studentmanagementsystem.entity.security.User;
import com.konar.studentmanagementsystem.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class LoginController {

    private String currUserId;
    private User currUser;
    private Authentication authentication;
    private AppService appService;

    @Autowired
    LoginController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "login-page";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "access-denied-page";
    }

    @GetMapping("/showFormForUpdatePassword")
    public String showFormForUpdatePassword(
            @RequestParam(name = "error", required = false) String error,
            @RequestParam(name = "success", required = false) String success,
            Model model
    ) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        currUserId = authentication.getName();
        currUser = appService.findUserByUserId(currUserId);

        if (error != null) {
            model.addAttribute("error", error);
        }
        if (success != null) {
            model.addAttribute("success", "Password successfully changed!");
        }

        return "show-form-for-password-update";
    }

    @PostMapping("/updatePassword")
    public RedirectView updatePassword(
            @RequestParam(name = "currPw") String currPw,
            @RequestParam(name = "newPw") String newPw,
            @RequestParam(name = "reNewPw") String reNewPw
    ) {
        String currentPassword = currUser.getPw();
        currentPassword = currentPassword.substring(6);
        RedirectView redirectView = new RedirectView();
        String errorMsg = "";
        if (currPw == null || newPw == null) {
            errorMsg = "Enter a valid password";
        } else if (currPw.contains(" ") || newPw.contains(" ")) {
            errorMsg = "Password should not contain spaces";
        } else if (!currentPassword.equals(currPw)) {
            errorMsg = "Wrong password entered";
        } else if (!newPw.equals(reNewPw)) {
            errorMsg = "New password and Re-enter password don't match";
        } else {
            currUser.setPw("{noop}" + newPw);
            appService.updateUser(currUser);
            redirectView.setUrl("/showFormForUpdatePassword?success=true");
            return redirectView;
        }
        redirectView.setUrl("/showFormForUpdatePassword");
        errorMsg = URLEncoder.encode(errorMsg, StandardCharsets.UTF_8);
        redirectView.setUrl("/showFormForUpdatePassword?error=" + errorMsg);
        return redirectView;
    }

    @PostMapping("/redirectBack")
    public String redirectBack() {
        Role currRole = currUser.getRole();
        String currAuth = currRole.getRole();
        currAuth = currAuth.substring(5);
        currAuth = currAuth.toLowerCase();
        String redirectUrl = "redirect:/" + currAuth + "/home";
        return redirectUrl;
    }
}
