package com.kata.cinema.base.webapp.rest.admin;

import com.kata.cinema.base.models.dto.request.ProductionStudiosRequestDto;
import com.kata.cinema.base.webapp.facade.admin.ProductionStudiosServiceFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/admin/studios")
@AllArgsConstructor
public class AdminProductionStudiosRestController {

    private final ProductionStudiosServiceFacade productionStudiosServiceFacade;


    @PostMapping
    public ResponseEntity<Void> saveProductionStudio(@RequestBody ProductionStudiosRequestDto requestDto) {
        productionStudiosServiceFacade.save(requestDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProductionStudioById(@RequestBody ProductionStudiosRequestDto body,
                                                           @PathVariable Long id) {
        if (!productionStudiosServiceFacade.isExist(id)) {
            return ResponseEntity.notFound().build();
        }

        productionStudiosServiceFacade.update(id, body);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductionStudioById(@PathVariable Long id) {
        productionStudiosServiceFacade.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
