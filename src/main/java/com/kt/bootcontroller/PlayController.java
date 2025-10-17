package com.kt.bootcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlayController {
	@GetMapping("/play")
	@ResponseBody
	public String play(String game) {
		return "Let's play " + game + "!" ;
	}
}
