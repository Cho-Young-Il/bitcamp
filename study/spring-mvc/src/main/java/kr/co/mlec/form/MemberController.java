package kr.co.mlec.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class MemberController {
	 @RequestMapping("/joinForm.do")
	 public String joinForm() {
		 return "form/joinForm";
	 }
	 
	 @RequestMapping("/join.do")
	 public String join(MemberVO member, Model model) {
		 System.out.println(member.getId());
		 System.out.println(member.getPassword());
		 System.out.println(member.getName());
		 model.addAttribute("msg", "가입이 완료되었습니다.");
		 //return "form/joinForm";
		  return "redirect:/form/joinForm.do";
	 }
}