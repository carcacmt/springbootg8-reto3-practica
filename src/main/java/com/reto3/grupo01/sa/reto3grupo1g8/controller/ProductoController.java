/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.grupo01.sa.reto3grupo1g8.controller;

import com.reto3.grupo01.sa.reto3grupo1g8.entity.Producto;
import com.reto3.grupo01.sa.reto3grupo1g8.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController 
@RequestMapping("/api/Producto/")
public class ProductoController {
  
    @Autowired
    private ProductoService service;
    
    @GetMapping("/all")
    public List<Producto> findAllProductos(){
        return service.getProductoAll();
    }
    
    @PostMapping("/save")     
    public ResponseEntity addProducto(@RequestBody Producto producto){
        service.saveProducto(producto);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateProducto(@RequestBody Producto producto){
        service.updateProducto(producto);
        return ResponseEntity.status(201).build();
    }    
    
    @DeleteMapping("/delete")    
    public ResponseEntity deleteProducto(@RequestBody Producto producto){
        service.deleteProducto(producto.getId());
        return ResponseEntity.status(204).build();
    }    
        
}
