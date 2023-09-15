package com.roblog.blog.restController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/users")
public class UserRestController {
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@GetMapping("")
	public String getUsers() {
		return "test";
	}

}
