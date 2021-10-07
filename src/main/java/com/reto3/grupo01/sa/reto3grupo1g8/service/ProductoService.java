/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.grupo01.sa.reto3grupo1g8.service;

import com.reto3.grupo01.sa.reto3grupo1g8.entity.Producto;
import com.reto3.grupo01.sa.reto3grupo1g8.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repository;
    
    /**C
     * guardar
     */
     public Producto saveProducto(Producto producto){
         return repository.save(producto);
     } 
    
    
    /**R
     * mostrar todos los productos
     */
    public List<Producto> getProductoAll(){
        return repository.findAll();
    }
    
    /**
     * 
     * U
     * Actualizar Producto por ID
     */
    
    public Producto updateProducto(Producto producto){
      Producto existeProducto=repository.findById(producto.getId()).orElse(null);
      existeProducto.setNombre(producto.getNombre());
      existeProducto.setPrecio(producto.getPrecio());
      existeProducto.setInventario(producto.getInventario());
      return repository.save(existeProducto);
        
    }
    
    /**
     * Eliminar Producto por ID
     */
    public String deleteProducto(int id){
        repository.deleteById(id);
        return "Producto Removido "+id;
    }
    
    
}
