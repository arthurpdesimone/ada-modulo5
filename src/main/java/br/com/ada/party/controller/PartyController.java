package br.com.ada.party.controller;

import br.com.ada.party.model.Party;
import br.com.ada.party.service.PartyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/party")
public class PartyController {
    @Autowired
    private PartyService partyService;

    @PostMapping
    public ResponseEntity<Party> createParty(@Valid @RequestBody Party party){
        partyService.saveParty(party);
        return ResponseEntity.ok(party);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Party>> getParty(@PathVariable Long id){
        Optional<Party> party = partyService.getParty(id);
        if(party.isPresent()){
            return ResponseEntity.ok(party);
        }
        return ResponseEntity.notFound().build();
    }
}
