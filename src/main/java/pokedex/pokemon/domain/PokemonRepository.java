package pokedex.pokemon.domain;

public interface PokemonRepository {
    Pokemon getById(PokemonID pokemonID);
}
