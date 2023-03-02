package pokedex.pokemon.infrastructure;

import pokedex.pokemon.application.GetPokemonType;

import java.util.Arrays;
public class GetPokemonTypeWithConsole {
    public static String main(String[] args) {
        var getPokemonType = new GetPokemonType(new PokeApiPokemonTypeRepository());
        var types = getPokemonType.execute(args[0]);
        String commaSeparatedTypes = Arrays.toString(types.toArray());

        return commaSeparatedTypes;
    }

}
