package kr.soft.study.user.command;

import org.springframework.ui.Model;

public interface Command {
	void execute(Model model); 
}
