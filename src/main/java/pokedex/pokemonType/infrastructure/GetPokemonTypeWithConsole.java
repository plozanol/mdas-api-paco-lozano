package pokedex.pokemonType.infrastructure;

import pokedex.pokemonType.application.GetPokemonType;
import pokedex.pokemonType.domain.PokemonTypeRepositoryConnectionException;
import pokedex.pokemonType.domain.exceptions.EmptyPokemonNameParameterException;
import pokedex.pokemonType.domain.exceptions.PokemonNotFoundException;
import pokedex.pokemonType.domain.exceptions.PokemonWithoutTypesException;

public class GetPokemonTypeWithConsole {

    public static void main(String[] args) {
        var getPokemonType = new GetPokemonType(new PokeApiPokemonTypeRepository());
        if (args.length != 1) {
            System.out.println("No correct input");
            return;
        }
        try {
            var types = getPokemonType.execute(args[0]);
            System.out.println(types.getCommaSeparatedTypes());
        } catch (PokemonWithoutTypesException | EmptyPokemonNameParameterException |
                 PokemonTypeRepositoryConnectionException | PokemonNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
