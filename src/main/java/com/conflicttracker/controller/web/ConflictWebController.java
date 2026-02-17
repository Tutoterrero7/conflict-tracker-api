package com.conflicttracker.controller.web;

import com.conflicttracker.dto.ConflictDTO;
import com.conflicttracker.service.ConflictService; // Importa el teu servei
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/web/conflicts")
public class ConflictWebController {

    private final ConflictService conflictService;

    public ConflictWebController(ConflictService conflictService) {
        this.conflictService = conflictService;
    }

    @GetMapping
    public String listAllConflicts(Model model) {
        // Utilitzem el mateix servei que per l'API per obtenir els DTOs
        List<ConflictDTO> conflicts = conflictService.getAllConflicts();
        model.addAttribute("conflicts", conflicts);
        return "List";

    }
}