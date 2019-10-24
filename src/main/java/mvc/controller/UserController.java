package mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mvc.form.UserForm;
import mvc.model.User;
import mvc.service.UserService;
import mvc.service.LoginService;
import mvc.validator.SignupValidator;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	SignupValidator signupValidator;

	LoginService loginService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("user/list");

		List list = userService.listAllUsers();
		model.addObject("listUser", list);

		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("user/form");
		model.addObject("userForm", new User());
		
		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("user/form");
		model.addObject("userForm", userService.findUserById(id));
		
		return model;
	}

	@RequestMapping(value = "/changePass/{username}", method = RequestMethod.GET)
	public ModelAndView changePass(@PathVariable("username") String username) {
		ModelAndView model = new ModelAndView("user/change_pass");
		model.addObject("user", userService.findUserByUsername(username));

		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("user") User user) {

		if (user != null && user.getId() != null) {
			userService.updateUser(user);
		} else {
			userService.addUser(user);
		}

		return new ModelAndView("redirect:/user/list");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		userService.deleteUser(id);

		return new ModelAndView("redirect:/user/list");
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView("user/signup");
		model.addObject("userForm", new UserForm());

		return model;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("userForm") UserForm userForm, BindingResult result,
			RedirectAttributes redirectAttributes) {

		signupValidator.validate(userForm, result);

		if (result.hasErrors()) {
			return "/user/signup";
		} else {
			userService.signUp(userForm);
			redirectAttributes.addFlashAttribute("msg", "Conta criada com sucesso!");

			return "redirect:/login";
		}
	}

}