package com.apap.tutorial8.controller;

import com.apap.tutorial8.model.ChangePasswordModel;
import com.apap.tutorial8.model.UserRoleModel;
import com.apap.tutorial8.service.UserRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserRoleController {
    @Autowired
    private UserRoleService userService;

    @PostMapping(value = "/addUser")
    private String addUserSubmit(@ModelAttribute UserRoleModel user) {
        userService.addUser(user);
        return "home";
    }

    @RequestMapping("/update")
    private String updateUser() {
        return "update-password";
    }

    @RequestMapping("/updateSuccess")
    private String updateSuccess(){
        return "update-pwd-success";
    }

    @PostMapping(value ="/updatePassword")
    private ModelAndView updatePass(@ModelAttribute ChangePasswordModel changePassword, Model model, RedirectAttributes redirect) {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		UserRoleModel user = userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		String msg = "";
		
		if(changePassword.getConfirmPassword().equals(changePassword.getNewPassword())) {
			if(passwordEncoder.matches(changePassword.getOldPassword(), user.getPassword())) {
				userService.changePassword(user, changePassword.getNewPassword());
				msg = "Password berhasil diubah!";
			}
			else {
				msg = "Password lama anda salah!";
			}
		}
		else {
			msg = "Password baru tidak sesuai!";
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/user/updateSuccess");
		redirect.addFlashAttribute("msg", msg);
		return modelAndView;
    }
}