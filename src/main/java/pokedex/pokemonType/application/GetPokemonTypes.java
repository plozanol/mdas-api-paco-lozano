package pokedex.pokemonType.application;

import pokedex.pokemonType.domain.PokemonName;
import pokedex.pokemonType.domain.PokemonTypeCollection;
import pokedex.pokemonType.domain.PokemonTypeRepository;

public class GetPokemonTypes {

    private final PokemonTypeRepository pokemonTypeRepository;

    public GetPokemonTypes(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    public PokemonTypeCollection execute(String pokemonName) {
        var types = pokemonTypeRepository.get(new PokemonName(pokemonName));
        return types;
    }

}
