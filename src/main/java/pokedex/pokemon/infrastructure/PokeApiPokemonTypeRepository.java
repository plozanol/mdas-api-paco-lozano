package pokedex.pokemon.infrastructure;

import pokedex.pokemon.domain.PokemonType;
import pokedex.pokemon.domain.PokemonTypeRepository;

import java.util.Arrays;
import java.util.List;

public class PokeApiPokemonTypeRepository implements PokemonTypeRepository {
    public List<PokemonType> get(String name) {


        return List.of(new PokemonType("example"), new PokemonType("example"));
    }
}
