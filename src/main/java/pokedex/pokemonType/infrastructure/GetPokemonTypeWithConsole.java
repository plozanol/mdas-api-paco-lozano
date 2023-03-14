package pokedex.pokemonType.infrastructure;

import pokedex.pokemonType.application.GetPokemonTypes;
import pokedex.pokemonType.domain.PokemonTypeRepositoryConnectionException;
import pokedex.pokemonType.domain.PokemonTypes;
import pokedex.pokemonType.domain.exceptions.EmptyPokemonNameParameterException;
import pokedex.pokemonType.domain.exceptions.PokemonNotFoundException;
import pokedex.pokemonType.domain.exceptions.PokemonWithoutTypesException;

import java.util.Arrays;

public class GetPokemonTypeWithConsole {

    public static void main(String[] args) {
        var getPokemonType = new GetPokemonTypes(new PokeApiPokemonTypeRepository());
        if (args.length != 1) {
            System.out.println("No correct input");
            return;
        }
        try {
            var types = getPokemonType.execute(args[0]);
            System.out.println(getCommaSeparatedTypes(types));
        } catch (PokemonWithoutTypesException | EmptyPokemonNameParameterException |
                 PokemonTypeRepositoryConnectionException | PokemonNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getCommaSeparatedTypes(PokemonTypes types) {
        String jsonFormatTypes = Arrays.toString(types.getTypes());
        var commaSeparatedTypes = jsonFormatTypes.substring(1, jsonFormatTypes.length() - 1);
        return commaSeparatedTypes;
    }

}
