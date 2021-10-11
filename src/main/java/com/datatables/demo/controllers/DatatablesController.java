package com.datatables.demo.controllers;

import com.datatables.demo.DatatablesService;
import com.datatables.demo.beans.Datatables;
import com.datatables.demo.exceptions.DatatablesDemoException;
import com.datatables.demo.validations.DatatablesValidator;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/datatables")
public class DatatablesController {
    private static final Logger LOG = LoggerFactory.getLogger(DatatablesController.class);
    private static ModelAndView mv = null;
    @Autowired
    private DatatablesValidator datatablesValidator;
    @Autowired
    private DatatablesService datatablesService;


    @GetMapping()
    public ModelAndView showPage() {
        LOG.info("inside show method GET datatables Page......>>>");
        mv = new ModelAndView("datatables-demo");
        return mv;
    }

    @GetMapping("/datatables-demo-form")
    public ModelAndView showForm() {
        LOG.info("inside show method GET datatables-form Page......>>>");
        mv = new ModelAndView("datatables-demo-form", "datatables-form", new Datatables());
        return mv;
    }

    @PostMapping("/datatables-demo-form")
    public String saveForm(@ModelAttribute(name = "datatables-form") Datatables datatables,
                           RedirectAttributes redirectAttributes, BindingResult bindingResult, Model model) {
        LOG.info("inside show method POST admin datatables-form Page......>>>");
        datatablesValidator.validate(datatables, bindingResult);
        if (bindingResult.hasErrors()) {
            return "datatables-demo-form";
        }
        Datatables result = datatablesService.saveDatatables(datatables);
        if (NumberUtils.isDigits(String.valueOf(result.getId()))) {
            redirectAttributes.addFlashAttribute("message", "Details Saved Successfully!");
            return "redirect:/datatables/";
        } else {
            model.addAttribute("error", "Something went wrong, unable to save details!");
            return "datatables-demo-form";
        }
    }

    @PostMapping(value = "/get-all-data")
    @ResponseBody
    public DataTablesOutput<Datatables> fetchAllData(@Valid @RequestBody DataTablesInput input) {
        try {
            return datatablesService.getPaginatedDatatables(input);
        } catch (DatatablesDemoException exception) {
            LOG.error("Unable to fetch sliders for datatable", exception);
            return new DataTablesOutput<>();
        }
    }

    @GetMapping(value = "/update-datatables")
    public ModelAndView updateDatatables(@Valid @RequestParam Long id) {
        LOG.info("inside show method UPDATE admin slider form Page......>>>");
        Optional<Datatables> bean = datatablesService.getDatatablesById(id);
        mv = new ModelAndView("datatables-demo-form", "datatables-form", bean);
        return mv;
    }

    @GetMapping(value = "/delete-datatables")
    public String deleteDatatables(@Valid @RequestParam Long id, RedirectAttributes redirectAttributes) {
        LOG.info("inside show method DELETE admin slider form Page......>>>");
        datatablesService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", String.format("Slider with id %s deleted successfully!", id));
        return "redirect:/datatables";
    }
}
