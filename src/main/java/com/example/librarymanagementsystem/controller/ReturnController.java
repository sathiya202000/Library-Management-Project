package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.Return;
import com.example.librarymanagementsystem.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/returns")
public class ReturnController {

    @Autowired
    private ReturnService returnService;

    @GetMapping
    public String listReturns(Model model) {
        List<Return> returns = returnService.getAllReturns();
        model.addAttribute("returns", returns);
        return "returns/list"; // Path to the return list view
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("return", new Return());
        return "returns/create"; // Path to the create return view
    }

    @PostMapping("/create")
    public String createReturn(@ModelAttribute Return returnRecord) {
        returnService.saveReturn(returnRecord);
        return "redirect:/returns"; // Redirects to the list of returns
    }

    @GetMapping("/edit/{returnId}")
    public String showEditForm(@PathVariable Long returnId, Model model) {
        Return returnRecord = returnService.getReturnById(returnId);
        if (returnRecord == null) {
            return "redirect:/returns"; // Redirects if not found
        }
        model.addAttribute("return", returnRecord);
        return "returns/edit"; // Path to the edit return view
    }

    @PostMapping("/edit/{returnId}")
    public String updateReturn(@PathVariable Long returnId, @ModelAttribute Return returnRecord) {
        returnRecord.setReturnId(returnId);
        returnService.saveReturn(returnRecord);
        return "redirect:/returns"; // Redirects to the list of returns
    }

    @GetMapping("/delete/{returnId}")
    public String deleteReturn(@PathVariable Long returnId) {
        returnService.deleteReturn(returnId);
        return "redirect:/returns"; // Redirects to the list of returns
    }
}
