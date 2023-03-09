package pokedex.pokemonType.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pokedex.pokemonType.application.GetPokemonType;
import pokedex.pokemonType.domain.PokemonTypeRepositoryConnectionException;
import pokedex.pokemonType.domain.PokemonTypes;
import pokedex.pokemonType.domain.exceptions.EmptyPokemonNameParameterException;
import pokedex.pokemonType.domain.exceptions.PokemonNotFoundException;
import pokedex.pokemonType.domain.exceptions.PokemonWithoutTypesException;

@RestController
public class GetPokemonTypeWithHttp {
    @GetMapping("getPokemonTypesByName/{pokemonName}")
    public static PokemonTypes getPokemonTypesByName(@PathVariable String pokemonName) {
        var getPokemonType = new GetPokemonType(new PokeApiPokemonTypeRepository());
        if (pokemonName.isBlank()) {
            System.out.println("No correct input");
        }
        try {
            return getPokemonType.execute(pokemonName);
        } catch (PokemonNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        } catch (EmptyPokemonNameParameterException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        } catch (PokemonWithoutTypesException | PokemonTypeRepositoryConnectionException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }
}


