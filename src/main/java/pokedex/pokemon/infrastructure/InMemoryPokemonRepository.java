package pokedex.pokemon.infrastructure;

import org.springframework.stereotype.Repository;
import pokedex.pokemon.domain.Pokemon;
import pokedex.pokemon.domain.PokemonID;
import pokedex.pokemon.domain.PokemonRepository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryPokemonRepository implements PokemonRepository {
    private static final Map<Integer, Pokemon> memoryOfTrainers = new HashMap<>();

    @Override
    public boolean exist(PokemonID ID) {
        return memoryOfTrainers.containsKey(ID.ID());
    }

    @Override
    public Pokemon get(PokemonID ID) {
        return memoryOfTrainers.get(ID.ID());
    }

    @Override
    public void create(Pokemon pokemon) {
        memoryOfTrainers.put(pokemon.ID().ID(),pokemon);
    }

    @Override
    public void update(Pokemon pokemon) {
        memoryOfTrainers.put(pokemon.ID().ID(),pokemon);
    }
}
