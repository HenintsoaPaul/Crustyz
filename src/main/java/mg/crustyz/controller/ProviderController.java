package mg.crustyz.controller;

import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.supply.Provider;
import mg.crustyz.repository.ProviderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/providers" )
public class ProviderController {
    private final ProviderRepository providerRepository;

    @GetMapping
    public String getAll( Model model ) {
        model.addAttribute( "providersList", providerRepository.findAll() );
        return "providers/index";
    }

    @GetMapping( "/add" )
    public String gotoSave( Model model ) {
        model.addAttribute( "provider", new Provider() );
        return "providers/add";
    }

    @PostMapping( "/save" )
    public String save( @ModelAttribute( "provider" ) Provider provider ) {
        providerRepository.save( provider );
        return "redirect:/providers";
    }

    @GetMapping( "/update/{id}" )
    public String gotoUpdate( Model model, @PathVariable Integer id )
            throws Exception {
        Provider u = providerRepository.findById( id )
                .orElseThrow( () -> new Exception( "Provider not found" ) );
        model.addAttribute( "provider", u );
        return "providers/update";
    }

    @GetMapping( "/{id}" )
    public String detail( Model model, @PathVariable Integer id )
            throws Exception {
        Provider u = providerRepository.findById( id )
                .orElseThrow( () -> new Exception( "Provider not found" ) );
        model.addAttribute( "provider", u );
        return "providers/detail";
    }
}
