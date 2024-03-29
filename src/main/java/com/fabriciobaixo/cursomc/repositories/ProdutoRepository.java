package com.fabriciobaixo.cursomc.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fabriciobaixo.cursomc.domain.Categoria;
import com.fabriciobaixo.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
	
	/*
	 * Consulta JPQL personalizada 
	 @Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	 Page<Produto> search(@Param("nome") String nome,@Param ("categorias") List<Categoria> categorias, Pageable pageRequest);
	*/
	
	//Usando apenas nomenclaturas de Query do Spring efetua a mesma busca personalizada do código acima
	@Transactional(readOnly=true)
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);

}
