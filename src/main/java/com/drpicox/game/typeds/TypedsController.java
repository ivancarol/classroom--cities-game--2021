package com.drpicox.game.typeds;

import com.drpicox.game.games.Game;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TypedsController {

    private final TypedsRepository typedsRepository;

    public TypedsController(TypedsRepository typedsRepository) {
        this.typedsRepository = typedsRepository;
    }

    public void create(String entityId, Game game, String entityType) {
        var component = new Typed(entityId, game, entityType);
        typedsRepository.save(component);
    }

    public List<Typed> findAllByGame(Game game) {
        return typedsRepository.findAllByGame(game);
    }
}