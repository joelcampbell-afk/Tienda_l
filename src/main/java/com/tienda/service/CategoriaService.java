
package com.tienda.service;

import com.tienda.domain.Categoria;
import com.tienda.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {
    //SE USA PARA CREAR AUTOMATICAMENTE UNA INSTANCIA DE ESTA CLASE
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    // SE USA PARA INDICAR QUE SE HARA UNA TRANSACCIION A UNA BD 
    @Transactional(readOnly=true)
    public List<Categoria> getCategorias(boolean activos){
        // SE USA "ACTIVOS" SI SE DESEA LIMITAR LA VISTA A SOLO LAS CATEGORIAS ACTIVAS
        var lista= categoriaRepository.findAll();
        if(activos){ // SI SOLO SE QUIEREN LOS REGISTROS DE CATEGORIAS ACTIVAS
            lista.removeIf(e -> !e.isActivo());     
        }
        return lista;
    }
    
    
    
     @Transactional(readOnly=true)
    public Categoria getCategoria(Categoria categoria){
        return categoriaRepository.findById(categoria.getIdCategoria()).orElse(null);
    }
        // SE USA PARA INDICAR QUE SE HARA UNA TRANSACCIION A UNA BD 
    @Transactional
    public void save(Categoria categoria){
        categoriaRepository.save(categoria);
    } 
    @Transactional
    public void delete(Categoria categoria){
        categoriaRepository.delete(categoria);
    } 
}
