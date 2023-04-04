package pokedex.pokemonType.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pokedex.pokemonType.application.GetPokemonTypes;
import pokedex.pokemonType.domain.PokemonType;
import pokedex.pokemonType.domain.exceptions.PokemonTypeRepositoryConnectionException;
import pokedex.pokemonType.domain.PokemonTypeCollection;
import pokedex.pokemonType.domain.exceptions.EmptyPokemonNameParameterException;
import pokedex.pokemonType.domain.exceptions.PokemonNotFoundException;
import pokedex.pokemonType.domain.exceptions.PokemonWithoutTypesException;

@RestController
public class GetPokemonTypeWithHttp {
    @GetMapping("/get-pokemon-types-by-name")
    public static String getPokemonTypesByName(@RequestParam String pokemonName) {
        var getPokemonType = new GetPokemonTypes(new PokeApiPokemonTypeRepository());
        if (pokemonName.isBlank()) {
            System.out.println("No correct input");
        }
        try {
            PokemonTypeCollection pokemonTypeCollection = getPokemonType.execute(pokemonName);
            return transformToJSON(pokemonTypeCollection);
        } catch (PokemonNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        } catch (EmptyPokemonNameParameterException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        } catch (PokemonWithoutTypesException | PokemonTypeRepositoryConnectionException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    private static String transformToJSON(PokemonTypeCollection pokemonTypeCollection) {
        var result =  new StringBuilder("[");
        for (PokemonType type : pokemonTypeCollection.getTypes()) {
            result.append(String.format("\"%s\",", type));
        }
        result.deleteCharAt(result.length()-1);
        result.append("]");
        return result.toString();
    }
}


