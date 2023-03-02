package pokedex.pokemon.application;

import pokedex.pokemon.domain.PokemonType;
import pokedex.pokemon.domain.PokemonTypeRepository;

import java.util.List;

public class GetPokemonType {

    private PokemonTypeRepository pokemonTypeRepository;

    public GetPokemonType(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    public List<PokemonType> execute(String pokemonName) {
        var types = pokemonTypeRepository.get(pokemonName);
        return types;
    }

}
