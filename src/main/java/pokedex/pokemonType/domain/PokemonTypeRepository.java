package pokedex.pokemonType.domain;

public interface PokemonTypeRepository {
    PokemonTypeCollection get(PokemonName pokemonName);
}
