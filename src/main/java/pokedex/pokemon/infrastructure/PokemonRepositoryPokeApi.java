package pokedex.pokemon.infrastructure;
import pokedex.pokemon.domain.Pokemon;
import pokedex.pokemon.domain.PokemonRepository;

import java.util.ArrayList;

public class PokemonRepositoryPokeApi implements PokemonRepository {
    public Pokemon get(String name){
        return new Pokemon("example",new ArrayList<>());
    }
}
