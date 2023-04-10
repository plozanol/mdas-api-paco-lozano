package pokedex.pokemon.application;

import pokedex.pokemon.domain.Pokemon;
import pokedex.pokemon.domain.PokemonID;
import pokedex.pokemon.domain.PokemonRepository;

public class GetPokemon {

    private final PokemonRepository pokemonRepository;

    public GetPokemon(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Pokemon execute(int pokemonID) {
        return pokemonRepository.getById(new PokemonID(pokemonID));
    }

}
