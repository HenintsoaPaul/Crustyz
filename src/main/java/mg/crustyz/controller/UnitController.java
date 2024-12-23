package mg.crustyz.controller;

import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.Unit;
import mg.crustyz.repository.UnitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/units" )
public class UnitController {
    private final UnitRepository unitRepository;

    @GetMapping
    public String getAll( Model model ) {
        model.addAttribute( "unitsList", unitRepository.findAll() );
        return "units/index";
    }

    @GetMapping( "/{id}" )
    public String getById( Model model, @PathVariable Integer id ) {
        model.addAttribute( "unit", unitRepository.findById( id ) );
        return "units/detail";
    }

    @GetMapping( "/add" )
    public String gotoSave( Model model ) {
        model.addAttribute( "unit", new Unit() );
        return "units/add";
    }

    @PostMapping( "/save" )
    public String save( @ModelAttribute( "unit" ) Unit unit ) {
        unitRepository.save( unit );
        return "redirect:/units";
    }

    @GetMapping( "/update/{id}" )
    public String formNew( Model model, @PathVariable Integer id )
            throws Exception {
        Unit u = unitRepository.findById( id )
                .orElseThrow( () -> new Exception( "Unit not found" ) );
        model.addAttribute( "unit", u );
        return "units/update";
    }
}
