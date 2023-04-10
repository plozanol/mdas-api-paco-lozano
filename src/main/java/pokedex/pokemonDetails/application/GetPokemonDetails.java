package pokedex.pokemonDetails.application;

import pokedex.pokemonDetails.domain.PokemonDetail;
import pokedex.pokemonDetails.domain.PokemonDetailRepository;
import pokedex.pokemonDetails.domain.PokemonID;
import pokedex.pokemonDetails.domain.exceptions.*;

public class GetPokemonDetails {

    private final PokemonDetailRepository pokemonDetailRepository;

    public GetPokemonDetails(PokemonDetailRepository pokemonDetailRepository) {
        this.pokemonDetailRepository = pokemonDetailRepository;
    }

    public PokemonDetail execute(int pokemonID) {
        return pokemonDetailRepository.getById(new PokemonID(pokemonID));
    }

}
