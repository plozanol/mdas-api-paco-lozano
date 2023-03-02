package pokedex.pokemon.domain;

import java.util.List;

public interface PokemonTypeRepository {
    public List<PokemonType> get(String pokemonName);
}
