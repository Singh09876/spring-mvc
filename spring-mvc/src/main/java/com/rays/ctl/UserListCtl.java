package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rays.dto.UserDTO;
import com.rays.form.UserForm;
import com.rays.service.UserService;

@Controller
@RequestMapping(value = "/ctl/UserList")
public class UserListCtl {
	

	    @Autowired
	    private UserService userService;

	    @GetMapping
	    public String userPage(@ModelAttribute("form") UserForm form,Model model) {
	    	int  pageNo=1;
	    	int  pageSize=5;
	    	List<UserDTO> userList = userService.search(null, pageNo, pageSize);
	    	form.setPageNo(pageNo);
	    	model.addAttribute("userList", userList);
	        return "UserListView";
	    }

	    @PostMapping
	    public String userOperation(@ModelAttribute("form") UserForm form,@RequestParam(required = false) String operation, Model model) {
	    	UserDTO dto = null;

		int pageNo = 1;
		int pageSize = 5;

		if (operation.equals("next")) {

			pageNo = form.getPageNo();

			pageNo++;
			System.out.println("next flow--------"+pageNo);

	        }
		if (operation.equals("add")) {

			return "redirect:User";

	        }

		if (operation.equals("previous")) {

			pageNo = form.getPageNo();

			pageNo--;
			System.out.println("previous flow--------"+pageNo);

		}

		if (operation.equals("search")) {

			dto = new UserDTO();

			dto.setId(form.getId());

			dto.setFirstName(form.getFirstName());

		}
		if (operation.equals("delete")) {
			if (form.getIds() != null && form.getIds().length > 0) {
				for (long id : form.getIds()) {
					userService.delete(id);
					//return "redirect:UserList";
					
				}
			}
		}

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
		List<UserDTO> userList = userService.search(dto, pageNo, pageSize);
		List<UserDTO> nextList = userService.search(dto, pageNo+1, pageSize);
		model.addAttribute("userList", userList);
		model.addAttribute("nextList", nextList);

		return "UserListView";}
	

}
