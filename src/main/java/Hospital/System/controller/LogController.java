package Hospital.System.controller;

import Hospital.System.model.viewModel.LogViewModel;
import Hospital.System.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/log")
public class LogController {
    private LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("")
    public String getLog(Model model, @PageableDefault(size = 8) Pageable pageable) {
        Page<LogViewModel> log = this.logService.getAll(pageable);
        model.addAttribute("log", log);

        return "admin/log";
    }
}
