package pokedex.pokemonDetails.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pokedex.pokemonDetails.application.GetPokemonDetails;
import pokedex.pokemonDetails.domain.PokemonDetail;
import pokedex.pokemonDetails.domain.exceptions.*;
import pokedex.pokemonDetails.infrastructure.exceptions.NotNumericPokemonIdException;

@RestController
public class GetPokemonDetailsWithHttp {
    @GetMapping("/getPokemonDetailsByID")
    public static String getPokemonDetailsByID(@RequestParam(name="pokemonId") String stringPokemonId) {

        var pokemonID = parsePokemonId(stringPokemonId);
        var getPokemonDetails = new GetPokemonDetails(new PokeApiPokemonDetailRepository());

        try {
            PokemonDetail pokemonTypeCollection = getPokemonDetails.execute(pokemonID);
            return transformToJSON(pokemonTypeCollection);
        } catch (PokemonNameNotEmptyException |
                 PokemonNegativeHeightException | PokemonIdOutOfRangeException | PokemonNegativeWeightException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"InvalidPokemonData");

        } catch (PokemonNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        } catch (PokemonDetailRepositoryConnectionException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"ConnectionError");
        }
    }

    private static int parsePokemonId(String stringPokemonId) {
        int pokemonId = 0;
        try {
            pokemonId = Integer.parseInt(stringPokemonId);
        } catch (NumberFormatException e) {
            throw new NotNumericPokemonIdException();
        }
        return pokemonId;
    }

    private static String transformToJSON(PokemonDetail pokemonTypeCollection) {
        return String.format("""
                        {
                            "id":"%d",
                            "name":"%s",
                            "height":"%G",
                            "weight":"%G"
                        }
                        """, 
                pokemonTypeCollection.ID().ID(),
                pokemonTypeCollection.name().toString(),
                pokemonTypeCollection.height().height(),
                pokemonTypeCollection.weight().weight()
        );
    }
}


