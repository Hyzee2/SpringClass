package com.digi.market.command;

import org.springframework.ui.Model;

public interface Command {
	void execute(Model model); 
}
