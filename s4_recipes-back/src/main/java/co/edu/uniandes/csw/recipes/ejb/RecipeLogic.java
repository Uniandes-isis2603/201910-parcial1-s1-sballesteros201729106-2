/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.recipes.ejb;

import co.edu.uniandes.csw.recipes.entities.RecipeEntity;
import co.edu.uniandes.csw.recipes.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.recipes.persistence.RecipePersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author CesarF
 */
@Stateless
public class RecipeLogic {
    @Inject
    private RecipePersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    public RecipeEntity getRecipe(Long id) {
        return persistence.find(id);
    }

    //TODO crear el método createRecipe

     public RecipeEntity createEditorial(RecipeEntity recipeEntity) throws BusinessLogicException {
        if (persistence.findByName(recipeEntity.getName()) != null) {
            throw new BusinessLogicException("Ya existe una Recipe con el nombre \"" + recipeEntity.getName() + "\"");
        }
        // Invoca la persistencia para crear la editorial
        persistence.create(recipeEntity);
        return recipeEntity;
    }
}
